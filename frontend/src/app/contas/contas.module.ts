import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContasRoutingModule } from './contas-routing.module';
import { ListarContaCorrenteComponent } from './listar-conta-corrente/listar-conta-corrente.component';
import { SharedModule } from '../shared/shared.module';
import { VerSaldoComponent } from './ver-saldo/ver-saldo.component';
import { DepositoComponent } from './deposito/deposito.component';
import { SaqueComponent } from './saque/saque.component';


@NgModule({
  declarations: [ListarContaCorrenteComponent, VerSaldoComponent, DepositoComponent, SaqueComponent],
  imports: [
    CommonModule,
    ContasRoutingModule,
    SharedModule
  ]
})
export class ContasModule { }
