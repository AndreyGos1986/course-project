

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

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
        Employee employee11 = new Employee(Employee.getCounter(), "ололо", "ололо", "ололоев", 98656.23, 1);


        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);
        employeeBook.addEmployee(employee4);
        employeeBook.addEmployee(employee5);
        employeeBook.addEmployee(employee6);
        employeeBook.addEmployee(employee7);
        employeeBook.addEmployee(employee8);
        employeeBook.addEmployee(employee9);
        employeeBook.addEmployee(employee10);

        System.out.println("ВСЕ СОТРУДНИКИ СПИСКОМ");
        employeeBook.showEmployeesToString();
        employeeBook.separator();

        System.out.println("ФИО СПИСКОМ");
        employeeBook.showEmployeesFirstMiddleLastName();
        employeeBook.separator();

        System.out.println("СОТРУДНИК С САМОЙ МАЛЕНЬКОЙ ЗАРПЛАТОЙ ПО НОМЕРУ ОТДЕЛА");
        employeeBook.findEmplWithMinSalByDeptnum(1);
        employeeBook.separator();

        System.out.println("СОТРУДНИК С САМОЙ БОЛЬШОЙ ЗАРПЛАТОЙ ПО НОМЕРУ ОТДЕЛА");
        employeeBook.findEmplWithMaxSalByDeptnum(1);
        employeeBook.separator();

        System.out.println("СРЕДНЯЯ ЗАРПЛАТА ПО НОМЕРУ ОТДЕЛА");
        employeeBook.averageCostByDeptNumber(1);
        employeeBook.separator();

        System.out.println("ОБЩИЕ ЗАТРАТЫ НА ЗАРПЛАТУ ПО НОМЕРУ ОТДЕЛА");
        employeeBook.totalCostByDeptNumber(1);

        //УВЕЛИЧИВАЕМ ЗП ВСЕМ НА 5%
        employeeBook.indexSalaryByPersent(5);
        System.out.println("ЗАРПЛАТЫ ПОСЛЕ ПЕРВОЙ ИНДЕКСАЦИИ");
        employeeBook.showEmployeesToString();
        employeeBook.separator();

        //УВЕЛИЧИВАЕМ ЗП ВСЕМ ЕЩЁ НА 5%
        employeeBook.indexSalaryByPersent(5);
        System.out.println("ЗАРПЛАТЫ ПОСЛЕ ВТОРОЙ ИНДЕКСАЦИИ");
        employeeBook.showEmployeesToString();
        employeeBook.separator();

        //УДАЛЯЮ СОТРУДНИКА
        employeeBook.deleteEmployee("Евгений", "Евгеньевич", "Евгеньев", 6);
        employeeBook.separator();

        //ВЫВОД СПИСКА СОТРУДНИКОВ ПОСЛЕ УДАЛЕНИЯ
        System.out.println("ВСЕ СОТРУДНИКИ СПИСКОМ ПОСЛЕ УДАЛЕНИЯ ОДНОГО СОТРУДНИКА");
        employeeBook.showEmployeesToString();
        employeeBook.separator();

        employeeBook.addEmployee(employee6); //вернул обратно удалённого сотрудника в освобождённую ячейку

        System.out.println("СПИСОК СОТРУДНИКОВ ПОСЛЕ ИЗМЕНЕНИЯ ЗАРПЛАТЫ И НОМЕРА ОТДЕЛА");
        employeeBook.changeEmployee("александр", "александрович", "александров", 2, 201520.25, 5);
        employeeBook.showEmployeesToString();
        employeeBook.separator();

        System.out.println("СПИСОК СОТРУДНИКОВ С ЗАРПЛАТОЙ МЕНЬШЕ УКАЗАННОГО ЗНАЧЕНИЯ");
        employeeBook.findSalaryLesThanValue(120533.20);
        employeeBook.separator();

        System.out.println("СПИСОК СОТРУДНИКОВ С ЗАРПЛАТОЙ БОЛЬШЕ УКАЗАННОГО ЗНАЧЕНИЯ");
        employeeBook.findSalaryMorThanValue(120533.20);
        employeeBook.separator();

        System.out.println("ОБЩИЕ ЗАТРАТЫ ЗА ЗАРПЛАТУ");
        employeeBook.salarySummPerMonth();
        employeeBook.separator();

        System.out.println("СРЕДНИЕ ЗАТРАТЫ НА ЗАРПЛАТЫ");
        employeeBook.averageExpenses();
        employeeBook.separator();

        System.out.println("СОТРУДНИК С САМОЙ БОЛЬШОЙ ЗАРПЛАТОЙ");
        employeeBook.findEmpWithMaxSal();
        employeeBook.separator();

        System.out.println("СОТРУДНИК С САМОЙ МАЛЕНЬКОЙ ЗАРПЛАТОЙ");
        employeeBook.findEmpWithMinSal();
        employeeBook.separator();

        System.out.println("ВСЕ СОТРУДНИКИ ПО ОТДЕЛАМ");
        employeeBook.findEmployeeByDeptNumAndSout(1, 2, 3, 4, 5);
    }
}