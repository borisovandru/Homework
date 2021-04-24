

public class Person  {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] arguments) {
        Person person = new Person();
        person.setName("Vanya");
        person.setName("Max");
        extracted(person);
    }

    private static void extracted(Person person) {
        int i = 5;
        setPersonName();
        System.out.println(person.getName() + " " + i);
        int I=5;
        setPersonName();
        System.out.println(person.getName() + " " + I);
    }

    private static void setPersonName() {

    }
}

