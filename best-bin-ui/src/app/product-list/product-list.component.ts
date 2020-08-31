import { Component, OnInit } from '@angular/core';
import { GetAllServiceService } from '../get-all-service.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: object;
  cartProduct = [];
  imageSrc = './assets/cart.jpg' ;
  imageAlt = 'Add to cart';
  finalObject: object;
  page = 1;
  constructor(private productsList: GetAllServiceService,
              private sanitizer: DomSanitizer ,
              private router: Router,
              private location: Location) { }

  ngOnInit() {
    this.productsList.getAllProductList().subscribe(data => {
      this.products = data;
      console.log(this.products);
    }
      );
  }

  transform(imgValue) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(
      'data:image/png;base64,' + imgValue
    );
  }

  addToCart(productId, productCount, productName, productPrice){
    this.getProductArray();
    console.log('coming to add to cart method' + productId + 'and' + productCount + 'product name' + productName);
    let grandTotal = 0;
    let totalQuantity: any;
    if (this.cartProduct.length > 0) {
      let update = false;
      for (let i = 0; i < this.cartProduct.length; i++) {
        console.log('productId' + this.cartProduct[i].productId + update);
        if ( this.cartProduct[i].productId === productId){
          console.log('count');
          this.cartProduct[i].quantity = productCount ;
          this.cartProduct[i].price = productCount * productPrice ;
          update = true;
          break;
        }
     }
      if ( update === false) {
      const cartProductObject: any = {};
      cartProductObject.productId = productId;
      cartProductObject.quantity = productCount;
      cartProductObject.productName = productName;
      cartProductObject.price = productCount * productPrice;
      this.cartProduct.push(cartProductObject);
    }
    }
    else {
    const cartProductObject: any = {};
    cartProductObject.productId = productId;
    cartProductObject.quantity = productCount;
    cartProductObject.productName = productName;
    cartProductObject.price = productCount * productPrice;
    this.cartProduct.push(cartProductObject);
    }
    grandTotal = this.getTotalPrice(grandTotal, this.cartProduct);
    this.finalObject = {
      'grandTotal': grandTotal,
      'products' : this.cartProduct
    }
    console.log('Final Json' + JSON.stringify(this.finalObject));
    localStorage.setItem('cartProduct', JSON.stringify(this.finalObject));
    localStorage.setItem('count', this.cartProduct.length.toString());
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      console.log('url' + decodeURI(this.location.path()));
      this.router.navigate(['/']);
    });
  }

  getTotalPrice(amount, cartProduct){
    for (let i = 0; i < cartProduct.length; i++){
      console.log('Total Proce: ' + amount);
      amount = amount + cartProduct[i].price ;
    }
    return amount;
  }

  getProductArray(){
    if( localStorage.getItem('cartProduct') !== null){
      let test:object;
     // test = localStorage.getItem('cartProduct').get();
      //alert('test'+test);
    }
  }
  submit(){
    console.log('coming');
    this.productsList.postTransactionData(this.finalObject).subscribe(data => {
      console.log('response' + data);
    }
      );
  }

  onScroll() {
    this.page++ ;
    console.log('Page' + this.page);
}
}
