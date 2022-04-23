import { Component, OnInit } from '@angular/core';
import { CarHttpService } from '../../services/http/car-http.service';
import { Make } from '../../models/make.model';
import { Model } from '../../models/model.model';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-search-car',
  templateUrl: './search-car.component.html',
  styleUrls: ['./search-car.component.scss']
})
export class SearchCarComponent implements OnInit {

  selectedMake: Make = {
    name: '',
    models: []
  };
  selectedModel: Model = {
    name: ''
  };
  makes: Make[] = [];
  models: Model[] = [];
  cars: Car[] = [];

  constructor(private carHttpService: CarHttpService) {
  }

  ngOnInit(): void {
    this.carHttpService.getMakes().subscribe(makes => {
      this.makes = makes;
    });
  }

  onSelectMake() {
    console.log(this.selectedMake);
    this.models = this.selectedMake.models;
  }

  filterCars() {
    this.carHttpService.filterCars({
      brand: this.selectedMake.name,
      model: this.selectedModel.name,
    }).subscribe(cars => {
      this.cars = cars;
    });
  }
}
