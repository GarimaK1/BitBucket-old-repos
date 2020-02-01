import { Component, OnInit, OnDestroy } from '@angular/core';
import { ContactUs } from './contact-us.model';
import { ContactFormsService } from '../contactForms.service';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-contact-us-list',
  templateUrl: 'contact-us-list.component.html',
  styleUrls: ['contact-us-list.component.css']
})
export class ContactUsListComponent implements OnInit, OnDestroy {
  closed = false; // to dismiss alert
  displayAlert = false;

  private contactFormsSub: Subscription;
  contactForms: ContactUs[] = [];
  userIsAuthenticated = false;
  private authStatusListenerSub: Subscription;

  constructor(
    private contactFormsService: ContactFormsService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.contactFormsService.getContactForms();
    this.contactFormsSub = this.contactFormsService
      .getContactFormUpdatedListener()
      .subscribe((contactForms: ContactUs[]) => {
        this.contactForms = contactForms;
        this.closed = false;
      });
    this.userIsAuthenticated = this.authService.getIsAuthStatus();
    this.authStatusListenerSub = this.authService
      .getAuthStatusUpdateListener()
      .subscribe(isAuthenticated => {
        this.userIsAuthenticated = isAuthenticated;
      });
  }

  ngOnDestroy() {
    this.contactFormsSub.unsubscribe();
    this.authStatusListenerSub.unsubscribe();
  }

  onRefreshClick() {
    this.contactFormsService.getContactForms();
    this.displayAlert = false;
  }

  onDeleteForm(formId: string) {
    // console.log("I'm here! Formid: "+formId);
    this.contactFormsService.deleteForm(formId);
    this.closed = false;
    this.displayAlert = true;
  }
}
