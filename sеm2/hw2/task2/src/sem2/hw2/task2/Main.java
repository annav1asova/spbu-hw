package sem2.hw2.task2;

public class Main {
    public static void main(String[] args) {
        testMyList(new SingleLinkedList());
        testMyList(new DoubleLinkedList());
    }

    public static void testMyList(List testList) {
        for (int i = 0; i < 10; i++)
            testList.add(i);
        for (int i = 20; i >= 15; i--)
            testList.add(i);

        for (int i = 14; i >= 10; i--)
            testList.add(i);
        testList.showList();

        for (int i = 0; i < 10; i++)
            testList.remove(i);
        testList.showList();

        testList.remove(17);
        testList.remove(20);
        testList.remove(21);
        testList.showList();

        for (int i = 10; i <= 19; i++)
            testList.remove(i);

        if (testList.isEmpty())
            System.out.println("It works");
        else
            System.out.println("It doesn't work");
    }
}
