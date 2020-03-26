import { Component, OnInit } from '@angular/core';
import { MessageService, ConfirmationService } from 'primeng/api';
import { ContaCorrente } from 'src/app/models/conta-corrente.model';
import { ContaCorrenteService } from '../../services/conta-corrente.service';
import { Observable, empty } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FormUtils } from 'src/app/shared/utils/form-utils';
import { DepositoService } from '../../services/deposito.service';
import { SaqueService } from 'src/app/services/saque.service';

@Component({
  selector: 'app-listar-conta-corrente',
  templateUrl: './listar-conta-corrente.component.html',
  styleUrls: ['./listar-conta-corrente.component.css'],
  providers: [MessageService, ConfirmationService, ConfirmationService]
})
export class ListarContaCorrenteComponent implements OnInit {


  contas$: Observable<ContaCorrente[]>;
  mostrarSaldo: boolean;
  mostrarFormularioDeposito: boolean;
  mostrarFormularioSaque: boolean;
  saldoAtual: Number;
  contaSelecionada: ContaCorrente = null;
  depositoFormulario: FormGroup;
  saqueFormulario: FormGroup;

  constructor(
    private contaCorrenteService: ContaCorrenteService,
    private depositoService: DepositoService,
    private saqueService: SaqueService,
    private messageService: MessageService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.contas$ = this.contaCorrenteService.getContas().pipe(
      catchError(error => {
        this.mostrarErro();
        return empty();
      })
    );

    this.depositoFormulario = this.fb.group({
      agencia: [''],
      conta: [''],
      nomeDepositante: ['', [Validators.required, Validators.minLength(2)]],
      cpfDepositante: ['', [Validators.required]],
      valor: [null, [Validators.required]]
    });

    this.saqueFormulario = this.fb.group({
      agencia: [''],
      conta: [''],
      valor: [null, [Validators.required]]
    });
  }

  mostrarErro() {
    this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao buscar restaurantes.' });
  }

  verSaldo(conta: ContaCorrente) {
    this.contaSelecionada = conta;
    this.contaCorrenteService.getSaldo(conta).subscribe(
      success => { this.saldoAtual = success },
      error => this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao buscar o Saldo, tente novamente!' })
    );
    this.mostrarSaldo = true;
  }

  comfirmarDeposito() {
    if (this.depositoFormulario.valid) {
      this.depositoService.depositar(this.depositoFormulario.value).subscribe(
        success => {
          this.messageService.add({ severity: 'info', summary: 'Successo', detail: 'Deposito realizado com sucesso.' });
          this.limparFormularioDeposito();
        },
        errorHeaders => this.messageService.add({ severity: 'error', summary: 'Erro', detail: errorHeaders.error.message })
      );
    } else {
      FormUtils.validarCamposDoFormulario(this.depositoFormulario);
      this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Por favor, corrija os erros abaixo.' });
    }
  }
  confirmarSaque() {
    if (this.saqueFormulario.valid) {
      this.saqueService.sacar(this.saqueFormulario.value).subscribe(
        success => {
          this.messageService.add({ severity: 'info', summary: 'Successo', detail: 'Saque realizado com sucesso.' });
          this.limparFormularioSaque();
        },
        errorHeaders => this.messageService.add({ severity: 'error', summary: 'Erro', detail: errorHeaders.error.message })
      );
    } else {
      FormUtils.validarCamposDoFormulario(this.saqueFormulario);
      this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Por favor, corrija os erros abaixo.' });
    }
  }

  limparFormularioDeposito() {
    this.mostrarFormularioDeposito = false;
    this.depositoFormulario.reset();
    this.contaSelecionada = null;
  }

  limparFormularioSaque() {
    this.mostrarFormularioSaque = false;
    this.saqueFormulario.reset();
    this.contaSelecionada = null;
  }

  prepararDeposito(conta: ContaCorrente) {
    this.contaSelecionada = conta;
    this.iniciarFormularioDeposito(conta);
    this.mostrarFormularioDeposito = true;
  }

  prepararSaque(conta: ContaCorrente) {
    this.contaSelecionada = conta;
    this.iniciarFormularioSaque(conta);
    this.mostrarFormularioSaque= true;
  }

  iniciarFormularioDeposito(conta: ContaCorrente) {
    this.depositoFormulario = this.fb.group({
      agencia: [conta.agencia],
      conta: [conta.codigo],
      nomeDepositante: ['', [Validators.required, Validators.minLength(2)]],
      cpfDepositante: ['', [Validators.required]],
      valor: [null, [Validators.required]]
    });
  }
  iniciarFormularioSaque(conta: ContaCorrente) {
    this.saqueFormulario = this.fb.group({
      agencia: [conta.agencia],
      conta: [conta.codigo],
      valor: [null, [Validators.required]]
    });
  }

  fecharSaldo() {
    this.mostrarSaldo = false;
    this.contaSelecionada = null;
  }

}
