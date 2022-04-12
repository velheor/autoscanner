import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Car } from '../../models/car.model';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { SearchCriteria, Sort } from '../../models/search.model';

@Injectable({
  providedIn: 'root'
})
export class CarHttpService {
  private CAR_URL = `${environment.apiServerUrl}/api/cars`;

  constructor(private http: HttpClient) {
  }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.CAR_URL}/all`);
  }

  getCarsPageable(page: number, count: number, sort: Sort): Observable<Car[]> {
    let params = new HttpParams().set('page', page).set('count', count).set('sort', sort);
    return this.http.get<Car[]>(`${this.CAR_URL}/all`,
      {
        params: params,
      });
  }

  filterCars(criteria: SearchCriteria): Observable<Car[]> {
    return this.http.post<Car[]>(this.CAR_URL, criteria);
  }

  getModels(make: string): Observable<string[]> {
    const params = new HttpParams().set('make', make);
    return this.http.post<string[]>(`${this.CAR_URL}/models`, params);
  }
}
