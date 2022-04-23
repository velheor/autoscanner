export class SearchCriteria {
  brand?: string;
  model?: string;
  fromYear?: number;
  toYear?: number;
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
