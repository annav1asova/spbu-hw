package sem2.hw1.task2;

public class Main {
    public static void main(String[] args) {

        List myList = new List();

        for (int i = 0; i < 10; i++)
            myList.add(i);

        for (int i = 19; i >= 10; i--)
            myList.add(i);

        for (int i = 0; i < 20; i++)
            myList.remove(i);

        if (myList.isEmpty())
            System.out.println("It works");
        else
            System.out.println("It doesn't work");

    }
}
