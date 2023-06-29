package section1;

public class Code1 {
    public static void main(String[] args) {
        Person1 first = new Person1();

        first.name = "John";
        first.number = "01024833120";

        System.out.println("Name: " + first.name + ", Numbaer: " + first.number);

        Person1 [] members = new Person1 [100];
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "David";
        members[1].number = "2873548327458";

        System.out.println("Name: " + members[1].name + ", Numbaer: " + members[1].number);
    }
}
