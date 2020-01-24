import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ScheduleCab } from './book-online-list/scheduleCab.model';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: "root"
})
export class ScheduleCabService {
  constructor(private http: HttpClient) {}

  private scheduleCabForms: ScheduleCab[] = [];
  private scheduleCabFormsUpdated = new Subject<ScheduleCab[]>();

  getScheduleCabFormsUpdateListener() {
    return this.scheduleCabFormsUpdated.asObservable();
  }

  submitScheduleCabForm(scheduleCabForm) {
    this.http
      .post<{ message: string }>(
        "http://localhost:3000/api/scheduleCabForm",
        scheduleCabForm
      )
      .subscribe(responseData => {
        console.log(responseData);
      });
  }

  getScheduleCabForms() {
    // return [...this.scheduleCabForms];
    this.http
      .get<{ message: string; cabForms: any }>(
        "http://localhost:3000/api/scheduleCabForm"
      )
      .pipe(
        map(responseData => {
          return responseData.cabForms.map(cabForm => {
            return {
              id: cabForm._id,
              name: cabForm.name,
              email: cabForm.email,
              phone: cabForm.phone,
              pickup_date: cabForm.pickup_date,
              pickup_time: cabForm.pickup_time,
              passengers: cabForm.passengers,
              pickup_location: cabForm.pickup_location,
              drop_location: cabForm.drop_location
            };
          });
        })
      )
      .subscribe(responseData => {
        console.log(responseData);
        this.scheduleCabForms = responseData;
        this.scheduleCabFormsUpdated.next([...this.scheduleCabForms]);
      });
  }

  onDeleteForm(scheduleCabFormId) {
    // console.log(scheduleCabFormId);
    this.http
      .delete<{ message: string, scheduleCabForm: any}>(
        "http://localhost:3000/api/scheduleCabForm/" + scheduleCabFormId
      )
      .subscribe(responseData => {
        console.log(responseData.message);
      });
  }
}
