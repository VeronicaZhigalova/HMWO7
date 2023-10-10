public class Person {


    private String name;
    private String lastName;
    private int age;


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Wrong age");
        }
    }


    public Person() {
    }


    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    public String getInfo() {
        return name + " " + lastName + " " + age;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person("Laura", "Miller", 25);
        Person person2 = new Person("Jay", " Kim", 33);


        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());
    }
}
