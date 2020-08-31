import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class GetAllServiceService {
  body: any;
 credentials = 'Mohan:123';
  localUrl = 'http://localhost:8080/api/';
  conversionEncryptOutput: any;
  conversionDecryptOutput: any;
  encryptText: any;
  decPassword: any;
  basicAuth = 'Basic ' + window.btoa(this.credentials);

  constructor(private http: HttpClient) { }

  getAllProductList() {
    const productlistAPI = 'product/getAll';
    const headers = new HttpHeaders().set('X-TenantID', 'test').set('Authorization', this.basicAuth);
    return this.http.get(this.localUrl + productlistAPI, {headers});
  }

  postTransactionData(data: object) {
    console.log('coming to service module:' + JSON.stringify(data));
    const createTransactionAPI = `transaction/create`;
    this.body = JSON.stringify(data);
    const headers = new HttpHeaders().set('X-TenantID', 'test').set('Authorization', this.basicAuth)
    .set('Content-Type', 'application/json');
    return this.http.post(this.localUrl + createTransactionAPI, this.body, {headers});
  }

  loginService(data: object) {
    console.log('coming to service module:' + JSON.stringify(data));
    const loginAPI = 'user/login';
    this.body = JSON.stringify(data);
    const headers = new HttpHeaders().set('X-TenantID', '').set('Authorization', this.basicAuth)
    .set('Content-Type', 'application/json');
    return this.http.post(this.localUrl + loginAPI, this.body, {headers});
  }

  isLoggedIn() {

      const isLoggedInUser = (localStorage.getItem('login') !== null ) ? true : false;
      return isLoggedInUser;
  }


}
