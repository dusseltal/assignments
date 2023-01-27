import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Smoothie} from './smoothie';

@Injectable({
  providedIn: 'root'
})
export class SmoothieService {

  private baseUrl = 'http://localhost:8080/api/v1/smoothies';

  constructor(private http: HttpClient) { }

  getSmoothie(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSmoothie(smoothie: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, smoothie);
  }

  updateSmoothie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteSmoothie(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getSmoothiesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
