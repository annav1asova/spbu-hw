package sem2.hw1.task1;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<Integer>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }

        boolean isCorrect = true;
        for (int i = 9; i >= 0; i--) {
            if (i != myStack.pop())
                isCorrect = false;
        }
        if (!myStack.isEmpty()) {
            isCorrect = false;
        }

        if (isCorrect)
            System.out.println("It works");
        else
            System.out.println("It doesn't work");

    }
}
