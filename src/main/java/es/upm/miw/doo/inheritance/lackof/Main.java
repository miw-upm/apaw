package es.upm.miw.doo.inheritance.lackof;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        operations.add(new Addition(3, 4));

        System.out.println("Total1:" + operations.total());

        operations.add(new Subtraction(1, 1));
        operations.add(new Addition(3, 5));
        operations.add(new Subtraction(4, 1));
        operations.add(new Addition(3, 6));
        operations.add(new Subtraction(3, 2));

        System.out.println("Total2:" + operations.total());
    }

}
