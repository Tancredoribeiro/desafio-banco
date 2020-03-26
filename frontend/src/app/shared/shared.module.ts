import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { PanelModule } from 'primeng/panel';
import { DataViewModule } from 'primeng/dataview';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { TooltipModule } from 'primeng/tooltip';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PanelModule,
    MessageModule,
    ToastModule,
    DialogModule,
    ButtonModule,
    HttpClientModule,
    ProgressSpinnerModule,
    TooltipModule
  ],
  exports: [
    CommonModule,
    ReactiveFormsModule,
    PanelModule,
    MessageModule,
    ToastModule,
    DialogModule,
    ButtonModule,
    DataViewModule,
    HttpClientModule,
    ProgressSpinnerModule,
    TooltipModule
  ]
})
export class SharedModule { }
