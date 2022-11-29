import java.util.Locale;
import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];
    private static final String[] NAMES = {"Иван", "Петр", "Сергей"};
    private static final String[] SURNAMES = {"Иванов", "Петров", "Сергеев"};
    private static final String[] PATRONYMICNAME = {"Иванович", "Петрович", "Сергеевич"};
    public static final Random RANDOM = new Random(5);

    public static void main(String[] args) {

        // Базовая сложность
        System.out.println("Базовая сложность");
        for (int i = 0; i < EMPLOYEES.length - 1; i++) {
            EMPLOYEES[i] = generateEmployee();
        }
        EMPLOYEES[9] = new Employee("Александров Александр Александрович", 6,100_000);

        printAllEmployees();

        System.out.println("Фонд оплаты труда на месяц составляет " + countSumSalary());
        System.out.println();

        System.out.println("Сотрудник с минимальной заработной платой: " + findMinSalary());
        System.out.println();

        System.out.println("Сотрудник с минимальной заработной платой: " + findMaxSalary());
        System.out.println();

        System.out.println("Средняя заработная плата составляет " + countAverageSalary());
        /*System.out.printf(Locale.US,"Средняя заработная плата составляет %.2f%n" + countAverageSalary());
        редняя заработная плата составляет Exception in thread "main" java.util.MissingFormatArgumentException: Format specifier '%.2f'
        at java.base/java.util.Formatter.format(Formatter.java:2672)
        at java.base/java.io.PrintStream.format(PrintStream.java:1111)
        at java.base/java.io.PrintStream.printf(PrintStream.java:1001)
        at Main.main(Main.java:29)*/
        System.out.println();

        printEmployessNames();
        System.out.println();

        // Повышенная сложность
        System.out.println("Повышенная сложность");
        indexationSalaryEmployees(12);
        printAllEmployees();
        System.out.println();

        int departmentNumber = 2;

        System.out.println("Сотрудник с минимальной заработной платой из отдела " + departmentNumber + ": " +
                findMinSalaryOfDepartment(departmentNumber));
        System.out.println();

        System.out.println("Сотрудник с максимальной заработной платой из отдела " + departmentNumber + ": " +
                findMaxSalaryOfDepartment(departmentNumber));
        System.out.println();

        System.out.println("Фонд оплаты труда на месяц по отделу " + departmentNumber + " составляет " +
                countSumSalaryOfDepartment(departmentNumber));
        System.out.println();

        System.out.println("Средняя заработная плата по отделу " + departmentNumber + " составляет " +
                countAverageSalaryOfDepartment(departmentNumber));
        System.out.println();

        indexationSalaryOfDepartmenEmployees(departmentNumber, 12);

        printAllEmployeesOfDepartmen(departmentNumber);
        System.out.println();

        printAllEmployees();
        System.out.println();

        findLessOfNumberSalary(100_000);
        System.out.println();

        findMorOfNumberSalary(104765.92000000001);
        System.out.println();
    }

    private static Employee generateEmployee() {
        String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " " +
                NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                PATRONYMICNAME[RANDOM.nextInt(PATRONYMICNAME.length)];
        return new Employee(fullName,
                RANDOM.nextInt(4) + 1,
                RANDOM.nextInt(50_000) + 50_000 );
    } // На разборе именно этот метод показывали random.nextInt, но с 2мя параметрами,
    // а у меня он позволяет 1 ввести только, почему так?

    private static void printAllEmployees() {
        System.out.println("Список сотрудников");
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static void printAllEmployeesOfDepartmen(int departmentNumber) {
        System.out.println("Список сотрудников отдела " + departmentNumber);
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                System.out.println(employee.toString().replace(" отдел " + departmentNumber, ""));
            }
        }
    }

    private static double countSumSalary() {
        double sumSalary = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    private static double countSumSalaryOfDepartment(int departmentNumber) {
        double sumSalary = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getDepartmentNumber() == departmentNumber) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    private static Employee findMinSalary() {
        double minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    private static Employee findMinSalaryOfDepartment(int departmentNumber) {
        double minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() < minSalary && employee.getDepartmentNumber() == departmentNumber) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    private static Employee findMaxSalary() {
        double maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    private static Employee findMaxSalaryOfDepartment(int departmentNumber) {
        double maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() > maxSalary && employee.getDepartmentNumber() == departmentNumber) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    private static double countAverageSalary() {
        int employeesCount = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                employeesCount++;
            }
        }
        if (employeesCount != 0) {
            return countSumSalary() / employeesCount;
        } else {
            return 0;
        }
    }

    private static double countAverageSalaryOfDepartment(int departmentNumber) {
        int employeesCount = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getDepartmentNumber() == departmentNumber) {
                employeesCount++;
            }
        }
        if (employeesCount != 0) {
            return countSumSalaryOfDepartment(departmentNumber) / employeesCount;
        } else {
            return 0;
        }
    }

    private static void printEmployessNames() {
        int number = 0;
        System.out.println("Список сотрудников компании:");
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                number++;
                System.out.println(number + ") " + employee.getFullName());
            }
        }
    }

    private static void indexationSalaryEmployees(double indexationPersent) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                employee.setSalary(employee.getSalary() * (indexationPersent/100 + 1));
            }
        }
    }

    private static void indexationSalaryOfDepartmenEmployees(int departmentNumber, double indexationPersent) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getDepartmentNumber() == departmentNumber) {
                employee.setSalary(employee.getSalary() * (indexationPersent/100 + 1));
            }
        }
    }

    private static void findLessOfNumberSalary(double numberSalary) {
        System.out.println("Список сотрудников с зарплатой меньше " + numberSalary);
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() < numberSalary) {
                System.out.println(employee.toString().replace(" отдел " + employee.getDepartmentNumber(), ""));
            }
        }
    }

    private static void findMorOfNumberSalary(double numberSalary) {
        System.out.println("Список сотрудников с зарплатой больше или равно " + numberSalary);
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0 && employee.getSalary() >= numberSalary) {
                System.out.println(employee.toString().replace(" отдел " + employee.getDepartmentNumber(), ""));
            }
        }
    }
}