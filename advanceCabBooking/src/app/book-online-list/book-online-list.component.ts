import { Component, OnInit, OnDestroy } from '@angular/core';
import { ScheduleCab } from './scheduleCab.model';
import { ScheduleCabService } from '../scheduleCab.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-book-online-list',
  templateUrl: 'book-online-list.component.html',
  styleUrls: ['book-online-list.component.css']
})
export class BookOnlineListComponent implements OnInit, OnDestroy {
  constructor(public scheduleCabService: ScheduleCabService) {}

  scheduleCabForms: ScheduleCab[] = [];
  scheduleCabFormsUpdateSub = new Subscription();

  onClick() {
    this.scheduleCabService.getScheduleCabForms();
  }

  ngOnInit() {
    this.scheduleCabService.getScheduleCabForms();
    this.scheduleCabFormsUpdateSub = this.scheduleCabService
    // to listen to:
    // this.scheduleCabFormsUpdated.next([...this.scheduleCabForms]);
    // in ScheduleCabService
      .getScheduleCabFormsUpdateListener()
      .subscribe(scheduleCabForms => {
        this.scheduleCabForms = scheduleCabForms;
      });
  }

  ngOnDestroy() {
    this.scheduleCabFormsUpdateSub.unsubscribe();
  }
}
