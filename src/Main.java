import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        Employee employee1 = new Employee(Employee.getCounter(), "Андрей", "Андреевич", "Андреев", 25000, 2);
        Employee employee2 = new Employee(Employee.getCounter(), "Александр", "Александрович", "Александров", 15000.10, 2);
        Employee employee3 = new Employee(Employee.getCounter(), "Сергей", "Сергеевич", "Сергеев", 123350.50, 2);
        Employee employee4 = new Employee(Employee.getCounter(), "Анатолий", "Анатольевич", "Анатольев", 25500.50, 4);
        Employee employee5 = new Employee(Employee.getCounter(), "Виталий", "Витальевич", "Витальев", 20100.70, 5);
        Employee employee6 = new Employee(Employee.getCounter(), "Евгений", "Евгеньевич", "Евгеньев", 10000.23, 1);
        Employee employee7 = new Employee(Employee.getCounter(), "Семён", "Семёнович", "Семенов", 66541.23, 2);
        Employee employee8 = new Employee(Employee.getCounter(), "Вадим", "Вадимович", "Вадимов", 20578.54, 2);
        Employee employee9 = new Employee(Employee.getCounter(), "Петр", "Петрович", "Петров", 67182.23, 1);
        Employee employee10 = new Employee(Employee.getCounter(), "Фёдор", "Федорович", "Федоров", 98656.23, 5);
        addEmployee(employees, employee1);
        addEmployee(employees, employee2);
        addEmployee(employees, employee3);
        addEmployee(employees, employee4);
        addEmployee(employees, employee5);
        addEmployee(employees, employee6);
        addEmployee(employees, employee7);
        addEmployee(employees, employee8);
        addEmployee(employees, employee9);
        addEmployee(employees, employee10);


        System.out.println("ВСЕ СОТРУДНИКИ СПИСКОМ");
        showEmployeesToString(employees);
        separator();

        System.out.println("ФИО СОТРУДНИКОВ СПИСКОМ");
        showEmployeesFirstMiddleLastName(employees);
        separator();

        System.out.println("ОБЩИЕ ЗАТРАТЫ ЗА ЗАРПЛАТУ");
        salarySummPerMonth(employees);
        separator();

        System.out.println("СРЕДНИЕ ЗАТРАТЫ НА ЗАРПЛАТЫ");
        averageExpenses(employees);
        separator();

        System.out.println("СОТРУДНИК С САМОЙ БОЛЬШОЙ ЗАРПЛАТОЙ");
        findEmpWithMaxSal(employees);
        separator();

        System.out.println("СОТРУДНИК С САМОЙ МАЛЕНЬКОЙ ЗАРПЛАТОЙ");
        findEmpWithMinSal(employees);
        separator();
        System.out.println();

        separator();
        separator();
        System.out.println("ПОВЫШЕННАЯ СЛОЖНОСТЬ");
        separator();
        separator();

        System.out.println("ЗАРПЛАТЫ ПОСЛЕ ПЕРВОЙ ИНДЕКСАЦИИ");
        indexSalaryByPersent(employees, 10);
        separator();

        showEmployeesToString(employees);
        separator();

        System.out.println("НАЙТИ МАКСИМАЛЬНУЮ И МИНИМАЛЬНУЮ ЗАРПЛАТУ ПО ОПРЕДЕЛЁННОМУ ОТДЕЛУ");
        findEmplWithMinSalByDeptnum(employees, 2);
        separator();

        findEmplWithMaxSalByDeptnum(employees, 2);
        separator();

        averageCostByDeptNumber(employees, 2);
        separator();

        totalCostByDeptNumber (employees,2);
        separator();

        System.out.println("ЗАРПЛАТЫ ПОСЛЕ ВТОРОЙ ИНДЕКСАЦИИ");
        indexSalaryByPersent(employees, 10);
        showEmployeesToStringWithoutDeptNum(employees);
        separator();


        System.out.println("ВЫВЕСТИ В КОНСОЛЬ СОТРУДНИКОВ С ЗАРПЛАТОЙ БОЛЬШЕ И МЕНЬШЕ УКАЗАННОГО В ПАРАМЕТРЕ ЧИСЛА");

        System.out.println("СПИСОК СОТРУДНИКОВ С МЕНЬШЕЙ ЗАРПЛАТОЙ, ЧЕМ УКАЗАННОЕ ЧИСЛО");
        findSalaryLesThanValue(employees,100_000.50);
        separator();

        System.out.println("СПИСОК СОТРУДНИКОВ С БОЛЬШЕЙ ЗАРПЛАТОЙ, ЧЕМ УКАЗАННОЕ ЧИСЛО");
        findSalaryMorThanValue(employees,100_000.50);
        separator();
    }

    private static void addEmployee(Employee[] employees, Employee employee) { //добавить сотрудника
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    private static void showEmployeesToString(Employee[] employees) { // получить список всех сотрудников
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println("ID сотрудника: " + employee.getId() + ": " +
                    "ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ",  " +
                    "Заработная плата сотрудника: " + employee.getSallary() + ", " +
                    "Номер подразделения: " + +employee.getDeptNum());
        }
    }

    private static void showEmployeesToStringWithoutDeptNum(Employee[] employees) { // получить список всех сотрудников без номера отдела
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.print("ID сотрудника: " + employee.getId() + ": " +
                    "ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
            System.out.printf ( "Заработная плата сотрудника: " + "%.2f",employee.getSallary());
            System.out.println();
        }
    }

    private static void showEmployeesFirstMiddleLastName(Employee[] employees) { //ФИО списком
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println("ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
        }
    }

    private static void salarySummPerMonth(Employee[] employees) { //Общие затраты на зарплаты в месяц
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

    private static void averageExpenses(Employee[] employees) {
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

    private static void findEmpWithMaxSal(Employee[] employees) {
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
        System.out.println("Сотрудник с самой большой зарплатой: " + "ID сотрудника: " + employee.id + ", " +
                "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " +
                "Номер департамента: " + employee.deptNum + ", " +
                "Уровень его дохода составляет: " + maxValue + " рублей");
    }

    private static void findEmpWithMinSal(Employee[] employees) {
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
        System.out.println("Сотрудник с самой маленькой зарплатой: " + "ID сотрудника: " + employee.id + ", " +
                "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " +
                "Номер департамента " + employee.deptNum + ", " +
                "Уровень его дохода составляет: " + minValue + " рублей");
    }

    private static void findEmplWithMinSalByDeptnum(Employee[] employees, int deptNum) { //поиск минимального дохода по номеру отдела
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
                    System.out.println("Сотрудник с самой маленькой зарплатой в отделе: " + "ID сотрудника: " + employee.id + ", " +
                            "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " +
                            "Номер департамента " + employee.deptNum + ", " +
                            "Уровень его дохода составляет: " + minSalary + " рублей");
                    break;
                }
            }
        }
    }

    private static void findEmplWithMaxSalByDeptnum(Employee[] employees, int deptNum) { //поиск максимального дохода по номеру отдела
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
                    System.out.println("Сотрудник с самой большой зарплатой в отделе: " + "ID сотрудника: " + employee.id + ", " +
                            "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " +
                            "Номер департамента " + employee.deptNum + ", " +
                            "Уровень его дохода составляет: " + minSalary + " рублей");

                }
            }
        }
    }

    private static void averageCostByDeptNumber(Employee[] employees, int deptNum) { // Средний уровень зарплат по выбранному отделу
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

    private static void totalCostByDeptNumber(Employee[] employees, int deptNum) { // Общие затраты на зарплаты по выбранному отделу
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

    private static void indexSalaryByPersent(Employee[] employees, int persent) { //Индексация зарплаты всем сотрудникам на определённый процент
        double index;
        double salAfterIndex = 0;
        for (Employee employee : employees) {
            index = (employee.getSallary() * persent) / 100;
            salAfterIndex = employee.getSallary() + index;
            employee.setSallary(salAfterIndex);

        }
    }





    private static void findSalaryLesThanValue (Employee[] employees, double someValue) { //поиск максимального дохода по номеру отдела
        for (Employee employee:employees) {
        if (employee != null) {
                if (employee.getSallary() < someValue) {
                    System.out.print("Сотрудник с зарплатой меньше указанного числа: " + "ID сотрудника: " + employee.id + ", " +
                            "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName  + " ");
                            System.out.printf( "Уровень его дохода составляет: " + "%.2f",employee.getSallary());
                            System.out.println(" рублей");
                }
            }
        }
    }

    private static void findSalaryMorThanValue (Employee[] employees, double someValue) { //поиск максимального дохода по номеру отдела
        for (Employee employee:employees) {
            if (employee != null) {
                if (employee.getSallary() > someValue) {
                    System.out.print("Сотрудник с  зарплатой больше указанного числа: " + "ID сотрудника: " + employee.id + ", " +
                            "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName  + " ");
                    System.out.printf( "Уровень его дохода составляет: " + "%.2f",employee.getSallary());
                    System.out.println(" рублей");
                }
            }
        }
    }


    private static void separator() {
        System.out.println("===================================================================================================================");
    }
}