package sem2.hw7.task1;

public class TestClass {
    int array[][];
    String[] someString;

    public TestClass() { }

    static interface TestInterface {

        public int TestFunction(int time, int speed);
    }

    class AnotherClass extends TestClass implements TestInterface {

        @Deprecated
        public int TestFunction(int time, int speed) {
            return time * speed;
        }

        AnotherClass(int someParameter) {
            //...
        }
    }

}
