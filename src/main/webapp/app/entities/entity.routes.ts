import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'actividadApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'centro-salud',
    data: { pageTitle: 'actividadApp.centroSalud.home.title' },
    loadChildren: () => import('./centro-salud/centro-salud.routes'),
  },
  {
    path: 'medico',
    data: { pageTitle: 'actividadApp.medico.home.title' },
    loadChildren: () => import('./medico/medico.routes'),
  },
  {
    path: 'paciente',
    data: { pageTitle: 'actividadApp.paciente.home.title' },
    loadChildren: () => import('./paciente/paciente.routes'),
  },
  {
    path: 'reserva',
    data: { pageTitle: 'actividadApp.reserva.home.title' },
    loadChildren: () => import('./reserva/reserva.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
