import java.util.*;

public class ComparatorFunction {

    private static void print(Object[] arr){
        for(Object o: arr){
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public  static void main(String... s){

        System.out.println("-------------------------------------------------------------------------");
        int[] ints = new int[5];
        Arrays.sort(ints);
//      Arrays.sort(intArr, Comparator.reverseOrder()); custom comparator not allowed on primitive datatypes

        Integer[] integers = new Integer[]{1,2,3,4,5};
        Arrays.sort(integers); // natural order sorting i.e., ascending order
        print(integers);
        Arrays.sort(integers, Comparator.reverseOrder()); // reverse natural order sorting i.e., descending order
        print(integers);

        System.out.println("-------------------------------------------------------------------------");

        String[] strings = new String[]{"alice", "boc", "bob", "charlie"};
        Arrays.sort(strings); // sort by value ASC
        print(strings);
        Arrays.sort(strings, Comparator.reverseOrder()); // sort by value DESC
        print(strings);
        Arrays.sort(strings, Comparator.comparing(String::length)); // sort by length ASC
        print(strings);
        Arrays.sort(strings, Comparator.comparing(String::length).reversed()); // sort by length DESC
        print(strings);
        Arrays.sort(strings, Comparator.comparing(String::length).
                thenComparing(Comparator.naturalOrder())); //sort by length ASC, value ASC
        print(strings);
        System.out.println("-------------------------------------------------------------------------");

        Employee[] employees = new Employee[]{new Employee("Alice", 40),
                new Employee("Bob", 50),
                new Employee("Bob", 30)
        };

        Arrays.sort(employees, Comparator.comparing(Employee::getName)); // Name ASC
        print(employees);
        Arrays.sort(employees, Comparator.comparing(Employee::getName).reversed()); // Name DESC
        print(employees);
        Arrays.sort(employees, Comparator.comparing(Employee::getName).  // Name ASC, Age ASC
                thenComparing(Employee::getAge));
        print(employees);
        Arrays.sort(employees, Comparator.comparing(Employee::getName).     // Name ASC, Age DESC
                thenComparing(Employee::getAge, Comparator.reverseOrder()));
        print(employees);
        Arrays.sort(employees, Comparator.comparing(Employee::getName, Comparator.reverseOrder()).   // Name DESC, Age DESC
                thenComparing(Employee::getAge, Comparator.reverseOrder()));
        print(employees);
        System.out.println("-------------------------------------------------------------------------");


        Comparator<int[]> compareBy0thIndexASC = (a, b) -> { return a[0] - b[0];};
        Queue<int[]> pqInt = new PriorityQueue<>(compareBy0thIndexASC);
        pqInt.add(new int[]{1,2});
        pqInt.add(new int[]{2,1});
        pqInt.add(new int[]{1,1});

        while(!pqInt.isEmpty()) {
            int[] t = pqInt.poll();
            for(int i : t) System.out.print(i + ",");
            System.out.print(",,");
        }

        Comparator<int[]> compareBy0thIndexDESC = (a, b) -> { return b[0] - a[0];};
        Comparator<int[]> compareBy1stIndexASC = (a, b) -> { return a[1] - b[1];};
        pqInt = new PriorityQueue<>(compareBy0thIndexDESC.thenComparing(compareBy1stIndexASC));
        pqInt.add(new int[]{1,2});
        pqInt.add(new int[]{2,1});
        pqInt.add(new int[]{1,1});

        System.out.println();
        while(!pqInt.isEmpty()) {
            int[] t = pqInt.poll();
            for(int i : t) System.out.print(i + ",");
            System.out.print(",,");
        }


//        Queue<Employee> pqEmployee = new PriorityQueue<>(Comparator.comparing(Employee::getName)); // Name ASC
//        Queue<Employee> pqEmployee = new PriorityQueue<>
//                (Comparator.comparing(Employee::getName, Comparator.reverseOrder())); // Name DESC
        Queue<Employee> pqEmployee = new PriorityQueue<>(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getAge, Comparator.reverseOrder())); // Name ASC Age DESC

        Comparator<Employee> sortByNameDESC = Comparator.comparing(Employee::getName, Comparator.reverseOrder());
        pqEmployee.add(new Employee("Alice", 40));
        pqEmployee.add(new Employee("Bob", 50));
        pqEmployee.add(new Employee("Bob", 30));
        System.out.println();
        while(!pqEmployee.isEmpty()) {
            Employee e = pqEmployee.poll();
            System.out.print(e + " ");
        }
        System.out.println("\n-------------------------------------------------------------------------");

    }
}

class Employee{

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
