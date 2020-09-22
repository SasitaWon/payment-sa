import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class PayService {
  
  public API = '//localhost:9000';

  constructor(private http: HttpClient) { }

   getClinicStaff() : Observable<any>{
    return this.http.get(this.API+'/ClinicStaff');
  }

    getPatient() :  Observable<any>{
    return this.http.get(this.API+'/Patient');
  }

    getMedicalRecord() : Observable<any>{
      return this.http.get(this.API+'/MedicalRecord');
    }

    getMedicine() : Observable<any>{
      return this.http.get(this.API+'/Medicine')
    }
  
}