import { Routes } from '@angular/router';

export const chartRoutes: Routes = [
  {
    path: 'radar',
    loadComponent: () => import('./radar/radar').then((m) => m.Radar),
  },
  {
    path: 'negative-bar',
    loadComponent: () => import('./negative-bar/negative-bar').then((m) => m.NegativeBar),
  },
  {
    path: 'heatmap',
    loadComponent: () => import('./matrix-heatmap/matrix-heatmap').then((m) => m.MatrixHeatmap),
  },
];
