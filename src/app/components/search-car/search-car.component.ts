import { Component, OnInit } from '@angular/core';
import { CarHttpService } from '../../services/http/car-http.service';
import { Make } from '../../models/make.model';
import { Model } from '../../models/model.model';
import { Car } from '../../models/car.model';
import { SearchCriteria } from '../../models/search.model';

@Component({
  selector: 'app-search-car',
  templateUrl: './search-car.component.html',
  styleUrls: ['./search-car.component.scss']
})
export class SearchCarComponent implements OnInit {
  searchCriteria: SearchCriteria = new SearchCriteria;
  makes: Make[] = [];
  models: Model[] = [];
  cars: Car[] = [];
  years: number[] = [];
  engineSizes: number[] = [];
  fuelTypes: FuelType[] = [FuelType.Gasoline, FuelType.Diesel, FuelType.Ethanol];

  constructor(private carHttpService: CarHttpService) {
  }

  ngOnInit(): void {
    // this.carHttpService.getMakes().subscribe(makes => {
    //   this.makes = makes;
    // });
    this.years = this.createYears(1910, 2022);
    this.engineSizes = this.createEngineSizes(1.0, 9.0);
  }

  onSelectMake() {
    this.models = this.searchCriteria.make.models;
  }

  filterCars() {
    this.carHttpService.filterCars(this.searchCriteria)
      .subscribe(cars => {
        this.cars = cars;
      });
  }

  createYears(start: number, end: number) {
    let items: number[] = [];
    for (let i = end; i >= start; i--) {
      items.push(i);
    }
    return items;
  }

  createEngineSizes(start: number, end: number) {
    let items: number[] = [];
    for (let i = end; i >= start; i = i - 0.1) {
      items.push(Number(i.toFixed(1)));
    }
    return items;
  }
}
