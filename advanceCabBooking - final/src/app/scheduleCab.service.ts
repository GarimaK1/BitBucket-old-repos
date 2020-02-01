import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { ScheduleCab } from "./book-online/scheduleCab.model";
import { Subject } from "rxjs";
import { map } from "rxjs/operators";
import * as moment from "moment";

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

  submitScheduleCabForm(scheduleCabForm: ScheduleCab) {
    this.http
      .post<{ message: string }>(
        "http://localhost:3000/api/scheduleCabForm",
        scheduleCabForm
      )
      .subscribe(responseData => {
        console.log(responseData.message);
      }, error => {
        console.log(
          "Error submitting schedule cab form: " + JSON.stringify(error)
        );
      });
  }

  editScheduleCabForm(editScheduleCabFormId: string, editScheduleCabForm: ScheduleCab) {
    this.http
      .put<{ message: string, scheduleCabForm: any }>(
        "http://localhost:3000/api/scheduleCabForm/" + editScheduleCabFormId,
        editScheduleCabForm
      )
      .subscribe(
        responseData => {
          console.log(responseData.message);
          const updatedScheduleCabForms = this.scheduleCabForms;
          const oldFormIndex = updatedScheduleCabForms.findIndex(
            form => form.id === editScheduleCabFormId
          );
          updatedScheduleCabForms[oldFormIndex] = editScheduleCabForm;
          this.scheduleCabForms = updatedScheduleCabForms;
          this.scheduleCabFormsUpdated.next([...this.scheduleCabForms]);
        },
        error => {
          console.log(
            "Error submitting edited schedule cab form: " +
              JSON.stringify(error)
          );
        }
      );
  }

  getScheduleCabForm(formId: string) {
    return this.http
      .get<{ message: string; scheduleCabForm: any}>(
        "http://localhost:3000/api/scheduleCabForm/" + formId
      );
  }

  getScheduleCabForms() {
    // return [...this.scheduleCabForms];
    this.http
      .get<{ message: string; cabForms: any}>(
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
              pickup_date: moment(cabForm.pickup_date).format('LL'),
              pickup_time: cabForm.pickup_time,
              passengers: cabForm.passengers,
              pickup_location: cabForm.pickup_location,
              drop_location: cabForm.drop_location,
              creator: cabForm.creator
            };
          });
        })
      )
      .subscribe(responseData => {
        console.log(responseData);
        this.scheduleCabForms = responseData;
        this.scheduleCabFormsUpdated.next([...this.scheduleCabForms]);
      }, error => {
        console.log(
          "Error getting schedule cab form: " + JSON.stringify(error)
        );
      });
  }

  onDeleteForm(scheduleCabFormId) {
    // console.log(scheduleCabFormId);
    this.http
      .delete<{ message: string; scheduleCabForm: any }>(
        "http://localhost:3000/api/scheduleCabForm/" + scheduleCabFormId
      )
      .subscribe(responseData => {
        // console.log(responseData);
        const updatedScheduleCabForms = this.scheduleCabForms
        .filter(form => form.id !== scheduleCabFormId);
        this.scheduleCabForms = updatedScheduleCabForms;
        this.scheduleCabFormsUpdated.next([...this.scheduleCabForms]);
      }, error => {
        console.log(
          "Error deleting schedule cab form: " + JSON.stringify(error)
        );
      });
  }
}
