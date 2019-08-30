import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	static ArrayList<Emp> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("1. Add Employee");
		System.out.println("2. View All Employee");
		System.out.println("3. Remove Employee");
		System.out.println("4. Clear Total Data");
		System.out.println("5. Change Salary");
		System.out.println("6. Search Employee");
		System.out.println("7. View Dept wise List");
		System.out.println("8. Exit");
		System.out.println("Enter the desired option");

		int i = sc.nextInt();
		sc.nextLine();
		switch (i) {
		case 1:
			addEmp();
			break;
		case 2:
			viewEmp();
			break;
		case 3:
			removeEmp();
			break;
		case 4:
			clearData();
			break;
		case 5:
			changeSal();
			break;
		case 6:
			searchEmp();
			break;
		case 7:
			viewList();
			break;
		case 8:
			sc.close();
			System.exit(0);
			break;
		}

	}

	public static void addEmp() {

		String ename, desig, dept;
		int sal, eno = 0;
		System.out.println("Enter name of Employee");
		ename = sc.nextLine();
		System.out.println("Enter dept(it/acts/mkt/hr) of Employee");
		dept = sc.nextLine();
		System.out.println("Enter Designation of Employee");
		desig = sc.nextLine();
		System.out.println("Enter Salary of the Employee");
		sal = sc.nextInt();
		sc.nextLine();
		eno = eno + 1;

		Emp e = new Emp(ename, desig, dept, sal, eno);

		list.add(e);

		menu();
	}

	public static void viewEmp() {
		for (Emp em : list) {
			System.out.println(em);
		}
		menu();
	}

	public static void removeEmp() {
		if (list.isEmpty()) {
			System.out.println("No Employee available");
		} else {
			System.out.println("Enter the Employee id which you want to remove");
			int i = sc.nextInt();
			sc.nextLine();

			for (Emp em : list) {
				if (em.eno == i) {
					list.remove(em);
					System.out.println("Employee removed");
				} else
					System.out.println("No such Employee");
			}
		}
		menu();
	}

	public static void clearData() {
		list.clear();
		menu();
	}

	public static void changeSal(){
		if(list.isEmpty()){
			System.out.println("No Employee available");
		}
		else{
		System.out.println("Employee id whose salary you want to edit");
		int i=sc.nextInt();
		sc.nextLine();
		for(Emp em: list)
		{
			if(em.eno==i){
				System.out.println("Enter updated salary");
				int j=sc.nextInt();
				sc.nextLine();
				em.sal=j;
			}
			else{
				System.out.println("Employee not found");
			}
				menu();	
		}
		}
		}

	public static void searchEmp() {
		if(list.isEmpty()){
			System.out.println("No Employee available");
		}
		else{
		System.out.println("Employee id whom you want to search");
		int i=sc.nextInt();
		sc.nextLine();
		for(Emp em: list)
		{
			if(em.eno==i){
				System.out.println("ed");
				int j=sc.nextInt();
				sc.nextLine();
				em.sal=j;
			}
			else{
				System.out.println("Employee not found");
			}
				menu();	
		}
		}
	}

	public static void viewList() {

		if(list.isEmpty()){
			System.out.println("No Employee available");
		}
		else{
			ArrayList<Emp> listIt = new ArrayList<>();
			ArrayList<Emp> listActs = new ArrayList<>();
			ArrayList<Emp> listMkt = new ArrayList<>();
			ArrayList<Emp> listHr = new ArrayList<>();
			
			for(Emp em:list)
			{
				if(em.dept.equals("it")){
					listIt.add(em);
				}
				else if(em.dept.equals("acts"))
				{
					listActs.add(em);
				}
				else if(em.dept.equals("mkt")){
					listMkt.add(em);
				}
				else if(em.dept.equals("hr")){
					listHr.add(em);
				}
				else
				System.out.println("Unkown department");
			}
			
			HashMap <String,ArrayList<Emp>> map=new HashMap<>();
			map.put("it",listIt);
			map.put("acts",listActs);
			map.put("mkt",listMkt);
			map.put("hr",listHr);
			
			for(String s: map.keySet()){
				for(Emp em: map.get(s)){
					System.out.println("Depatment name:- "+em.dept);
					System.out.println(em);
				}
			}
			/*for(Emp em:listIt)
			{
				System.out.println(em);
			}
			for(Emp em:listActs)
			{
				System.out.println(em);
			}
			for(Emp em:listMkt)
			{
				System.out.println(em);
			}
			for(Emp em:listHr)
			{
				System.out.println(em);
			}*/
			
		menu();
	}
	}

	public static void main(String[] args) {
		menu();

	}

}
