import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The class describing an employee
 */
public class Employee {
    private String fullName; // Так как сделана проверка на пустое имя, то должна быть возможность его изменения
    private int departmentNumber;
    private double salary;
    private static int count = 1;
    private int id;

    private DecimalFormat dF = new DecimalFormat("#.##");

    public Employee(String fullName, int departmentNumber, double salary) {
        this.fullName = fullName;
        if (departmentNumber > 0 && departmentNumber < 6) {
            this.departmentNumber = departmentNumber;
        }
        if (salary > 0) {
            this.salary = salary;
        }
        this.id = count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) { // Так как сделана проверка на пустое имя, то должна быть возможность его изменения
        this.fullName = fullName;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object fullNameInputControl() {
        if (!fullName.equals("")) {
            return fullName;
        } else {
            return "- Введите ФИО сотрудника -";
        }
    }

    public Object departmentInputControl() {
        if (departmentNumber > 0 && departmentNumber < 6) {
            return departmentNumber;
        } else {
            return "- Введите корректный номер отдела от 1 до 5 -";
        }
    }

    public Object salaryInputControl() {
        if (salary > 0) {
            return dF.format(salary);
        } else {
            return "- Введите корректный размер заработной платы -";
        }
    }

    @Override
    public String toString() {
        return "id " + id + " Сотрудник " + fullNameInputControl() + " отдел " + departmentInputControl() +
                " зарплата " + salaryInputControl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
    }
}
