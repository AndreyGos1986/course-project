public class Employee {
    static int counter = 0;
    int id;
    String firstName;
    String middleName;
    String lastName;
    double sallary;
    int deptNum;


    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public void setDéptNum(int déptNum) {
        this.deptNum = déptNum;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSallary() {
        return sallary;
    }

    public int getDeptNum() {
        return deptNum;
    }

    public Employee(int id, String firstName, String middleName,
                    String lastName, double sallary, int deptNum) {
        this.id = counter;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sallary = sallary;
        this.deptNum = deptNum;
    }

    public static int getCounter() {
        return counter++;
    }

}



