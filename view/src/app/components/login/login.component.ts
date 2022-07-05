import { Component, OnInit } from '@angular/core';
import { Global } from '../../models/car.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  setEmail() {
    Global.email = 'vladislav.atsman@gmail.com';
  }
}
