import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Saque } from '../models/saque.model';

@Injectable({
  providedIn: 'root'
})
export class SaqueService {

  private URI = `${environment.API}/saques`;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  sacar(saque: Saque) {
    return this.http.post(this.URI, saque, this.httpOptions).pipe(take(1));
  }
}
