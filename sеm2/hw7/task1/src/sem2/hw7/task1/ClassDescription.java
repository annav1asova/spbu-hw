package sem2.hw7.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/** Class that prints full description of class */
public class ClassDescription {
    
    /**
     * method that prints description of class
     *
     * @param clazz class that will be printed
     */
    public void print(Class clazz) {
        System.out.println(clazz.getPackage() + ";\n");
        printClassOrInterface(clazz, "");
    }

    /**
     * method that prints class or interface
     *
     * @param clazz object type of class that will be printed
     * @param tabs before any words this string will be printed
     */
    private void printClassOrInterface(Class clazz, String tabs) {
        if (clazz.isInterface()) {
            printInterface(clazz, tabs);
        } else {
            printClass(clazz, tabs);
        }
    }

    /**
     * method that prints class
     *
     * @param clazz class that will be printed
     * @param tabs before any words this string will be printed
     */
    private void printClass(Class clazz, String tabs) {
        printAnnotations(clazz.getAnnotations(), tabs);
        System.out.print(tabs);
        printModifiers(clazz.getModifiers());
        System.out.print("class " + clazz.getSimpleName());
        if (clazz.getSuperclass() != Object.class && clazz.getSuperclass() != null)
            System.out.print(" extends " + clazz.getSuperclass().getSimpleName());
        Class[] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.print(i == 0 ? " implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");
        printFields(clazz, tabs + '\t');
        printMethods(clazz, tabs + '\t');
        printConstructors(clazz, tabs + '\t');
        printInnerClasses(clazz, tabs + '\t');
        System.out.print(tabs + "}\n");
    }

    /**
     * method that prints interface
     *
     * @param clazz interface that will be printed
     * @param tabs before any words this string will be printed
     */
    private void printInterface(Class clazz, String tabs) {
        printAnnotations(clazz.getDeclaredAnnotations(), tabs);
        System.out.print(tabs);
        printModifiers(clazz.getModifiers());
        System.out.print(clazz.getSimpleName());

        Class[] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.print(i == 0 ? " extends " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");
        printMethods(clazz, tabs + '\t');
        printInnerClasses(clazz, tabs + '\t');
        System.out.print(tabs + "}\n");
    }

    /**
     * method that prints all fields of class
     *
     * @param clazz its fields will be printed
     * @param tabs before any words this string will be printed
     */
    private void printFields(Class clazz, String tabs) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!unnecessaryField(field)) {
                printAnnotations(field.getDeclaredAnnotations(), tabs);
                System.out.print(tabs);
                printModifiers(field.getModifiers());
                System.out.println(getType(field.getType()) + ' ' + field.getName() + ';');
            }
        }
    }

    /**
     * method that checks whether the field name looks like "this$" + some Number
     *
     * @param field
     * @return true in case the field name looks like "this$" + some Number, false otherwise
     */
    private boolean unnecessaryField(Field field) {
        boolean parsable;
        try {
            Integer.parseInt(field.getName().replace("this$", ""));
            parsable = true;
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

    /**
     * method that prints all class's methods
     *
     * @param clazz its methods will be printed
     * @param tabs before any words this string will be printed
     */
    private void printMethods(Class clazz, String tabs) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println();
            printAnnotations(method.getDeclaredAnnotations(), tabs);
            System.out.print(tabs);
            printModifiers(method.getModifiers());
            System.out.print(getType(method.getReturnType()) + " " + method.getName() + "(");
            System.out.print(getParameters(method.getParameterTypes()));
            System.out.print(")");
            printExceptions(method.getExceptionTypes());
            System.out.println(" { }");
        }
    }

    /**
     * method that prints all class's constructors
     *
     * @param clazz its constructors will be printed
     * @param tabs before any words this string will be printed
     */
    private void printConstructors(Class clazz, String tabs) {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.println();
            printAnnotations(constructor.getDeclaredAnnotations(), tabs);
            System.out.print(tabs);
            printModifiers(constructor.getModifiers());
            System.out.print(clazz.getSimpleName() + "(");
            System.out.print(getParameters(constructor.getParameterTypes()));
            System.out.print(")");
            printExceptions(constructor.getExceptionTypes());
            System.out.println(" { }");
        }
    }

    /**
     * method that prints exceptions of method or constructor
     *
     * @param exceptionTypes array of exceprions
     */
    private void printExceptions(Class<?>[] exceptionTypes) {
        if (exceptionTypes.length == 0) {
            return;
        }
        for (int i = 0; i < exceptionTypes.length; i++) {
            String name = exceptionTypes[i].getSimpleName();
            System.out.print(i == 0 ? " throws " + name : ", " + name);
        }
    }

    /**
     * method that prints inner classes
     *
     * @param clazz its inner classes will be printed
     * @param tabs before any words this string will be printed
     */
    private void printInnerClasses(Class clazz, String tabs) {
        Class[] innerClasses = clazz.getDeclaredClasses();
        for (Class innerClass : innerClasses) {
            System.out.println();
            printClassOrInterface(innerClass, tabs);
        }
    }

    /**
     * method that prints all modifiers, in case if it is modifiers of interface, it removes modifier 'abstract'
     *
     * @param mod
     */
    private static void printModifiers(int mod) {
        String modsToString = Modifier.toString(mod);
        if (modsToString.contains("interface"))
            modsToString = modsToString.replace("abstract ", "");
        System.out.print(modsToString.length() != 0 ? modsToString + ' ' : "");
    }

    /**
     * method that gets type of class
     *
     * @param clazz
     * @return string (something like 'int[][]' or double)
     */
    private String getType(Class clazz) {
        String type = clazz.isArray() ? getType(clazz.getComponentType()) : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }

    /**
     * method that gets string out of array with parameters
     *
     * @param params array that consists of parameters
     * @return string (something like 'int param0, String[] param1'
     */
    private String getParameters(Class[] params) {
        String p = "";
        for (int i = 0; i < params.length; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }

    /**
     * method that prints annotation
     *
     * @param annotations array that consists of annotations
     * @param tabs before any words this string will be printed
     */
    private void printAnnotations(Annotation[] annotations, String tabs) {
        if (annotations.length == 0) {
            return;
        }
        for (Annotation annotation : annotations) {
            System.out.print(tabs + "@" + annotation.annotationType().getSimpleName() + " ");
            System.out.println();
        }
    }
}


