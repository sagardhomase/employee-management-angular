import { Component, OnInit } from '@angular/core';
import { Employee } from '../list-employee/list-employee.component';
import { EmployeeServiceService } from '../service/employee-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-component',
  templateUrl: './employee-component.component.html',
  styleUrls: ['./employee-component.component.css']
})
export class EmployeeComponentComponent implements OnInit{
  departments= [
    {id: 0, name: "IT"},
    {id: 1, name: "HR"}
  ];
  
  managers: Array<Employee> | undefined;
  constructor(private empService: EmployeeServiceService, private router: Router, 
    private activatedRoute: ActivatedRoute){

  }
  id = this.activatedRoute.snapshot.params['id'];
  selectedOption='';
  employee = new Employee(this.id, '','',new Date(),'',20000, "no");
  managerOption = '';
  ngOnInit(): void {

    if(this.id != -1){
      this.empService.getEmployee(this.id).subscribe(
        response=>{
          this.employee = response;
          this.selectedOption = response.department;
          console.log("*****"+response.department);
          this.getManagers();
          this.managerOption = response.manager;
          console.log("*****"+this.managerOption);
          
          })
    }else{
      this.getManagers();
    }
    
  }
  
  saveEmp(){
    console.log(this.selectedOption);
    console.log(this.managerOption);
    this.employee.department = this.selectedOption;
    this.employee.manager = this.managerOption;
    console.log("*****+++++"+this.employee.manager);
    if(this.id == -1){
      this.empService.postEmployee(this.employee).subscribe(
        response =>{
          this.router.navigate(['employees']);
        }
      );
    } else{
      this.empService.putEmployee(this.id, this.employee).subscribe(
        response=>{
          this.router.navigate(['employees']);
        }
      )
    }
    
  }

  cancel(){
    this.router.navigate(['employees']);
  }

  getManagers(){
    this.empService.getEmployees().subscribe(
      result =>{
         const val = result.findIndex(x=>x.id == this.id);
         console.log("+++++"+val);
         if(val > -1){
           result.splice(val,1);
         }
         this.managers = result;

       })
  }
    

}
