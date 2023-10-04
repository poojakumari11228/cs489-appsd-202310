import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
public class PensionPlansManagementMain
{

    private static void printAllEmployeesInOrder(List<Employee> employees) {

        System.out.println("*** ASC order or last name & desc order of Yearly Salary ***");

        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }



    private static void printMonthlyUpcomingEnrollEmployees(List<Employee> employees) {

        System.out.println("*** printMonthlyUpcomingEnrollees ***");

        employees.stream()
                .filter(x->isUpcomingEnrollee(x))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .forEach(System.out::println);
    }

    public static boolean isUpcomingEnrollee(Employee emp) {
        var nextDate = LocalDate.now().plusMonths(1L);
        var nextYear = nextDate.getYear();
        var nextMonth = nextDate.getMonth();
        var enrollQualificationDate = emp.getEmploymentDate().plusYears(5L);
        return ((enrollQualificationDate.getYear() == nextYear)
                && (enrollQualificationDate.getMonth().equals(nextMonth))
                && (emp.getPensionPlan() == null)
        );
    }

    public static void main( String[] args ) {

        var employees = List.of(
                new Employee(1L, "Pooja", "Kumari", LocalDate.of(2021,12,28), 105945.50, "EX1089", LocalDate.of(2013,1,2), 1200.00),
                new Employee(3L, "Mack", "Linda", LocalDate.of(2023,05,26), 842000.75, "SM2307", LocalDate.of(2019,11,4), 1115.02),
                new Employee(4L, "Jack", "Marry", LocalDate.of(2018,11,2), 74500.00, null, null, null),
                new Employee(5L, "Tom", "Mand", LocalDate.of(2018,11,22), 74500.00, null, null, null)
        );


        printAllEmployeesInOrder(employees);
        printMonthlyUpcomingEnrollEmployees(employees);
    }

}
