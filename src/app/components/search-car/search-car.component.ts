import { Component, OnInit } from '@angular/core';
import { CarHttpService } from '../../services/http/car-http.service';
import { Brand } from '../../models/make.model';
import { Model } from '../../models/model.model';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-search-car',
  templateUrl: './search-car.component.html',
  styleUrls: ['./search-car.component.scss']
})
export class SearchCarComponent implements OnInit {

  selectedMake: Brand = {
    brand: '',
    model: []
  };
  selectedModel: Model = {
    id: 0,
    model: ''
  };
  makes: Brand[] = [];
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
    this.models = this.selectedMake.model;
  }

  filterCars() {
    this.carHttpService.filterCars({
      brand: this.selectedMake.brand,
      model: this.selectedModel.model,
    }).subscribe(cars => {
      this.cars = cars;
    });
  }
}
