import { Component, OnInit } from '@angular/core';
import { GetAllServiceService } from '../get-all-service.service';
import * as CryptoJS from 'crypto-js';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  conversionEncryptOutput: any;
  plainText: any;
  encPassword: any;
  conversionDecryptOutput: any;
  encryptText: any;
  decPassword: any;
  submitted: boolean;
  loading: boolean;
  authenticationService: any;
  returnUrl: any;
  error: boolean;
  errorText: any;

  constructor(private service: GetAllServiceService,
              private router: Router,
              private formBuilder: FormBuilder,
              private location: Location) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });

  // get return url from route parameters or default to '/'
  // this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }
  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    const loginObj: any = {};
    loginObj.name = this.f.username.value;
    loginObj.password = this.f.password.value;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
        return;
    }
    // tslint:disable-next-line: no-unused-expression
    const cred = this.f.username.value + ':' + this.f.password.value ;
    this.loading = true;
    this.service.loginService(loginObj).subscribe(data => {
      console.log('response' + data);
      if (data === true) {
        localStorage.setItem('login', window.btoa(cred));
        localStorage.setItem('userName', this.f.username.value);
        this.router.navigateByUrl('/header', {skipLocationChange: true}).then(() => {
          console.log('url' + decodeURI(this.location.path()));
          this.router.navigate(['/']);
        });
        } else {
        console.log('false');
        this.error = true ;
        this.loading = false;
        this.errorText = 'User and Password not Matched';
            }
  });
}

  convertText(conversion: string, obj: any) {

    if (conversion === 'encrypt') {
      this.conversionEncryptOutput = CryptoJS.AES.encrypt(this.plainText, JSON.stringify(obj)).toString();
      localStorage.setItem('login', this.conversionEncryptOutput);
    } else {
      this.conversionDecryptOutput = CryptoJS.AES.decrypt(this.encryptText.trim(), this.decPassword.trim()).toString(CryptoJS.enc.Utf8);

  }
}
}
