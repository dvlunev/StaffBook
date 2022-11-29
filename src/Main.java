import java.util.Locale;
import java.util.Random;

public class Main {
        public static void main(String[] args) {


                EmployeeBook employeeBook = new EmployeeBook();

                employeeBook.addEmployee("Иванов Иван Иванович", 4,45000.45);
                employeeBook.addEmployee("Петров Петр Петрович", 6,55000.45);
                employeeBook.addEmployee("Александров Александр Александрович", 2,-5);
                employeeBook.addEmployee("", 4,75000.45);
                for (int i = 1; i <= 4; i++) {
                        employeeBook.generateEmployee();
                }

                // Базовая сложность
                System.out.println("Базовая сложность");
                employeeBook.printAllEmployees();
                System.out.println();

                System.out.println("Фонд оплаты труда на месяц составляет " + employeeBook.countSumSalary());
                System.out.println();

                System.out.println("Сотрудник с минимальной заработной платой: " + employeeBook.findMinSalary());
                System.out.println();

                System.out.println("Сотрудник с минимальной заработной платой: " + employeeBook.findMaxSalary());
                System.out.println();

                System.out.println("Средняя заработная плата составляет " + employeeBook.countAverageSalary());
                /*Вопрос 1 На разборе показывали именно этот код, а он не работает, почему?
                System.out.printf(Locale.US,"Средняя заработная плата составляет %.2f%n" + countAverageSalary());
                Выдает эксепшн:
                Средняя заработная плата составляет Exception in thread "main" java.util.MissingFormatArgumentException: Format specifier '%.2f'
                at java.base/java.util.Formatter.format(Formatter.java:2672)
                at java.base/java.io.PrintStream.format(PrintStream.java:1111)
                at java.base/java.io.PrintStream.printf(PrintStream.java:1001)
                at Main.main(Main.java:29)*/
                System.out.println();

                employeeBook.printEmployessNames();
                System.out.println();

                // Повышенная сложность
                System.out.println("Повышенная сложность");
                employeeBook.indexationSalaryEmployees(12);
                employeeBook.printAllEmployees();
                System.out.println();

                int departmentNumber = 4;

                System.out.println("Сотрудник с минимальной заработной платой из отдела " + departmentNumber + ": " +
                        employeeBook.findMinSalaryOfDepartment(departmentNumber));
                System.out.println();

                System.out.println("Сотрудник с максимальной заработной платой из отдела " + departmentNumber + ": " +
                        employeeBook.findMaxSalaryOfDepartment(departmentNumber));
                System.out.println();

                System.out.println("Фонд оплаты труда на месяц по отделу " + departmentNumber + " составляет " +
                        employeeBook.countSumSalaryOfDepartment(departmentNumber));
                System.out.println();

                System.out.println("Средняя заработная плата по отделу " + departmentNumber + " составляет " +
                        employeeBook.countAverageSalaryOfDepartment(departmentNumber));
                System.out.println();

                employeeBook.indexationSalaryOfDepartmenEmployees(departmentNumber, 12);

                employeeBook.printAllEmployeesOfDepartmen(departmentNumber);
                System.out.println();

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.findLessOfNumberSalary(100_000);
                System.out.println();

                employeeBook.findMorOfNumberSalary(100_000);
                System.out.println();

                // Очень сложно
                System.out.println("Очень сложно");

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.removeEmployee("Александров Александр Александрович", 3);
                System.out.println();

                employeeBook.findAndEditFullNameEmployee(4, "Антонов Антон Антонович");
                System.out.println();

                employeeBook.findAndEditSalaryEmployee("Иванов Иван Иванович", 64999.99);
                System.out.println();

                employeeBook.findAndEditDepartmentEmployee("Петров Петр Петрович", 1);
                System.out.println();

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.generateEmployee();

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.printAllDepartmentsAndFullNamesEmployees();

                employeeBook.generateEmployee();
                System.out.println();

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.addEmployee("", 6,-5);
                System.out.println();

                employeeBook.printAllEmployees();
                System.out.println();

                employeeBook.addEmployee("Александров Александр Александрович", 2,-5);
                System.out.println();

                employeeBook.printAllEmployees();
                System.out.println();
        }
}