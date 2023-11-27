import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeServiceService } from '../service/employee-service.service';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit{
  employees: Employee[] | undefined;
  message: string|undefined;

  constructor(private router: Router, private empService: EmployeeServiceService){

  }

  ngOnInit(): void {
    this.empService.getEmployees().subscribe(
      response=>{
        this.employees = response;
      }
    )
  }

  deleteEmp(id:number, firstName: string, lastName: string){
    this.empService.deleteEmployee(id).subscribe(
      response => {
        this.message = `Delete ${firstName} ${lastName} successfully`;
        this.empService.getEmployees().subscribe(
          response=>{
            this.employees = response;
          }
        )
      }
    )
  }
  updateEmp(id: number){
    this.router.navigate(["employees",id]);
  }
  
  addEmp(){
    this.router.navigate(["employees",-1]);
  }

}

export class Employee{
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public dob: Date,
    public department: string,
    public salary: number,
    public manager: string
  ){}
}
