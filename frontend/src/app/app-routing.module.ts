import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VendingMachineComponent } from './vending-machine/vending-machine.component';
import { HistoryComponent } from './history/history.component';

const routes: Routes = [
  {
    path: 'vending-machine',
    component: VendingMachineComponent,
  },
  {
    path: 'history',
    component: HistoryComponent,
  },
  {
    path: '',
    redirectTo: '/vending-machine',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
