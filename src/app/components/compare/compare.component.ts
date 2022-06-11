import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.scss']
})
export class CompareComponent implements OnInit {


  cars: Car[] = [];

  constructor() {
  }

  ngOnInit(): void {
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
    }];
  }
}
