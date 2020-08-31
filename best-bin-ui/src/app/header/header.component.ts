import { Component, OnInit } from '@angular/core';
import { GetAllServiceService } from '../get-all-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private service: GetAllServiceService) { }
  bbLogo = './assets/BestBinLogo.png' ;
  isLoggedIn: boolean;
  name: any;
  cartCount: any;
  ngOnInit() {
    console.log('coming');

    this.name = localStorage.getItem('userName') !== null ? localStorage.getItem('userName') : '';
    this.cartCount = '(' + (localStorage.getItem('count') !== null  ? localStorage.getItem('count') : '0') + ')' ;
    this.isLoggedIn = this.service.isLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
}
logout() {
 if (this.service.isLoggedIn()) {
   localStorage.removeItem('login');
   localStorage.removeItem('userName');
 }

  }
}

