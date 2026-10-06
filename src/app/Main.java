package app;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        Class<?> utilsClass = Class.forName("app.ArrayUtils");
        Object utils = utilsClass
                .getDeclaredConstructor()
                .newInstance();
        Method[] methods = utilsClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo info =
                        method.getAnnotation(MethodInfo.class);
                Author author =
                        method.getAnnotation(Author.class);

                System.out.println("Method name: " + info.name());
                System.out.println("Method type: " + info.type());
                System.out.println("Description: " + info.description());

                if (author != null) {
                    System.out.println(
                            "Author: " + author.authorName()
                    );
                }

                method.invoke(utils, "Hello Reflection!");
                System.out.println("----------------------");
            }
        }
    }
}