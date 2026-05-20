import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NgxEchartsModule, NGX_ECHARTS_CONFIG } from 'ngx-echarts';

@Component({
  selector: 'app-radar',
  imports: [CommonModule, NgxEchartsModule],
  templateUrl: './radar.html',
  styleUrl: './radar.scss',
})
export class Radar {}
