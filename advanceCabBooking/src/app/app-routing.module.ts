import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FareInfoComponent } from './fare-info/fare-info.component';
import { BookOnlineComponent } from './book-online/book-online.component';
import { AreasServedComponent } from './areas-served/areas-served.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ContactUsListComponent } from './contact-us-list/contact-us-list.component';
import { BookOnlineListComponent } from './book-online-list/book-online-list.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';

const routes: Routes = [
  { path: "", component: BookOnlineComponent },
  { path: "book-online", component: BookOnlineComponent },
  { path: "fare", component: FareInfoComponent },
  { path: "areas-served", component: AreasServedComponent },
  { path: "contact-us", component: ContactUsComponent },
  { path: "contact-us-list", component: ContactUsListComponent },
  { path: "schedule-cab-list", component: BookOnlineListComponent },
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
