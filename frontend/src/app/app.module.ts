import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {SearchComponent} from './search/search.component';
import {TaskComponent} from './task/task.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule, HTTP_INTERCEPTORS} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {BasicAuthHtppInterceptorService} from "./service/basic-auth-htpp-interceptor.service";
import { LoginComponent } from './login/login.component';
import { FormsModule }   from '@angular/forms';
import { ReactiveFormsModule }   from '@angular/forms';
import {AdminGuard} from "./guards/admin.guard";
import { NotificationBarComponent } from './header/notification-bar/notification-bar.component';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'task/:id', component: TaskComponent, canActivate: [AdminGuard]},
  {path: 'search', component: SearchComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SearchComponent,
    TaskComponent,
    LoginComponent,
    NotificationBarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
