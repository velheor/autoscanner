import {Component, OnInit} from '@angular/core';
import {CarRemoteService} from "../../services/remote/car.remote.service";
import {SearchCriteria} from "../../models/searchCriteria";
import {Router} from "@angular/router";
import {CarService} from "../../services/cars.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  brands: string[] = [];
  models: string[] = [];
  years: number[] = [];
  searchCriteria: SearchCriteria = new SearchCriteria();

  constructor(private carRemoteService: CarRemoteService, private router: Router, private carService: CarService) {
  }

  ngOnInit(): void {
  }

  getModels(make: string) {
    this.carRemoteService.getModels(make).subscribe(
      (models: string[]) => {
        this.models = models;
      }
    )
  }

  search() {
    this.carService.filterCars(this.searchCriteria);
    this.router.navigate([`/cars`]);
  }
}
