import { Routes } from '@angular/router';
import { redirectNearMatch } from './core/config/tools/redirect-match';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    loadComponent: () => import('./pages/home/home').then((m) => m.Home),
  },
  {
    path: 'chart',
    loadChildren: () => import('./pages/chart/charts.routes').then((m) => m.chartRoutes),
  },
  {
    path: 'error',
    loadChildren: () => import('./pages/errors/errors.routes').then((m) => m.errorRoutes),
  },
  {
    path: '**',
    canActivate: [redirectNearMatch],
    children: [],
  },
];
