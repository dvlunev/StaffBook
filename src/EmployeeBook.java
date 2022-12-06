import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class EmployeeBook {

    private final Employee[] employees;

    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    private final String[] names = {"Иван", "Петр", "Сергей"};
    private final String[] surNames = {"Иванов", "Петров", "Сергеев"};
    private final String[] patronymicName = {"Иванович", "Петрович", "Сергеевич"};
    public final Random random = new Random();

    public void addEmployee(String fullName, int departmentNumber, double salary) {
        int i = 0;
        for (Employee employee : employees) {
            if (employee == null && size < employees.length) {
                employee = new Employee(fullName, departmentNumber, salary);
                employees[size++] = employee;
                break;
            } else if (employee == null && size == employees.length) {
                employee = new Employee(fullName, departmentNumber, salary);
                employees[i] = employee;
                employee.setId(i + 1);
                break;
            } else if (employee != null && size <= employees.length) {
                i++;
                if (i >= employees.length) {
                    System.out.println("Штат укомплектован, необходимо изменить штатное расписание");
                    break;
                }
            }
        }
    }

    public void generateEmployee() {
        int i = 0;
        for (Employee employee : employees) {
            if (employee == null && size < employees.length) {
                employee = new Employee(surNames[random.nextInt(surNames.length)] + " " +
                        names[random.nextInt(names.length)] + " " +
                        patronymicName[random.nextInt(patronymicName.length)],
                        random.nextInt(4) + 1,
                        random.nextInt(50_000) + 50_000);
                employees[size++] = employee;
                break;
            } else if (employee == null && size == employees.length) {
                employee = new Employee(surNames[random.nextInt(surNames.length)] + " " +
                        names[random.nextInt(names.length)] + " " +
                        patronymicName[random.nextInt(patronymicName.length)],
                        random.nextInt(4) + 1,
                        random.nextInt(50_000) + 50_000);
                employees[i] = employee;
                employee.setId(i + 1);
                break;
            } else if (employee != null && size <= employees.length) {
                i++;
                if (i >= employees.length) {
                    System.out.println("Штат укомплектован, необходимо изменить штатное расписание");
                    break;
                }
            }
        }
    }

    public void printAllEmployees() {
        System.out.println("Список сотрудников");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeesOfDepartmen(int departmentNumber) {
        System.out.println("Список сотрудников отдела " + departmentNumber);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                System.out.println(employee.toString().replace(" отдел " + departmentNumber, ""));
            }
        }
    }

    public double countSumSalary() {
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public double countSumSalaryOfDepartment(int departmentNumber) {
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 &&
                    employee.getDepartmentNumber() == departmentNumber) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public Employee findMinSalary() {
        double minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 && employee.getSalary() <
                    minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMinSalaryOfDepartment(int departmentNumber) {
        double minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 && employee.getSalary() <
                    minSalary && employee.getDepartmentNumber() == departmentNumber) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalary() {
        double maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 && employee.getSalary() >
                    maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public Employee findMaxSalaryOfDepartment(int departmentNumber) {
        double maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 && employee.getSalary() >
                    maxSalary && employee.getDepartmentNumber() == departmentNumber) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double countAverageSalary() {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0) {
                employeesCount++;
            }
        }
        if (employeesCount != 0) {
            return countSumSalary() / employeesCount;
        } else {
            return 0;
        }
    }

    public double countAverageSalaryOfDepartment(int departmentNumber) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 &&
                    employee.getDepartmentNumber() == departmentNumber) {
                employeesCount++;
            }
        }
        if (employeesCount != 0) {
            return countSumSalaryOfDepartment(departmentNumber) / employeesCount;
        } else {
            return 0;
        }
    }

    public void printEmployessNames() {
        int number = 0;
        System.out.println("Список сотрудников");
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0) {
                number++;
                System.out.println(number + ") " + employee.getFullName());
            }
        }
    }

    public void indexationSalaryEmployees(double indexationPersent) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0) {
                employee.setSalary(employee.getSalary() * (indexationPersent/100 + 1));
            }
        }
    }

    public void indexationSalaryOfDepartmenEmployees(int departmentNumber, double indexationPersent) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 &&
                    employee.getDepartmentNumber() == departmentNumber) {
                employee.setSalary(employee.getSalary() * (indexationPersent/100 + 1));
            }
        }
    }

    public void findLessOfNumberSalary(double numberSalary) {
        System.out.println("Список сотрудников с зарплатой меньше " + numberSalary);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 && employee.getSalary() <
                    numberSalary) {
                System.out.println(employee.toString().replace(" отдел " + employee.getDepartmentNumber(),
                        ""));
            }
        }
    }

    public void findMorOfNumberSalary(double numberSalary) {
        System.out.println("Список сотрудников с зарплатой больше или равно " + numberSalary);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0 &&
                    !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 &&
                    employee.getSalary() >= numberSalary) {
                System.out.println(employee.toString().replace(" отдел " + employee.getDepartmentNumber(),
                        ""));
            }
        }
    }

    public void removeEmployee(String fullName, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (!fullName.equals("") && employees[i].getFullName().equals(fullName) && employees[i].getId() == id) {
                System.out.println("id " + employees[i].getId() + " Сотрудник " + employees[i].getFullName() +
                        " удален(а)");
                employees[i] = null;
                return;
            }
        }
    }

    public void findAndEditFullNameEmployee(int id, String newFullName) { // Добавил, так как может быть fullName = ""
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                System.out.println("Имя сотрудника изменено с " + employee.getFullName() + " id " + employee.getId() +
                        " на " + newFullName);
                employee.setFullName(newFullName);
                return;
            }
        }
    }

    public void findAndEditSalaryEmployee(String fullName, double newSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                System.out.print("Заработная плата id " + employee.getId() + " Сотрудника " + employee.getFullName());
                System.out.printf(Locale.US," изменена с %.2f%n",employee.getSalary());
                System.out.println(" на " + newSalary);
                employee.setSalary(newSalary);
                return;
            }
        }
    }

    public void findAndEditDepartmentEmployee(String fullName, int newDepartmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                System.out.println("Изменился отдел у id " + employee.getId() + " Сотрудника " + employee.getFullName() +
                        " с " + employee.getDepartmentNumber() + " на " + newDepartmentNumber);
                employee.setDepartmentNumber(newDepartmentNumber);
                return;
            }
        }
    }

    public void printAllDepartmentsAndFullNamesEmployees() {
        for (int departmentNumber = 1; departmentNumber < 5; departmentNumber++) {
            int number = 1;
            System.out.println("Список сотрудников отдела " + departmentNumber);
            for (Employee employee : employees) {
                if (employee != null && (employee.getDepartmentNumber() <= 5 && employee.getDepartmentNumber() > 0) &&
                        !Objects.equals(employee.getFullName(), "") && employee.getSalary() > 0 &&
                        employee.getDepartmentNumber() == departmentNumber) {
                    System.out.println(number + ") " + employee.getFullName());
                    number++;
                }
            }
        }
    }
}
