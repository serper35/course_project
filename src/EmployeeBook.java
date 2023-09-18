import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

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

    //Посчитать сумму затрат на зарплаты в месяц
    public double totalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < size; i++) {
            totalSalary +=employees[i].getSalary();
        }
        return totalSalary;
    }

    public void printTotalSalary() {
        System.out.println("\nСумма затрат на зарплаты в месяц - " + totalSalary() + "\n-----------------");
    }

    //Поиск сотрудника с максимальной зарплатой
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

    //Поиск сотрудника с максимальной зарплатой
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

    //Подсчет среднего значения зарплат
    public double averageSalary() {
        return totalSalary() / size;
    }

    public void printAverageSalary() {
        System.out.println("\nСреднее значение зарплат - " + averageSalary() + ".\n-----------------");
    }

    //Список Ф. И. О. всех сотрудников
    public void printFullNameEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("\nФИО сотрудника №" + employees[i].getId() + " - " + employees[i].getFullName() + "\n-----------------");
        }
    }

    //Проиндексировать зарплату
    public void indexsalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите процент индексации зарплаты.");
        double index = (scan.nextDouble());

        for (int i = 0; i < size; i++) {
            employees[i].setSalary(((employees[i].getSalary() * index) / 100) + employees[i].getSalary());
        }
    }

    //Сотрудник с минимальной зарплатой в отделе
    public void depMinSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для поиска минимальной зарплаты.");
        int inputDepartment = scan.nextInt();
        double minSalary = 100000000000.0;
        Employee temp = employees[0];

        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == inputDepartment) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    temp = employees[i];
                }
            }
        }
        if (inputDepartment <= 5) {
            System.out.println("\nВ департаменте №" + inputDepartment + " минимальная зарплата - " + minSalary + " у сотрудника " + temp.getFullName() + ".\n-----------------");
        } else {
            throw new RuntimeException("Введите корректные данные");
        }
    }

    //Сотрудник с максимальной зарплатой в отделе
    public void depMaxSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для поиска максимальной зарплаты.");
        int inputDepartment = scan.nextInt();
        double maxSalary = 0;
        Employee temp = employees[0];

        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == inputDepartment) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    temp = employees[i];
                }
            }
        }
        if (inputDepartment <= 5) {
            System.out.println("\nВ департаменте №" + inputDepartment + " максимальная зарплата - " + maxSalary + " у сотрудника " + temp.getFullName() + ".\n-----------------");
        } else {
            throw new RuntimeException("Введите корректные данные");
        }
    }

    //Сумма затрат на зарплату по отделу
    public void depTotalSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для поиска общей зарплаты.");
        int inputDepartment = scan.nextInt();
        double totalSalary = 0;

        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == inputDepartment) {
                totalSalary += employees[i].getSalary();
            }
        }
        if (inputDepartment <= 5) {
            System.out.println("\nВ департаменте №" + inputDepartment + " общая зарплата - " + totalSalary + "\n-----------------" );
        } else {
            throw new RuntimeException("Введите корректные данные");
        }
    }

    //Получить среднюю зарплату по отделу
    public void depAverageSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для поиска средней зарплаты.");
        int inputDepartment = scan.nextInt();
        double salary = 0;
        int sizeDep = 0;

        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == inputDepartment) {
                salary += employees[i].getSalary();
                sizeDep++;
            }
        }
        if (inputDepartment <= 5) {
            System.out.println("\nВ департаменте №" + inputDepartment + " средняя зарплата - " + salary / sizeDep + "\n-----------------");
        } else {
            throw new RuntimeException("Введите корректные данные");
        }
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент
    public void depIndexSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для индексации зарплаты.");
        int inputDepartment = scan.nextInt();
        System.out.println("Введите процент индексации зарплаты.");
        double indexSalary = scan.nextDouble();

        for (int i = 0; i < size; i++) {
            if (inputDepartment <= 5) {
                if (employees[i].getDepartment() == inputDepartment) {
                    employees[i].setSalary(((employees[i].getSalary() * indexSalary) / 100) + employees[i].getSalary());
                }
            } else {
                throw new RuntimeException("Введите корректные данные");
            }
        }
    }

    //Напечатать всех сотрудников отдела
    public void depEmployees() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер департамета для получения списка сотрудников.");
        int inputDepartment = scan.nextInt();

        for (int i = 0; i < size; i++) {
            if (inputDepartment <= 5) {
                if (employees[i].getDepartment() == inputDepartment) {
                    System.out.println("\nСотрудник №" + employees[i].getId() + "\n-----------------\nФИО - " + employees[i].getFullName() + "\nЗарплата - " + employees[i].getSalary() + "\n-----------------");
                }
            } else {
                throw new RuntimeException("\nВведите корректные данные");
            }
        }
    }

    //Все сотрудники с зарплатой меньше (или равно) числа
    public void searchSalaryBelowNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите максимальный уровень зарплаты.");
        double inputSalary = scan.nextDouble();

        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() <= inputSalary) {
                System.out.println("\nСотрудник №" + employees[i].getId() + "\n-----------------\nФИО - " + employees[i].getFullName() + "\nЗарплата - " + employees[i].getSalary() + "\n-----------------");
            }
        }
    }

    //Все сотрудники с зарплатой больше (или равно) числа
    public void searchSalaryAbovewNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите минимальный уровень зарплаты.");
        double inputSalary = scan.nextDouble();

        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() >= inputSalary) {
                System.out.println("\nСотрудник №" + employees[i].getId() + "\n-----------------\nФИО - " + employees[i].getFullName() + "\nЗарплата - " + employees[i].getSalary() + "\n-----------------");
            }
        }
    }

    //Удалить сотрудника
    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size -i] = null;
                size--;
                return;
            }
        }
    }

    //Изменить зарплату сотрудника
    public void setSalary(String fio) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новую зарплату.");
        double inputSalary = scan.nextDouble();

        for (int i = 0; i < size; i++) {
            if (employees[i].getFullName().equals(fio)) {
                employees[i].setSalary(inputSalary);
                return;
            }
        }
    }

    // Изменить отдел сотрудника
    public void setDepartment(String fio) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новый департамент.");
        int inputDepartment = scan.nextInt();

        if (inputDepartment <= 5) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getFullName().equals(fio)) {
                    employees[i].setDepartment(inputDepartment);
                    return;
                }
            }
        } else {
            throw new RuntimeException("Введите кореектные данные");
        }
    }

    //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void fullNameByDep() {
        int department = 1;
        int departmentsSize = 5;
        for (int j = 0; j < departmentsSize; j++) {
                System.out.println("Департамент №" + department + "\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
                for (int i = 0; i < size; i++) {
                    if (employees[i].getDepartment() == department) {
                        System.out.println("Сотрудник №" + employees[i].getId() + "\n-----------------\nФИО - " + employees[i].getFullName() + "\nЗарплата - " + employees[i].getSalary() + "\n-----------------\n");
                    }
            }
            department++;
        }
    }
}
