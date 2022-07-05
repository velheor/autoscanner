import { Make } from './make.model';
import { Model } from './model.model';

export class SearchCriteria {
  make: Make = {
    name: '',
    models: []
  };
  model: Model = {
    name: ''
  };
  fromYear: number = 0;
  toYear: number = 0;
  fromEngineSize: number = 0;
  toEngineSize: number = 0;
  fromPrice?: number;
  toPrice?: number;
}

export enum Sort {
  PriceAsc,
  PriceDesc,
  YearAsc,
  YearDesc,
  Latest,
  Mileage
}
