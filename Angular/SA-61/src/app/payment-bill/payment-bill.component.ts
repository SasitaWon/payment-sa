import { Component, OnInit } from '@angular/core';
//import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { PayService } from '../pay.service';

import { MyDialogComponent } from '../my-dialog/my-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-payment-bill',
  templateUrl: './payment-bill.component.html',
  styleUrls: ['./payment-bill.component.css']
})
export class PaymentBillComponent implements OnInit {

  nameStaff: Array<any>;
  nameStaffSelect='';

  namePatient: Array<any>;
  namePatientSelect='';

  medR : Array<any>;
  

  medicine : Array<any>;
  medicineSelect= '';

  sum:any=0;
  
  


  displayedColumns: string[] = ['no', 'name', 'amount', 'type','price'];
  
  //dataSource = ELEMENT_DATA;


  
 /* data:  [
    {value: 'medicine-0', price: 59},
    {value: 'medicine-1', price: 159},
    {value: 'tacos-2', price: 20}
  ];*/
  
  

  constructor(private pay:PayService, private httpClient: HttpClient,public dialog:MatDialog) { }

  ngOnInit() {
    this.pay.getClinicStaff().subscribe(data=>{
        this.nameStaff = data;
        console.log(this.nameStaff);
    })
    this.pay.getPatient().subscribe(data=>{
      this.namePatient =  data;
      console.log(this.namePatient);
  })

    this.pay.getMedicalRecord().subscribe(data=>{
      this.medR = data;
      console.log(this.medR);
    })

    this.pay.getMedicine().subscribe(data =>{
      this.medicine = data;
      console.log(this.medicine);
      
    })

  }
  print(){
    this.httpClient.post('http://localhost:9000/Payment/' + this.nameStaffSelect + '/' + this.namePatientSelect, {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
      },
      error =>{
        console.log('Error',error);
      }
      
    );
  }
  paybut(){
    this.httpClient.post('http://localhost:9000/Payment/' + this.medicineSelect , {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
      },
      error =>{
        console.log('Error',error);
      }
      
    );
  }
  openDialog() : void{
    let dialogRef = this.dialog.open(MyDialogComponent,{
      
        data:{
          total: this.medicineSelect[0]
         
        }  
    });
    dialogRef.afterClosed().subscribe(result =>{
      console.log('The dialog was closed');
      console.log(result);
    });
    
  }  
}
/*export interface Price {
  value: string;
  price: number
}*/
/*export interface PeriodicElement {
  name: string;
  no: number;
  amount: number;
  type: string;
 
}
const ELEMENT_DATA: PeriodicElement[] = [
  {no: 1, name: 'ยาพารา', amount: 11, type: 'แผง'},
  {no: 2, name: 'ยาแก้ไอ', amount: 99, type: 'ขวด'}
  
  
];*/

