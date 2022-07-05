import { Component, OnInit } from '@angular/core';
import { Make } from '../../models/make.model';
import { Model } from '../../models/model.model';
import { CarView, Global } from '../../models/car.model';
import { SearchCriteria } from '../../models/search.model';
import { CarHttpService } from '../../services/http/car-http.service';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  searchCriteria: SearchCriteria = new SearchCriteria;
  makes: Make[] = [];
  models: Model[] = [];
  cars: CarView[] = [];
  years: number[] = [];
  engineSizes: number[] = [];

  public scatterChartOptions: ChartOptions = {
    responsive: true,
  };

  public scatterChartData: ChartDataset[] = Global.scatterChartData;
  public scatterChartType: ChartType = 'scatter';

  constructor(private carHttpService: CarHttpService) {
  }

  ngOnInit(): void {
    // this.carHttpService.getMakes().subscribe(makes => {
    //   this.makes = makes;
    // });
    this.years = this.createYears(1910, 2022);
    this.engineSizes = this.createEngineSizes(1.0, 9.0);
    this.carHttpService.getMakes().subscribe(makes => this.makes = makes);
  }

  onSelectMake() {
    this.models = this.searchCriteria.make.models;
  }

  filterCars() {
    this.cars = Global.searched;
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

  addToSaved(car: CarView) {
    car.isSaved = !car.isSaved;
    Global.saved.indexOf(car) === -1 ? Global.saved.push(car) : Global.saved.splice(Global.saved.indexOf(car), 1);
  }

  addToCompared(car: CarView) {
    car.isCompared = !car.isCompared;
    Global.compared.indexOf(car) === -1 ? Global.compared.push(car) : Global.compared.splice(Global.compared.indexOf(car), 1);
  }
}
