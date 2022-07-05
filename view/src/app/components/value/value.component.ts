import { Component, OnInit } from '@angular/core';
import { Make } from '../../models/make.model';
import { Model } from '../../models/model.model';
import { CarView } from '../../models/car.model';
import { CarHttpService } from '../../services/http/car-http.service';

@Component({
  selector: 'app-value',
  templateUrl: './value.component.html',
  styleUrls: ['./value.component.scss']
})
export class ValueComponent implements OnInit {
  makes: Make[] = [];
  models?: Model[] = [];
  cars: CarView[] = [];
  years: number[] = [];
  engineSizes: number[] = [];
  selectedMake?: Make;
  finalPrice: number = 0;

  constructor(private carHttpService: CarHttpService) {
  }

  ngOnInit(): void {
    this.years = this.createYears(1910, 2022);
    this.engineSizes = this.createEngineSizes(1.0, 9.0);
    this.carHttpService.getMakes().subscribe(makes => this.makes = makes);
  }

  valueCar() {
    this.finalPrice = 500;
  }

  onSelectMake() {
    this.models = this.selectedMake?.models;
  }

  createYears(start: number, end: number) {
    let items: number [] = [];
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
