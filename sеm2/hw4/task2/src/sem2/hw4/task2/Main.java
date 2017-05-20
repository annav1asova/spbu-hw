package sem2.hw4.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! You have to choose hash function. Enter '1' for HashH37, '2' - for LY hash");
        int hashFunction = sc.nextInt();
        HashTable<String> hash = null;
        switch(hashFunction) {
            case 1:
                hash = new HashTable<>(new HashFunction1());
            case 2:
                hash = new HashTable<>(new HashFunction2());
        }

        boolean process = true;
        while (process)
        {
            String command = "";
            System.out.println("Enter the command: ");
            command = sc.next();

            switch(command)
            {
                case "exit":
                {
                    process = false;
                    break;
                }
                case "add":
                {
                    System.out.print("Enter element to add: ");
                    hash.addToHash(sc.next());
                    System.out.println("Element added");
                    break;
                }
                case "remove":
                {
                    System.out.print("Enter element to remove: ");
                    hash.removeFromHash(sc.next());
                    System.out.println("Element added");
                    break;
                }
                case "find":
                {
                    System.out.print("Enter element to find: ");
                    int quantity = hash.count(sc.next());
                    System.out.println("The quantity of this element in hash table is " + quantity);
                    break;
                }
                case "statistics":
                {
                    hash.getStatistics();
                    break;
                }
                default:
                {
                    System.out.println("unknown command");
                }
            }
        }
    }
}
