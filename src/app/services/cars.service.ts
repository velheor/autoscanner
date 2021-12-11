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
    return this.carRemoteService.filterCars(search)
      .subscribe((cars: Car[]) => this.cars = cars);
  }
}
