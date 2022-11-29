import java.util.Objects;

public class Employee {
    private String fullName; // Так как сделана проверка на пустое имя, то должна быть возможность его изменения
    private int departmentNumber;
    private double salary;
    private static int count = 1;
    private int id;

    public Employee(String fullName, int departmentNumber, double salary) {
            this.fullName = fullName;
            this.departmentNumber = departmentNumber;
            this.salary = salary;
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

    @Override
    public String toString() { // Не очень нравится как я реализовал, есть ли какой то способ по другому это сделать и реализуются ли эти проверки здесь в туСтринг?
        if (fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary > 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary > 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный номер отдела от 1 до 5";
        } else if (fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary <= 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный номер отдела от 1 до 5 "
                    + "- Введите корректный размер заработной платы";
        } else if (fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary <= 0) {
            return "id " + id + " Сотрудник " + "- Введите ФИО сотрудника " + "- Введите корректный размер заработной платы";
        } else if (!fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary <= 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный номер отдела от 1 до 5 " +
                    "- Введите корректный размер заработной платы";
        } else if (!fullName.equals("") && (departmentNumber <= 0 || departmentNumber >= 6) && salary > 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный номер отдела от 1 до 5";
        } else if (!fullName.equals("") && departmentNumber > 0 && departmentNumber < 6 && salary <= 0) {
            return "id " + id + " Сотрудник " + fullName + " - Введите корректный размер заработной платы";
        } else {
            return "id " + id + " Сотрудник " + fullName + " отдел " + departmentNumber + " зарплата " + salary;
        }
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
