import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../list-employee/list-employee.component';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  
  constructor(private http: HttpClient) { }

  getEmployees(){
    return this.http.get<Employee[]>(`http://localhost:8080/employees`);
  }

  postEmployee(emp: Employee){
    return this.http.post(`http://localhost:8080/employees`, emp);
  }

  getEmployee(id: number){
    return this.http.get<Employee>(`http://localhost:8080/employees/${id}`);
  }

  putEmployee(id:number, emp: Employee){
    return this.http.put(`http://localhost:8080/employees/${id}`,emp);
  }

  deleteEmployee(id:number){
    return this.http.delete(`http://localhost:8080/employees/${id}`);
  }

}
