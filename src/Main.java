public class Main {
    public static void main(String[] args) {
        EmployeeBook employee = new EmployeeBook();
        employee.addEmployee("Vladislav", "Nikolaevich", "Volkov", 1, 160_000);
        employee.addEmployee("Anna", "Petrovna", "Ivanova", 2, 50_000);
        employee.addEmployee("Maksim", "Petrovich", "Sorokin", 3, 100_000);
        employee.addEmployee("Vladimir", "Semenovich", "Shilov", 4, 80_000);
        employee.addEmployee("Pavel", "Pavlovich", "Pavlov", 5, 25_000);
        employee.addEmployee("Ignat", "Ignatovich", "Ignatov", 1, 120_000);
        employee.addEmployee("Oleg", "Fomich", "Petrov", 2, 150_000);
        employee.addEmployee("Ivan", "Ivanovich", "Ivanov", 3, 90_000);
        employee.addEmployee("Maria", "Ivanovna", "Lok", 4, 140_000);
        employee.addEmployee("Irina", "Andreevna", "Stok", 5, 111_000);


        employee.allEmployee();

        employee.printTotalSalary();

        employee.minSalary();

        employee.maxSalary();

        employee.printAverageSalary();

        employee.printFullNameEmployees();

        employee.indexsalary();

        employee.allEmployee();

        employee.depMinSalary();
    }

}