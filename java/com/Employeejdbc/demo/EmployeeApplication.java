package com.Employeejdbc.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		Scanner sc = new Scanner(System.in);
		EmployeeDao edao = new EmployeeDao();
		while(true) {
			System.out.println("1.Add Employee Details\n2.Delete Employee Details\n3.Search Employee details\n4.Display All\n5.Exit");
			int ch = sc.nextInt();sc.nextLine();
			switch(ch){
			case 1:{
				System.out.println("Enter Employee name   :");
				String ename = sc.nextLine();
				System.out.println("Enter Employee email    :");
				String email = sc.nextLine();
				System.out.println("Enter Employee PAddress :");
				String pAddress = sc.nextLine();
				System.out.println("Enter Employee CAddress :");
				String cAddress = sc.nextLine();
				if(edao.addEmployee(new EmployeeDetails(ename,email,pAddress,cAddress))) {
					System.out.println();
					System.out.println("Added to the Database...");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("An Error Occured....");
					System.out.println();
				}
				break;
			}
			case 2:{
				System.out.println("Enter the Email id :");
				String email = sc.next();
				if(edao.deleteEmployee(email)) {
					System.out.println();
					System.out.println("Deleted Successfully.......");
					System.out.println();
				}else {
					System.out.println("An Error Occured...........");
				}
				break;
			}
			case 3:{
				System.out.println("Enter the Email id :");
				String email = sc.nextLine();
				edao.searchEmployee(email);
				break;
			}
			case 4:{
				edao.displayAll();
				break;
			}
			default:{
				System.out.println("Thank you.............");
				System.exit(0);
			}
			}
		}
		
	}
}
