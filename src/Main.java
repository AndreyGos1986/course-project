
public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        Employee employee1 = new Employee(Employee.getCounter(), "Андрей", "Андреевич", "Андреев", 10000.10, 1);
        Employee employee2 = new Employee(Employee.getCounter(), "Александр", "Александрович", "Александров", 9500.20, 2);
        Employee employee3 = new Employee(Employee.getCounter(), "Сергей", "Сергеевич", "Сергеев", 123350.50, 3);
        Employee employee4 = new Employee(Employee.getCounter(), "Анатолий", "Анатольевич", "Анатольев", 798949.60, 5);
        Employee employee5 = new Employee(Employee.getCounter(), "Виталий", "Витальевич", "Витальев", 20100.70, 4);
        Employee employee6 = new Employee(Employee.getCounter(), "Евгений", "Евгеньевич", "Евгеньев", 10000.23, 5);
        Employee employee7 = new Employee(Employee.getCounter(), "Семён", "Семёнович", "Семенов", 666780.23, 2);
        Employee employee8 = new Employee(Employee.getCounter(), "Вадим", "Вадимович", "Вадимов", 20578.54, 1);
        Employee employee9 = new Employee(Employee.getCounter(), "Петр", "Петрович", "Петров", 67182.23, 1);
        Employee employee10 = new Employee(Employee.getCounter(), "Фёдр", "Федорович", "Федоров", 98656.23, 2);

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

        System.out.println("ФИО СОТРУДНИКИ СПИСКОМ");
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
            System.out.println("ID сотрудника: " + Employee.getCounter() + ": " +
                    "ФИО сотрудника: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ",  " +
                    "Заработная плата сотрудника: " + employee.getSallary() + ", " +
                    "Номер подразделения: " + +employee.getDeptNum());
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
                    employee.id = employees[i].id;

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
                employee.id = employees[i].getId();

            }
        }
        System.out.println("Сотрудник с самой маленькой зарплатой: " + "ID сотрудника: " + employee.id + ", " +
                "ФИО сотрудника: " + employee.lastName + " " + employee.firstName + " " + employee.middleName + ", " +
                "Номер департамента " + employee.deptNum + ", " +
                "Уровень его дохода составляет: " + minValue + " рублей");
    }

    private static void separator() {
        System.out.println("======================================================================");
    }
}