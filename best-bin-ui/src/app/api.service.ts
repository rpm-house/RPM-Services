import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  public getProducts() {
    const cred = '{"userName":"mohan","password":"123"}';
    const currentUser = JSON.parse(cred);
    const localURL = `http://localhost:8080/api/product/getAll`;
    let  headers = new  HttpHeaders().set('X-TenantID', 'RPM').set('Authorization', `Basic UHJhbmlrYToxMjM=`);
    headers = headers.set('Connection', 'keep-alive');
    return this.httpClient.get(localURL, {headers});
  }

}
