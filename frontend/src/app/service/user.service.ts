import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../model/ticket";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {
  }

  watchTicket(userId: string, ticketId: string): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/users/${userId}/tickets/${ticketId}/watch`, null);
  }

  stopWatchTicket(userId: string, ticketId: string): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/users/${userId}/tickets/${ticketId}/stopWatch`, null);
  }
}
