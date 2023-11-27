import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { EmployeeComponentComponent } from './employee-component/employee-component.component';

const routes: Routes = [
  {path: "", component: ListEmployeeComponent},
  {path: "employees", component: ListEmployeeComponent},
  {path: "employees/:id", component: EmployeeComponentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
