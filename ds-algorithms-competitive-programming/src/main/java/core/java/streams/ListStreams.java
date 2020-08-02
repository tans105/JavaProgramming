package core.java.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStreams {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("T1", 10000, true));
        employeeList.add(new Employee("T2", 20000, true));
        employeeList.add(new Employee("T3", 30000, true));
        employeeList.add(new Employee("T4", 40000, false));
        employeeList.add(new Employee("T5", 50000, false));

        /* Get 3 Highest earning employee */
        employeeList.stream()
                .sorted()
                .limit(3)
                .map(e1 -> e1.name)
                .forEach(System.out::println);
        System.out.println();

        /* OR ( if comparator/comparable is not implemented ) */
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .map(e1 -> e1.name)
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        /* ----------------------------Collectors-------------------------------------------*/

        /* Get 3 highest earning active employees */

        employeeList.stream()
                .sorted()
                .filter((e) -> e.isActive)
                .limit(3)
                .map(e1 -> e1.name)
                .forEach(System.out::println);

        /* Get the list of 3 highest earning active employees */
        List<String> filteredEmployeesList = employeeList.stream()
                .sorted()
                .filter((e) -> e.isActive)
                .limit(3)
                .map(e1 -> e1.name)
                .collect(Collectors.toList());
        System.out.println(filteredEmployeesList);

        /* Get the set of 3 highest earning active employees */
        Set<String> filteredEmployeesSet = employeeList.stream()
                .sorted()
                .filter((e) -> e.isActive)
                .limit(3)
                .map(e1 -> e1.name)
                .collect(Collectors.toSet());
        System.out.println(filteredEmployeesSet);

        /* Get the map of 3 highest earning active employees */
        Map<String, Employee> filteredEmployeesMap = employeeList.stream()
                .sorted()
                .filter((e) -> e.isActive)
                .limit(3)
                .collect(Collectors.toMap(e -> e.name, e -> e));
        System.out.println(filteredEmployeesMap);


        /* Group the list and get the count */
        List<Character> charList = Arrays.asList('a', 'a', 'b', 'b');
        Map<Character, Long> charMap = charList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charMap);
    }
}

class Employee implements Comparable<Employee> {
    String name;
    int salary;
    boolean isActive;

    public Employee(String name, int salary, boolean isActive) {
        this.name = name;
        this.salary = salary;
        this.isActive = isActive;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return o.salary - this.salary;
    }
}
