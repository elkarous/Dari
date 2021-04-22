import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EstimationComponent } from './estimation/estimation.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SimulationComponent } from './simulation/simulation.component';

const routes: Routes = [ 
  
  { path: 'simulation', component: SimulationComponent },
  { path: 'estimation', component: EstimationComponent},
  { path: '**', component: HomeComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
