package sem2.hw7.task1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Test class for ClassDescription */
public class ClassDescriptionTest {

    @Test
    public void test () {
        String expected = "package sem2.hw7.task1;\n" +
                "\n" +
                "public class TestClass {\n" +
                "\tint[][] array;\n" +
                "\tString[] someString;\n" +
                "\n" +
                "\tpublic TestClass() { }\n" +
                "\n" +
                "\tclass AnotherClass extends TestClass implements TestInterface {\n" +
                "\n" +
                "\t\t@Deprecated \n" +
                "\t\tpublic int TestFunction(int param0, int param1) { }\n" +
                "\n" +
                "\t\tAnotherClass(TestClass param0, int param1) { }\n" +
                "\t}\n" +
                "\n" +
                "\tstatic interface TestInterface {\n" +
                "\n" +
                "\t\tpublic abstract int TestFunction(int param0, int param1) { }\n" +
                "\t}\n" +
                "}\n";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream prev = System.out;
        System.setOut(printStream);

        ClassDescription classDescription = new ClassDescription();
        classDescription.print(TestClass.class);

        System.setOut(prev);
        printStream.close();

        classDescription.print(TestClass.class);
        String result = byteArrayOutputStream.toString();
        Assert.assertTrue(result.equals(expected));
    }
}