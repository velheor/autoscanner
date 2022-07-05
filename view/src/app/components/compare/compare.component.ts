import { Component, OnInit } from '@angular/core';
import { CarView, Global } from '../../models/car.model';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.scss']
})
export class CompareComponent implements OnInit {


  cars: CarView[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.cars = Global.compared;
  }

  addToSaved(car: CarView) {
    car.isSaved = !car.isSaved;
    Global.saved.indexOf(car) === -1 ? Global.saved.push(car) : Global.saved.splice(Global.saved.indexOf(car), 1);
  }
}
