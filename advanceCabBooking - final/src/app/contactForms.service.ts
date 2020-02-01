import { Injectable } from '@angular/core';
import { ContactUs } from './contact-us-list/contact-us.model';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ContactFormsService {
  constructor(private http: HttpClient) {}
  private contactForms: ContactUs[] = [];
  private contactFormsUpdated = new Subject<ContactUs[]>();

  getContactFormUpdatedListener() {
    return this.contactFormsUpdated.asObservable();
  }

  getContactForms() {
    this.http
      .get<{ message: string; contactForms: any }>(
        'http://localhost:3000/api/ContactForms'
      )
      .pipe(
        map(responseData => {
          return responseData.contactForms.map(contactForm => {
            return {
              id: contactForm._id,
              name: contactForm.name,
              email: contactForm.email,
              phone: contactForm.phone,
              subject: contactForm.subject,
              message: contactForm.message
            };
          });
        })
      )
      .subscribe(responseData => {
        // console.log(responseData);
        this.contactForms = responseData;
        // console.log(this.contactForms);
        this.contactFormsUpdated.next([...this.contactForms]);
      }, error => {
        console.log("Error getting contact form: " + JSON.stringify(error));
      });
  }

  submitContactForm(formValue) {
    // console.log("Inside ContactFormsService, submitContactForm");
    // console.log(formValue);
    this.http
      .post<{ message: string }>(
        'http://localhost:3000/api/ContactForms',
        formValue
      )
      .subscribe(responseData => {
        console.log(responseData);
        this.contactForms.push(formValue);
        // console.log('Value of array' + this.contactForms);
        this.contactFormsUpdated.next([...this.contactForms]);
      }, error => {
        console.log("Error submitting contact form: " + JSON.stringify(error));
      });
  }

  deleteForm(formId: string) {
    this.http
      .delete<{ message: string }>(
        'http://localhost:3000/api/ContactForms/' + formId
      )
      .subscribe(responseData => {
        // console.log(responseData);
        const updatedContactForms = this.contactForms.filter(form => form.id !== formId);
        this.contactForms = updatedContactForms;
        this.contactFormsUpdated.next([...this.contactForms]);
      }, error => {
        console.log("Error deleting contact form: " + JSON.stringify(error));
      });
  }
}
