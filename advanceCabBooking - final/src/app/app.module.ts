import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AgmCoreModule } from '@agm/core';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BookOnlineComponent } from './book-online/book-online.component';
import { BookOnlineListComponent } from './book-online-list/book-online-list.component';
import { BookOnlineEditComponent } from './book-online-edit/book-online-edit.component';
import { FareInfoComponent } from './fare-info/fare-info.component';
import { AreasServedComponent } from './areas-served/areas-served.component';
import { AppRoutingModule } from './app-routing.module';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ContactUsListComponent } from './contact-us-list/contact-us-list.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { AuthInterceptor } from './auth/auth-interceptor';
import { ErrorInterceptor } from './error-interceptor';
import { ErrorComponent } from './error/error.component';
import { PaymentDialogComponent } from "./payment/payment.component";
import { BookingStatusComponent } from './booking-status/booking-status.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BookOnlineComponent,
    BookOnlineListComponent,
    BookOnlineEditComponent,
    FareInfoComponent,
    AreasServedComponent,
    ContactUsComponent,
    ContactUsListComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    ErrorComponent,
    PaymentDialogComponent,
    BookingStatusComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatToolbarModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FlexLayoutModule,
    MatButtonModule,
    MatExpansionModule,
    MatSelectModule,
    MatDialogModule,
    MatSnackBarModule,
    NgbAlertModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDvglCwYaOiZB9rZ2Mo07ormQXsDU9Ljj0",
      libraries: ["places"]
    }),
    NgbAlertModule.forRoot()
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent],
  entryComponents: [ErrorComponent, PaymentDialogComponent]
})
export class AppModule {}
