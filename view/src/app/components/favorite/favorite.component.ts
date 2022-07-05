import { Component, OnInit } from '@angular/core';
import { CarView, Global } from '../../models/car.model';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.scss']
})
export class FavoriteComponent implements OnInit {

  cars: CarView[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.cars = Global.saved;
  }

  addToCompared(car: CarView) {
    car.isCompared = !car.isCompared;
    Global.compared.indexOf(car) === -1 ? Global.compared.push(car) : Global.compared.splice(Global.compared.indexOf(car), 1);
  }

  setAlert(car: CarView) {
    car.setAlert = !car.setAlert;
  }

  follower(): number {
    return Math.floor(Math.random() * 10) + 1;
  }
}
