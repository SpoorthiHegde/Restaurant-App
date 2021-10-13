import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { AddItemComponent } from './add-item/add-item.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CartDetailsComponent } from './cart-details/cart-details.component';

const routes: Routes = [
  {path:'register',component:RegisterComponent ,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'menu',component:MenuComponent,pathMatch:'full'},
  {path:'footer',component:FooterComponent,pathMatch:'full'},
  {path:'add-item',component:AddItemComponent,pathMatch:'full'},
  {path:'admin-menu',component:AdminMenuComponent,pathMatch:'full'},
  {path:'update-item/:itemName',component:UpdateItemComponent,pathMatch:'full'},

  {path:'update-user/:userName',component:UpdateUserComponent},
  {path:'user-details/:userName',component:UserDetailsComponent,pathMatch:'full'},
  {path:'cart-details',component:CartDetailsComponent,pathMatch:'full'},


  // {path:"",redirectTo:"home",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
