import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NgxEchartsModule, NGX_ECHARTS_CONFIG } from 'ngx-echarts';

@Component({
  selector: 'app-home',
  imports: [CommonModule, NgxEchartsModule],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {}
