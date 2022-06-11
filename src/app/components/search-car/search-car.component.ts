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

  constructor(private carHttpService: CarHttpService) {
  }

  ngOnInit(): void {
    // this.carHttpService.getMakes().subscribe(makes => {
    //   this.makes = makes;
    // });
    this.cars = [{
      'make': 'Audi',
      'model': '80',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '1.8',
      'year': 1987,
      'price': 540.00,
      'link': 'https://cars.av.by/audi/80/100967626',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6312/9237.jpg',
      'mileage': '330000'
    }, {
      'make': 'Audi',
      'model': '80',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '1.8',
      'year': 1989,
      'price': 600.00,
      'link': 'https://cars.av.by/audi/80/101152095',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/7153/9706.jpg',
      'mileage': '350000'
    }, {

      'make': 'Audi',
      'model': '100',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '2.2',
      'year': 1985,
      'price': 600.00,
      'link': 'https://cars.av.by/audi/100/100963856',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6317/9629.jpg',
      'mileage': '400000'
    }, {

      'make': 'Audi',
      'model': '100',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '2.0',
      'year': 1985,
      'price': 600.00,
      'link': 'https://cars.av.by/audi/100/100586903',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/4416/7423.jpeg',
      'mileage': '350000'
    }, {

      'make': 'Audi',
      'model': '80',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '1.8',
      'year': 1990,
      'price': 650.00,
      'link': 'https://cars.av.by/audi/80/100717786',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6854/3789.jpg',
      'mileage': '120000'
    }, {

      'make': 'Audi',
      'model': '90',
      'vehicleType': 'SEDAN',
      'engineType': 'DIESEL',
      'engineCapacity': '1.6',
      'year': 1991,
      'price': 793.00,
      'link': 'https://cars.av.by/audi/90/100872889',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/5848/2988.jpeg',
      'mileage': '458363'
    }, {
      'make': 'Audi',
      'model': '100',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '2.2',
      'year': 1983,
      'price': 800.00,
      'link': 'https://cars.av.by/audi/100/101123944',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6808/7500.jpg',
      'mileage': '500000'
    }, {
      'make': 'Audi',
      'model': '100',
      'vehicleType': 'SEDAN',
      'engineType': 'DIESEL',
      'engineCapacity': '2.0',
      'year': 1987,
      'price': 800.00,
      'link': 'https://cars.av.by/audi/100/101017315',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6491/2042.jpg',
      'mileage': '415000'
    }, {

      'make': 'Audi',
      'model': '100',
      'vehicleType': 'WAGON',
      'engineType': 'PETROL',
      'engineCapacity': '1.8',
      'year': 1987,
      'price': 800.00,
      'link': 'https://cars.av.by/audi/100/101045751',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6585/8042.jpg',
      'mileage': '111111'
    }, {
      'make': 'Audi',
      'model': '80',
      'vehicleType': 'SEDAN',
      'engineType': 'PETROL',
      'engineCapacity': '1.8',
      'year': 1989,
      'price': 850.00,
      'link': 'https://cars.av.by/audi/80/100724956',
      'imageLink': 'https://avcdn.av.by/advertpreview/0000/6461/4200.jpg',
      'mileage': '350000'
    }];
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
