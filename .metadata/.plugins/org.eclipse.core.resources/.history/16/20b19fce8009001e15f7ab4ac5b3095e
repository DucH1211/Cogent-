package cogent.edu.corejava.Inheritance;

import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.Exception;

public class testEmployeeMap {
	static int id;	
	public static Employee inputEDetails(Scanner sc,Employee e)throws Exception {
		System.out.println("Enter Employee Details");
		System.out.println("ID:");
		int id = sc.nextInt();sc.nextLine();
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Age:");
		int age = sc.nextInt();sc.nextLine();
		System.out.println("Gender:");
		String gender = sc.nextLine();
		System.out.println("Salary:");
		int salary = sc.nextInt();sc.nextLine();
		
		
		e = new Employee(id,name,age,gender,salary);
		return e;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee e1 = new Employee(2,"Name I",25,"FeMale",50000);
//		Employee e2 = new Employee(3,"Name II",29,"Male",1000);
//		Employee e3 = new Employee(4,"Name III",51,"FeMale",1000000);
//		Employee e4 = new Employee(5,"Name IV",32,"Male",2056789);
//		Employee e5 = new Employee(6,"Name V",76,"Male",1298391);
		
		Employee e = null;
		
		
		
		EmployeeMap H = new EmployeeMap();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("INSERT: 1, DELETE: 2, UPDATE: 3, READ ID: 4, READ MAP: 5, STOP: 9");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				try {
					e = inputEDetails(sc,e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					sc = new Scanner(System.in);
					break;
					
				}
				H.setE(e); //inject Employee e to EmployeeMap H
				H.insert();
				break;
			case 2:
				System.out.println("Enter ID to DELETE:");
				id = sc.nextInt();
				try{H.delete(id);
				}catch(NullPointerException ex)
				{
					sc.nextLine();
					break;
				}
				break;
			case 3:
				System.out.println("Enter ID to UPDATE:");
				int thisId = sc.nextInt();
				try {
					H.delete(thisId);
					e = inputEDetails(sc,e);
				} catch(NullPointerException ex)
				{
					sc = new Scanner(System.in);
					break;
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					sc = new Scanner(System.in);
					break;
				} 
				H.setE(e);
				H.insert();
				break;
			case 4:
				System.out.println("Enter ID to READ:");
				id = sc.nextInt();
				System.out.println(H.read(id));
				
				break;
			case 5:
				System.out.println(H.toString());
				
				break;
			case 9:
				System.out.println("Exitting Loop");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}while(choice != 9);
		
		//export file.
		ObjectOutputStream OutS;
		try {
			OutS = new ObjectOutputStream(new FileOutputStream("EmployeeHashMap.DATA"));
			OutS.writeObject(H);
			OutS.flush();
			OutS.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Open that file right away
		File f = new File("EmployeeHashMap.DATA");
		try {
		    Desktop.getDesktop().open(f);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
	}

}
