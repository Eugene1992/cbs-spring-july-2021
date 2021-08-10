import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn!: boolean;
  isUser!: boolean;
  isAdmin!: boolean;

  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isUserLoggedIn();
    this.isUser = this.authService.isUser;
    this.isAdmin = this.authService.isAdmin;
  }

  logout() {
    this.authService.logOut();
  }
}
