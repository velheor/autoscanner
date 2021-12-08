import {Injectable} from "@angular/core";
import {Car} from "../models/car";
import {Observable} from "rxjs";
import {CarRemoteService} from "./remote/car.remote.service";
import {SearchCriteria} from "../models/searchCriteria";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  cars: Car[] = [];

  constructor(private carRemoteService: CarRemoteService) {
  }

  filterCars(search: SearchCriteria) {
    let car = new class implements Car {
      brand: string = `test`;
      imageLink: string = `https://www.ixbt.com/img/x780/n1/news/2021/10/5/084ed9e98d6d6c45ac49b1474002d2f0_large_large.jpg`;
      link: string = `test`;
      model: string = `test`;
      price: number = 228;
      year: number = 228;
    }
    this.cars.push(car);
   /* return this.carRemoteService.filterCars(search)
      .subscribe((cars: Car[]) => this.cars = cars);*/
  }
}
