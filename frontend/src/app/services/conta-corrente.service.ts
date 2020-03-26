import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ContaCorrente } from '../models/conta-corrente.model';

@Injectable({
  providedIn: 'root'
})
export class ContaCorrenteService {

  private URI = `${environment.API}/contas`;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getContas() {
    return this.http.get<ContaCorrente[]>(this.URI, this.httpOptions).pipe(take(1));
  }
  getSaldo(conta: ContaCorrente) {
    return this.http.get<Number>(`${this.URI}/saldo/${conta.agencia}/${conta.codigo}`, this.httpOptions);
  }
}
