public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private int department;
    private double salary;
    private static int count = 0;
    private final int id;


    public Employee (String firstName, String middleName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        id = ++count;
    }

    public String getFirstName () {
        return firstName;
    }
    public String getMiddleName () {
        return middleName;
    }
    public String getLastName () {
        return lastName;
    }
    public String getFullName () {
        return firstName + " " + middleName+ " " + lastName;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary () {
        return salary;
    }
    public int getId () {
        return id;
    }

    public void setDepartment (int department) {
        this.department = department;
    }
    public void setSalary (double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "\nId - " + id + "\nИмя - " + getFirstName() + "\nОтчество -  " + getMiddleName() + "\nФамилия - " + getLastName() + "\nДепартамент - " + getDepartment() + "\nЗарплата - " + getSalary();
    }

}
