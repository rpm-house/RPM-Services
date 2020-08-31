import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';

const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'login', component: LoginComponent},
  {path: 'header', component: HeaderComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
