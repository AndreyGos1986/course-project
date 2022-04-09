import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook(int arrSize) {
        this.employees = new Employee[arrSize];
    }

    public void addEmployee(Employee employee) { //добавить сотрудника
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    private Employee findEmployee(String firstMame, String middleName, String lastName, int idNum) { // поиск сотрудника
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstMame) && employee.getMiddleName().equalsIgnoreCase(middleName) && employee.getLastName().equalsIgnoreCase(lastName) || employee.getId() == idNum) {
                    return employee;
                }
            }
        }
        return null;
    }

    public void findEmployeeByDeptNumAndSout(int idNum1, int idNum2, int idNum3, int idNum4, int idNum5) { // поиск и вывод в консоль всех сотрудников одного отдела

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDeptNum() == idNum1) {
                    System.out.println("Список сотрудников 1-го отдела" + " " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
                }
            }
        }
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDeptNum() == idNum2) {
                    System.out.println("Список сотрудников 2-го отдела" + " " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
                }
            }
        }
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDeptNum() == idNum3) {
                    System.out.println("Список сотрудников 3-го отдела" + " " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
                }
            }
        }
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDeptNum() == idNum4) {
                    System.out.println("Список сотрудников 4-го отдела" + " " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
                }
            }
        }
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDeptNum() == idNum5) {
                    System.out.println("Список сотрудников 5-го отдела" + " " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());

                }
            }
        }
    }

    public void deleteEmployee(String firstMame, String middleName, String lastName, int idNum) { // удаление сотрудника
        Employee employee = findEmployee(firstMame, middleName, lastName, idNum);
        for (int i = 0; i < employees.length; i++) {
            if (employee != null) {
                if (employees[i].getFirstName().equalsIgnoreCase(employee.getFirstName()) && employees[i].getMiddleName().equalsIgnoreCase(employee.getMiddleName()) && employees[i].getLastName().equalsIgnoreCase(employee.getLastName()) || employees[i].getId() == employee.getId()) {
                    employees[i] = null;
                    break;
                }
            }
        }
    }

    public void changeEmployee(String firstMame, String middleName, String lastName, int idNum, double newSalary, int newDeptNum) {
        Employee employee = findEmployee(firstMame, middleName, lastName, idNum);
        if (employee != null) {
            employee.setSallary(newSalary);
            employee.setDéptNum(newDeptNum);
        }
    }


    public void showEmployeesToString() { // получить список всех сотрудников
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println("ID сотрудника: " + employee.getId() + ": " + "ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ",  " + " Заработная плата сотрудника: " + employee.getSallary() + ", " + "Номер подразделения: " + employee.getDeptNum());
        }
    }

    public void showEmployeesToStringWithoutDeptNum() { // получить список всех сотрудников без номера отдела
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.print("ID сотрудника: " + employee.getId() + ": " + "ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
            System.out.printf("Заработная плата сотрудника: " + "%.2f", employee.getSallary());
            System.out.println();
        }
    }

    public void showEmployeesFirstMiddleLastName() { //ФИО списком
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println("ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
        }
    }

    public void salarySummPerMonth() { //Общие затраты на зарплаты в месяц
        double t;
        double summ = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                t = employees[i].getSallary();
                summ += t;
            } else break;
        }
        System.out.printf("Общая затрата на зарплаты в месяц составила " + "%.2f", summ);
        System.out.println();
    }

    public void averageExpenses() {
        double t;
        double summ = 0;
        double average;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                t = employees[i].getSallary();
                summ += t;
            } else break;
        }
        System.out.printf("Среднее значение заработных плат: " + "%.2f", summ / employees.length);
        System.out.println();
    }

    public void findEmpWithMaxSal() {
        Employee employee = new Employee(Employee.getCounter(), " ", " ", " ", 0.0, 0);
        double maxValue = employees[0].sallary;
        for (int i = employees.length - 1; i > 0; i--) {
            if (employees[i] != null) {

                if (maxValue < employees[i].sallary) {
                    maxValue = employees[i].sallary;
                    employee.lastName = employees[i].lastName;
                    employee.firstName = employees[i].firstName;
                    employee.middleName = employees[i].middleName;
                    employee.deptNum = employees[i].deptNum;
                    employee.id = employees[i].getId();
                }
            }
        }
        System.out.println("Сотрудник с самой большой зарплатой: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " + "Номер департамента: " + employee.deptNum + ", " + "Уровень его дохода составляет: " + maxValue + " рублей");
    }

    public void findEmpWithMinSal() {
        Employee employee = new Employee(Employee.getCounter(), " ", " ", " ", 0.0, 0);
        double minValue = employees[0].sallary;
        for (int i = 0; i < employees.length; i++) {
            if (minValue > employees[i].sallary) {
                minValue = employees[i].sallary;
                employee.lastName = employees[i].lastName;
                employee.firstName = employees[i].firstName;
                employee.middleName = employees[i].middleName;
                employee.deptNum = employees[i].deptNum;
                employee.id = employees[i].id;

            }
        }
        System.out.println("Сотрудник с самой маленькой зарплатой: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " + "Номер департамента " + employee.deptNum + ", " + "Уровень его дохода составляет: " + minValue + " рублей");
    }

    public void findEmplWithMinSalByDeptnum(int deptNum) { //поиск минимального дохода по номеру отдела
        Employee employee = new Employee(0, " ", " ", " ", 0.0, 0);
        double minSalary = employees[0].getSallary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minSalary > employees[i].getSallary() && employees[i].getDeptNum() == deptNum) {
                    minSalary = employees[i].getSallary();
                    employee.id = employees[i].getId();
                    employee.lastName = employees[i].lastName;
                    employee.firstName = employees[i].firstName;
                    employee.middleName = employees[i].middleName;
                    employee.deptNum = employees[i].deptNum;
                    System.out.println("Сотрудник с самой маленькой зарплатой в отделе: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " + "Номер департамента " + employee.deptNum + ", " + "Уровень его дохода составляет: " + minSalary + " рублей");
                    break;
                }
            }
        }
    }

    public void findEmplWithMaxSalByDeptnum(int deptNum) { //поиск максимального дохода по номеру отдела
        Employee employee = new Employee(0, " ", " ", " ", 0.0, 0);
        double minSalary = employees[0].getSallary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minSalary < employees[i].getSallary() && employees[i].getDeptNum() == deptNum) {
                    minSalary = employees[i].getSallary();
                    employee.id = employees[i].getId();
                    employee.lastName = employees[i].lastName;
                    employee.firstName = employees[i].firstName;
                    employee.middleName = employees[i].middleName;
                    employee.deptNum = employees[i].deptNum;
                    System.out.println("Сотрудник с самой большой зарплатой в отделе: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " + "Номер департамента " + employee.deptNum + ", " + "Уровень его дохода составляет: " + minSalary + " рублей");

                }
            }
        }
    }

    public void averageCostByDeptNumber(int deptNum) { // Средний уровень зарплат по выбранному отделу
        double t;
        double summ = 0;
        double average = 0;
        int counter = 0;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].deptNum == deptNum) {
                counter++;
                t = employees[i].getSallary();
                summ += t;
                average = summ / counter;
            }
        }
        System.out.printf("Среднее значение заработных плат по выбранному отделу: " + "%.3f", average);
        System.out.println();
    }

    public void totalCostByDeptNumber(int deptNum) { // Общие затраты на зарплаты по выбранному отделу
        Arrays.sort(employees, deptNum, deptNum);
        double t;
        double summ = 0;
        double totalCost = 0;


        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].deptNum == deptNum) {
                t = employees[i].getSallary();
                totalCost += t;

            }
        }
        System.out.printf("Общие затраты на заработные платы по выбранному отделу: " + "%.3f", totalCost);
        System.out.println();
    }

    public void indexSalaryByPersent(int persent) { //Индексация зарплаты всем сотрудникам на определённый процент
        double index;
        double salAfterIndex = 0;
        for (Employee employee : employees) {
            index = (employee.getSallary() * persent) / 100;
            salAfterIndex = employee.getSallary() + index;
            employee.setSallary(salAfterIndex);

        }
    }


    public void findSalaryLesThanValue(double someValue) { //поиск максимального дохода по номеру отдела
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSallary() < someValue) {
                    System.out.print("Сотрудник с зарплатой меньше указанного числа: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + " ");
                    System.out.printf("Уровень его дохода составляет: " + "%.2f", employee.getSallary());
                    System.out.println(" рублей");
                }
            }
        }
    }

    public void findSalaryMorThanValue(double someValue) { //поиск максимального дохода по номеру отдела
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSallary() > someValue) {
                    System.out.print("Сотрудник с  зарплатой больше указанного числа: " + "ID сотрудника: " + employee.id + ", " + "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + " ");
                    System.out.printf("Уровень его дохода составляет: " + "%.2f", employee.getSallary());
                    System.out.println(" рублей");
                }
            }
        }
    }


    public void separator() {
        System.out.println("================================================================================================================" +
                            "===============================================================================================================");
    }
}