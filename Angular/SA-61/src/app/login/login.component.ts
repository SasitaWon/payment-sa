import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material';

import { PayService } from '../pay.service'; 
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

   ClinicStaff:any={
     nameStaff:'',
     password:''
   }

   check:any = '';

   constructor(private router: Router, private httpClient:HttpClient, private app : PayService) { }

    ngOnInit() {
    }

    login() {
      if(this.ClinicStaff.nameStaff === '' && this.ClinicStaff.password === ''){
        alert('กรอกข้อมูลให้ครบถ้วน');
        this.router.navigate(['paymentbill',{}]);
        
      }else {
        this.httpClient.get('http://localhost:9000/ClinicStaff/'+this.ClinicStaff.nameStaff+'/'+this.ClinicStaff.password,this.ClinicStaff)
        .subscribe(
          data => {
            this.check = data;
            console.log('PUT Request is successful',data);
            if(this.check === true){
              this.router.navigate(['paymentbill',{}]);
            }else{
              alert('username or password ไม่ถูกต้อง กรุณา login อีกครั้ง');
            }
          },

          error => {
            console.log('Error',error);
          }

        );
      }
    }
    }

