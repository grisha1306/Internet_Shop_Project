import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AllInfoProductComponent } from './all-info-product/all-info-product.component';
import {LoginComponent} from "./login/login.component";
import {AllProductsComponent} from "./all-product/all-product.component";
import {RegistrationComponent} from "./registration/registration.component";
import {OrderComponent} from "./order/order.component";
import {AllUserComponent} from "./all-user/all-user.component";

const routes: Routes = [
  {path: 'allProducts', component: AllProductsComponent},
  {path: 'infoAboutProduct', component: AllInfoProductComponent,
    children:[
      {
        path:':id', //:type is dynamic here
        component:AllInfoProductComponent
      }
    ]
  },
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'addToOrder', component: OrderComponent,
    children:[
      {
        path:':id', //:type is dynamic here
        component:OrderComponent
      }
    ]
  },
  {path: 'userOrder', component: OrderComponent},
  {path: 'getAllUsers', component: AllUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
