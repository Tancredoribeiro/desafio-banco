import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Deposito } from '../models/deposito.model';

@Injectable({
  providedIn: 'root'
})
export class DepositoService {

  private URI = `${environment.API}/depositos`;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  depositar(deposito: Deposito) {
    return this.http.post(this.URI, deposito, this.httpOptions).pipe(take(1));
  }

}
