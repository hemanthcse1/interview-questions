import java.util.*;
import java.util.stream.Collectors;



enum Department {
    ENGINEERING,
    MARKETING,
    HR,
    QA,
    DEVOPS,
    DATA_SCIENCE,
    PRODUCT_MANAGEMENT
}

class Employee {
    private int uniqueId;
    private String name;
    private String email;
    private String phoneNumber;
    private Date dob;
    private Department dept;
    private double salary;

    public Employee(int uniqueId, String name, String email, String phoneNumber, Date dob, Department dept, double salary) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.dept = dept;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
}

class MainClass {

    public static void main(String[] args) {

        HashMap<Integer, Employee> employees = new HashMap<>();


        employees.put(1, new Employee(1, "Ravi Teja", "ravi.teja@example.com", "9876543210",
                new GregorianCalendar(1985, Calendar.MARCH, 15).getTime(), Department.ENGINEERING, 600000));
        employees.put(2, new Employee(2, "Anita Reddy", "anita.reddy@example.com", "9876543211",
                new GregorianCalendar(1990, Calendar.JULY, 22).getTime(), Department.MARKETING, 400000));
        employees.put(3, new Employee(3, "Suresh Kumar", "suresh.kumar@example.com", "9876543212",
                new GregorianCalendar(1988, Calendar.JANUARY, 5).getTime(), Department.ENGINEERING, 700000));
        employees.put(4, new Employee(4, "Lakshmi Gowda", "lakshmi.gowda@example.com", "9876543213",
                new GregorianCalendar(1975, Calendar.DECEMBER, 10).getTime(), Department.HR, 300000));


        Map<Integer,Employee> filteredEmployees = employees.entrySet().stream()
                .filter(entry -> entry.getValue().getSalary() > 500000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        filteredEmployees.forEach((key,value) -> System.out.println(key+" : "+value));


    }
}
