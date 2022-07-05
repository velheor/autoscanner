import { Component } from '@angular/core';
import { Global } from '../../models/car.model';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent {

  email: string = Global.email;

  constructor() {
  }

  get global(): string {
    return Global.email;
  }

}
