import { Component, OnInit, OnDestroy } from '@angular/core';
import { ContactUs } from './contact-us.model';
import { ContactFormsService } from '../contactForms.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-contact-us-list',
  templateUrl: 'contact-us-list.component.html',
  styleUrls: ['contact-us-list.component.css']
})
export class ContactUsListComponent implements OnInit, OnDestroy {
  private contactFormsSub: Subscription;
  contactForms: ContactUs[] = [];

  constructor(public contactFormsService: ContactFormsService) {}

  ngOnInit() {
    this.contactFormsService.getContactForms();
    this.contactFormsSub = this.contactFormsService
      .getContactFormUpdatedListener()
      .subscribe((contactForms: ContactUs[]) => {
        this.contactForms = contactForms;
      });
  }

  ngOnDestroy() {
    this.contactFormsSub.unsubscribe();
  }

  onClick() {
    this.contactFormsService.getContactForms();
  }

  onDeleteForm(formId: string) {
    // console.log("I'm here! Formid: "+formId);
    this.contactFormsService.deleteForm(formId);
  }
}
