import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AllInfoProductComponent } from './all-info-product/all-info-product.component';

const routes: Routes = [
  {path: 'infoAboutProduct', component: AllInfoProductComponent,
    children:[
      {
        path:':id', //:type is dynamic here
        component:AllInfoProductComponent
      }
    ]
  }
  // {path: 'infoAboutProduct', component: AllInfoProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
