import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarContaCorrenteComponent } from './listar-conta-corrente/listar-conta-corrente.component';


const routes: Routes = [{ path: '', component: ListarContaCorrenteComponent},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContasRoutingModule { }
