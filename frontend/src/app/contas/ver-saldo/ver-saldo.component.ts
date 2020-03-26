import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ContaCorrente } from 'src/app/models/conta-corrente.model';

@Component({
  selector: 'app-ver-saldo',
  templateUrl: './ver-saldo.component.html',
  styleUrls: ['./ver-saldo.component.css']
})
export class VerSaldoComponent implements OnInit {

  @Input() conta: ContaCorrente;
  @Input() saldo: Number = 0.0;
  @Input() mostrar: boolean;
  
  @Output() cancelado = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

 




}
