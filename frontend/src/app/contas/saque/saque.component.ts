import { Component, OnInit,  Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-saque',
  templateUrl: './saque.component.html',
  styleUrls: ['./saque.component.css']
})
export class SaqueComponent implements OnInit {

  @Input() formulario: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  
  verificarValidTouchedDirty(campo: string) {
    return (
      !this.formulario.get(campo).valid &&
      (this.formulario.get(campo).touched || this.formulario.get(campo).dirty)
    );
  }

  verificarRequired(campo: string) {
    return (
      this.formulario.get(campo).hasError('required') &&
      (this.formulario.get(campo).touched || this.formulario.get(campo).dirty)
    );
  }

  verificarMinLength(campo: string) {
    return (
      this.formulario.get(campo).hasError('minlength') &&
      (this.formulario.get(campo).touched || this.formulario.get(campo).dirty)
    );
  }
}
