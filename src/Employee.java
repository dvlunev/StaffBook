import java.util.Arrays;

public class Employee {
    private final String fullName;
    private int departmentNumber;
    private int salary;
    private static int count;
    private final int id;

    public Employee(String fullName, int departmentNumber, int salary) {
            this.fullName = fullName;
            this.departmentNumber = departmentNumber;
            this.salary = salary;
            this.id = count + 1;
            this.count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;

    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary > 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary > 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный номер отдела от 1 до 5";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary <= 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный номер отдела от 1 до 5 "
                    + "- Введите корректный размер заработной платы";
        } else if (fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary <= 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный размер заработной платы";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary <= 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный номер отдела от 1 до 5 " +
                    "- Введите корректный размер заработной платы";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary > 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный номер отдела от 1 до 5";
        } else if (fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary <= 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный размер заработной платы";
        } else {
            return "id " + id + " Сотрудник " + fullName + " отдел " + departmentNumber + " зарплата " + salary;
        }
    }
}
