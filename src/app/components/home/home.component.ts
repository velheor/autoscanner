import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car.model';
import { CarHttpService } from '../../services/http/car-http.service';
import { Sort } from '../../models/search.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  cars: Car[];

  constructor(private carHttpService: CarHttpService) {
    this.cars = [];
  }

  ngOnInit(): void {
    this.carHttpService.getCarsPageable(0, 10, Sort.Latest).subscribe((cars: Car[]) => {
      this.cars = cars;
    });
  }
}
