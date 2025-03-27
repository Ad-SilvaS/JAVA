package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employees = new ArrayList<>();
		
		int n = 0;
		while(true){
			System.out.print("Quantos funcionários serão registrados: ");
			if(sc.hasNextInt()){
				n = sc.nextInt();
				sc.nextLine();

				if(n>0){
					break;
				}
				else{
					System.err.println("Digite um número positivo!");
				}
			}
			else{
				System.err.println("Digite um número válido!");
				sc.next();
			}
		}

		for(int i=1; i<=n; i++){
			System.out.printf("Funcionário #%d%n:", i);
			
			int id = 0;
			while (true) {
				System.out.print("Id: ");

				if(sc.hasNextInt()){
					id = sc.nextInt();
					sc.nextLine();
					if(id>0){
						break;
					}
					else{
						System.err.println("Digite um número positivo!");
					}
				}
				else{
					System.err.println("Digite um número válido!");
					sc.next();
				}
			}

			String name;
			while (true) {
				System.out.print("Nome: ");
				name = sc.nextLine();
				if(!name.isEmpty() && name.matches("^[A-Za-zÀ-ÖØ-öø-ÿ\s]+$")){
					break;
				}
				else{
					System.err.println("Nome inválido!");
				}
			}

			double salary = 0;
			while (true) {
				System.out.print("Salário: ");
				if(sc.hasNextDouble()){
					salary = sc.nextDouble();
					sc.nextLine();
					if(salary>0){
						break;
					}
					else{
						System.err.println("Digite um número prositivo!");
					}
				}
				else{
					System.err.println("Digite um número válido!");
					sc.next();
				}
			}

			Employee employee = new Employee(name, id, salary);
			employees.add(employee);
		}

		int idToIncrease;
		while (true) {
			System.out.print("Entre com o id do funcionário que terá o salário aumentado: ");

			if(sc.hasNextInt()){
				idToIncrease = sc.nextInt();
				sc.nextLine();
				
				if(idToIncrease>0){
					break;
				}
				else{
					System.err.println("Digite um número positivo!");
				}
			}
			else{
				System.err.println("Digite um número válido!");
				sc.nextLine();
			}
		}

		double percentage;
		while (true) {
			System.out.print("Entre com a porcentagem do aumento: ");
			
			if(sc.hasNextDouble()){
				percentage = sc.nextDouble();

				if(percentage>0){
					break;
				}
				else{
					System.err.println("Digite um número positivo!");
				}
			}
			else{
				System.err.println("Digite um número válido!");
				sc.nextLine();
			}
		}

		Employee foundEmployee = null;
		for(Employee employee : employees){
			if(employee.getId() == idToIncrease){
				foundEmployee = employee;
				break;
			}
		}

		if(foundEmployee != null){
			foundEmployee.increaseSalary(percentage);
		}
		else{
			System.out.println("Funcionário com Id " + idToIncrease + " não encontrado!");
		}

		System.out.println("Lista de funcionários:");
		for(Employee employee : employees){
			System.out.println(employee);
		}

		sc.close();
	}

} 
