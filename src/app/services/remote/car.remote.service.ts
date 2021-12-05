import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../../models/car";
import {SearchCriteria} from "../../models/searchCriteria";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CarRemoteService {
  private CAR_URL = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.CAR_URL}/all`);
  }

  filterCars(criteria: SearchCriteria): Observable<Car[]> {
    return this.http.post<Car[]>(`${this.CAR_URL}/filter`, criteria);
  }

  getModels(make: string): Observable<string[]> {
    const params = new HttpParams().set('make', make);
    return this.http.post<string[]>(`${this.CAR_URL}/models`, params);
  }
}
