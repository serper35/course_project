import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees;
    private int size ;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    //Добавить сотрудника
    public void addEmployee(String firstName, String middleName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, middleName, lastName, department, salary);
        employees[size++] = employee;

    }

    //Получить список сотрудников.
    public void allEmployee() {
        for (int i = 0; i < size; i++) {
            Employee all = employees[i];
            System.out.println("Сотрудник №" + employees[i].getId() + "\n-----------------" + all.toString() + "\n");
        }
    }

    public double totalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee money = employees[i];
            totalSalary += money.getSalary();
        }
        return totalSalary;
    }

    public void printTotalSalary() {
        System.out.println("\nСумма затрат на зарплаты в месяц - " + totalSalary() + "\n-----------------");
    }

    public void minSalary() {
        double minSalary = employees[0].getSalary();
        Employee temp = employees[0];

        for (int i = 0; i < size; i++) {
            Employee salary = employees[i];
            if (salary.getSalary() < minSalary) {
                minSalary = salary.getSalary();
                temp = salary;
            }
        }
        System.out.println("\nМинимальная зарплата - " + minSalary + " у сотрудника " + temp.getFullName() + "\n-----------------");
    }

    public void maxSalary() {
        double maxSalary = employees[0].getSalary();
         Employee temp =employees[0];
        
        for (int i = 0; i < size; i++) {
            Employee  salary = employees[i];
            if (maxSalary < salary.getSalary()) {
                maxSalary = salary.getSalary();
                temp = salary;
            }
        }
        System.out.println("\nМаксимальная зарплата - " + maxSalary + " у сотрудника " + temp.getFullName() + "\n-----------------");
    }

    public double averageSalary() {
        return totalSalary() / size;
    }

    public void printAverageSalary() {
        System.out.println("\nСреднее значение зарплат - " + averageSalary() + ".\n-----------------");
    }

    public void printFullNameEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("\nФИО сотрудника №" + employees[i].getId() + " - " + employees[i].getFullName() + "." + "\n-----------------");
        }
    }

    public void indexsalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите процент индексации зарплаты.");
        double index = (scan.nextDouble());

        for (int i = 0; i < size; i++) {
            employees[i].setSalary(((employees[i].getSalary() * index) / 100) + employees[i].getSalary());
        }
    }

    public void depMinSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета.");
        int inputDepartament = scan.nextInt();
        double minSalary = 100000000000.0;
        Employee temp = employees[0];
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == inputDepartament) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    temp = employees[i];
                }
            }
        }
        System.out.println("\nВ департаменте №" + inputDepartament + " минимальная зарплата - " + minSalary + " у сотрудника " + temp.getFullName());
    }

}
