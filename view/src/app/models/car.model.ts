import { ChartDataset } from 'chart.js';

export interface Car {
  make: string;
  model: string;
  vehicleType: string;
  engineType: string;
  engineCapacity: string;
  year: number;
  price: number;
  link: string;
  imageLink: string;
  mileage: string;
}

export interface CarView {
  make: string;
  model: string;
  vehicleType: string;
  engineType: string;
  engineCapacity: string;
  year: number;
  price: number;
  link: string;
  imageLink: string;
  mileage: string;
  isSaved: boolean;
  isCompared: boolean;
  setAlert: boolean;
}

export class Global {
  static cars: Car[] = [{
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '1.8',
    'year': 1987,
    'price': 540.00,
    'link': 'https://cars.av.by/audi/80/100967626',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6312/9237.jpg',
    'mileage': '330000'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '1.8',
    'year': 1989,
    'price': 600.00,
    'link': 'https://cars.av.by/audi/80/101152095',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/7153/9706.jpg',
    'mileage': '350000'
  }, {

    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '2.2',
    'year': 1985,
    'price': 600.00,
    'link': 'https://cars.av.by/audi/100/100963856',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6317/9629.jpg',
    'mileage': '400000'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '2.0',
    'year': 1985,
    'price': 600.00,
    'link': 'https://cars.av.by/audi/100/100586903',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/4416/7423.jpeg',
    'mileage': '350000'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '1.8',
    'year': 1990,
    'price': 650.00,
    'link': 'https://cars.av.by/audi/80/100717786',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6854/3789.jpg',
    'mileage': '120000'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'DIESEL',
    'engineCapacity': '1.6',
    'year': 1991,
    'price': 793.00,
    'link': 'https://cars.av.by/audi/90/100872889',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/5848/2988.jpeg',
    'mileage': '458363'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '2.2',
    'year': 1983,
    'price': 800.00,
    'link': 'https://cars.av.by/audi/100/101123944',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6808/7500.jpg',
    'mileage': '500000'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'DIESEL',
    'engineCapacity': '2.0',
    'year': 1987,
    'price': 800.00,
    'link': 'https://cars.av.by/audi/100/101017315',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6491/2042.jpg',
    'mileage': '415000'
  }, {

    'make': 'Audi',
    'model': '80',
    'vehicleType': 'WAGON',
    'engineType': 'PETROL',
    'engineCapacity': '1.8',
    'year': 1987,
    'price': 800.00,
    'link': 'https://cars.av.by/audi/100/101045751',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6585/8042.jpg',
    'mileage': '111111'
  }, {
    'make': 'Audi',
    'model': '80',
    'vehicleType': 'SEDAN',
    'engineType': 'PETROL',
    'engineCapacity': '1.8',
    'year': 1989,
    'price': 850.00,
    'link': 'https://cars.av.by/audi/80/100724956',
    'imageLink': 'https://avcdn.av.by/advertpreview/0000/6461/4200.jpg',
    'mileage': '350000'
  }];
  static searched: CarView[] = this.cars.map(car => {
    return {
      make: car.make,
      model: car.model,
      vehicleType: car.vehicleType,
      engineType: car.engineType,
      engineCapacity: car.engineCapacity,
      year: car.year,
      price: car.price,
      link: car.link,
      imageLink: car.imageLink,
      mileage: car.mileage,
      isSaved: false,
      isCompared: false,
      setAlert: false
    };
  });
  static compared: CarView[] = [];
  static saved: CarView[] = [];
  static email: string = '';
  static scatterChartData: ChartDataset[] = [
    {
      data: this.cars.map(car => {
        return {
          x: car.price,
          y: Number(car.mileage),
        };
      }),
      label: 'Car mileage/price',
      pointRadius: 10,
    },
  ];
}
