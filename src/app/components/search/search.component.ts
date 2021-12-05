import {Component, OnInit} from '@angular/core';
import {Car} from "../../models/car";
import {CarRemoteService} from "../../services/remote/car.remote.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  cars: Car[] = [];
  makes: string[] = [];
  models: string[] = [];

  constructor(private carRemoteService: CarRemoteService) {
  }

  ngOnInit(): void {
    this.getCars();
  }

  private getCars() {
    this.carRemoteService.getCars().subscribe(
      (cars: Car[]) => {
        this.cars = cars;
      }
    )
  }

  public getModels(make: string) {
    this.carRemoteService.getModels(make).subscribe(
      (models: string[]) => {
        this.models = models;
      }
    )
  }
}
