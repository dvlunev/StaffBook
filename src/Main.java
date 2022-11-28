public class Main {
    private static Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee("Иванов Иван Иванович", 1, RandomSalary());
        EMPLOYEES[1] = new Employee("Петров Петр Петрович", 2, RandomSalary());
        EMPLOYEES[2] = new Employee("Сергеев Сергей Сергеевич", 3, RandomSalary());
        EMPLOYEES[3] = new Employee("Алексеев Алексей Алексеевич", 4, RandomSalary());
        EMPLOYEES[4] = new Employee("Александров Александр Александрович", 5, RandomSalary());
        EMPLOYEES[5] = new Employee("Михайлов Михаил Михайлович", 5, RandomSalary());
        EMPLOYEES[6] = new Employee("", 6, -1);

        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }
        }

        System.out.println("Фонд оплаты труда на месяц составляет " + SalarySum());

        // EMPLOYEES[6] = new Employee("Антонов Антон Антонович", 5, RandomSalary());
        // System.out.println(EMPLOYEES[6]);

        System.out.println();

        System.out.println("Фонд оплаты труда на месяц составляет " + SalarySum());

        System.out.println();

        MinSalary();

        System.out.println();

        MaxSalary();

        System.out.println();

        System.out.println("Средняя заработная плата составляет " + AverageSalary());

        System.out.println();

        PrintEmplouessNames();
    }

    public static int RandomSalary() {
        java.util.Random random = new java.util.Random();
        int RandomSalary;
        RandomSalary = random.nextInt(50_000) + 50_000;
        return RandomSalary;
    }

    public static int SalarySum() {
        int salarySum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                salarySum = salarySum + employee.getSalary();
            }
        }
        return salarySum;
    }

    public static void MinSalary() {
        int minSalary = Integer.MAX_VALUE;
        Employee minEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    minEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой: id " + minEmployee.getId() + " Сотрудник " +
                minEmployee.getFullName() + " отдел " + minEmployee.getDepartmentNumber() + " зарплата " +
                minEmployee.getSalary());
    }

    public static void MaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    maxEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой: id " + maxEmployee.getId() + " Сотрудник " +
                maxEmployee.getFullName() + " отдел " + maxEmployee.getDepartmentNumber() + " зарплата " +
                maxEmployee.getSalary());
    }

    public static double AverageSalary() {
        int employeesCount = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    employee.getFullName() != "" && employee.getSalary() > 0) {
                employeesCount++;
            }
        }
        return SalarySum() / (double) employeesCount;
    }

    public static void PrintEmplouessNames() {
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
}