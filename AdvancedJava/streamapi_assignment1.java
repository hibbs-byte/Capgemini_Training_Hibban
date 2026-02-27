import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee
{
    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsofexperience;
    private double salary;
    private int performancerating;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getAge() {
        return age;
    }

    public int getYearsofexperience() {
        return yearsofexperience;
    }

    public double getSalary() {
        return salary;
    }

    public int getPerformancerating() {
        return performancerating;
    }
}



class tasks {
    List<String> tasks1(List<Employee> emp1) {
        return emp1.stream().filter(a -> a.getJobTitle().equalsIgnoreCase("Developer") && a.getSalary() > 90000 && a.getYearsofexperience() < 4)
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Comparator.comparingInt(Employee::getPerformancerating).reversed()))
                .map(a -> a.getName().toUpperCase() + "_DEV")
                .toList();
    }
    List<String> tasks2(List<Employee> emp1) {
        return emp1.stream().filter(a->a.getDepartment().equalsIgnoreCase("HR") && a.getPerformancerating()<6 && a.getYearsofexperience()>6 && a.getSalary()>50000 && a.getSalary()<120000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getYearsofexperience))
                .map(a->new StringBuilder(a.getName())
                        .reverse()
                        .toString())
                .collect(Collectors.toList());

    }
    List<Integer> tasks3(List<Employee> emp1)
    {
        return emp1.stream().filter(a->a.getDepartment().length()>5 && a.getAge()>28 && a.getAge()<45 && a.getSalary()<75000)
                .sorted(Comparator.comparingInt(Employee::getPerformancerating).reversed().thenComparing(Employee::getName))
                .map(a->a.getId()*5)
                .collect(Collectors.toList());

    }
}




