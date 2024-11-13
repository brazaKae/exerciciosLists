package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static {
        Locale.setDefault(Locale.US);
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<Employee>();
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee employee = new Employee(id, name, salary);
            list.add(employee);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalaryIncrease = sc.nextInt();

        int positionId = positionId(list, idSalaryIncrease);
        while (positionId == -1) {
            System.out.print("Error! Id not found,please type again: ");
            idSalaryIncrease = sc.nextInt();
            positionId = positionId(list, idSalaryIncrease);
        }

        System.out.println("Enter the percentage: ");
        double percentage = sc.nextDouble();
        list.get(positionId).increaseSalary(percentage);

        for (Employee emp : list) {
            System.out.println(emp);
        }

        sc.close();

    }

    public static int positionId(List<Employee> list, int idSalaryIncrease) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idSalaryIncrease) {
                return i;
            }
        }
        return -1;
    }
}
