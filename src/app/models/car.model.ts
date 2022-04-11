export interface Car {
  brand: string;
  model: string;
  year: number;
  price: number;
  link: string;
  imageLink: string;
}

export class SearchCriteria {
  make?: string;
  modelId?: string;
  fromYear?: number;
  toYear?: number;
  fromPrice?: number;
  toPrice?: number;
}

