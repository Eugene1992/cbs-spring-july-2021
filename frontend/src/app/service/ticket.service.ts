import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../model/ticket";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  getTask(id: number): Observable<Ticket> {
    return this.http.get<Ticket>(`${this.baseUrl}/tickets/${id}`);
  }

  getTicketWatchersCount(id: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/tickets/${id}/watchers/count`);
  }
}
