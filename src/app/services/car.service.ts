import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car, SearchCriteria } from '../models/car.model';
import { CarHttpService } from './http/car.http.service';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  constructor(private carHttpService: CarHttpService) {
  }

  getCars(): Observable<Car[]> {
    return this.carHttpService.getCars();
  }

  filterCars(criteria: SearchCriteria): Observable<Car[]> {
    return this.carHttpService.filterCars(criteria);
  }

  getModels(make: string): Observable<string[]> {
    return this.carHttpService.getModels(make);
  }
}
