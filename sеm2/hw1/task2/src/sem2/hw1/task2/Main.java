package sem2.hw1.task2;

public class Main {
    public static void main(String[] args) {

        List myList = new List();

        for (int i = 0; i < 10; i++)
            myList.add(i);

        myList.showList();

        for (int i = 19; i >= 10; i--)
            myList.add(i);

        myList.showList();

        myList.remove(0);
        myList.remove(13);

        for (int i = 1; i < 12; i++)
            myList.remove(i);

        myList.showList();

        myList.remove(12);
        for (int i = 14; i < 20; i++)
            myList.remove(i);
        myList.showList();

        if (myList.isEmpty())
            System.out.println("It works");
        else
            System.out.println("It doesn't work");

    }
}
