package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class T0021FundamentalLambdaAndAnonymousClasses {

    @Test
    void anonymousClass() {
        Anonymous anonymous1 = new Anonymous() {
            @Override
            public String tellme() {
                return "hi";
            }
        };

        Anonymous anonymous2 = () -> "hello";

        NotAnonymous notAnonymous = new NotAnonymous();

        assertEquals("hi", anonymous1.tellme());
        assertEquals("hello", anonymous2.tellme());
        assertEquals("not anonymous", notAnonymous.tellme());
    }

    private interface Anonymous {
        String tellme();
    }

    private class NotAnonymous implements Anonymous {
        @Override
        public String tellme() {
            return "not anonymous";
        }
    }

    @Test
    void callALambda() {
        LambdaExample classExample = new LambdaDefault();
        LambdaExample lambdaExample = (text) -> text;
        LambdaContainer lambdaContainer = new LambdaContainer();

        assertEquals("Hello from LambdaDefault", classExample.tellme(null));
        assertEquals("booo", lambdaExample.tellme("booo"));
        assertEquals("hello", lambdaContainer.printme(lambdaExample, "hello"));
        assertEquals("something else", lambdaContainer.printme((text) -> text, "something else"));
    }

    // Classes and interfaces can be created inside other classes
    // This helps when you want to break down your functionality and your classes and so closely related
    // that you believe that having them in the same file is better for understanding

    public interface LambdaExample {
        String tellme(String text);
    }

    public class LambdaDefault implements LambdaExample {
        @Override
        public String tellme(String text) {
            return "Hello from LambdaDefault";
        }
    }

    public class LambdaContainer {
        public String printme(LambdaExample lambdaExample, String text) {
            return lambdaExample.tellme(text);
        }
    }

    @Test
    void something() {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");

        stringList.forEach((name) -> System.out.println("Printing " + name));

        ListPrintDefault listPrintDefault = new ListPrintDefault(stringList);

        listPrintDefault.print((each) -> "The value is: " + each);
    }

    private interface ListPrint {
        String print(String value);
    }

    private class ListPrintDefault {
        private List<String> stringList;

        public ListPrintDefault(List<String> stringList) {
            this.stringList = stringList;
        }

        public void print(ListPrint listPrint) {
            stringList.forEach((string) -> System.out.println(listPrint.print(string)));
        }
    }

}
