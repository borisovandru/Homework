package ru.geekbrains.javacore.lesson14.hw;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;


public class MethodOneTest {
    public static Collection<Object[]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 5, 4, 6}, {6}},
                {{4, 2, 3, 5}, {2, 3, 5}},
                {{4, 4, 0, 1}, {0, 1}},
                {{5, 5, 5, 4}, {}},
                {{4, 7, 5, 4}, {}},
                {{5, 5, 4, 5,}, {5} },
        });
    }

    private final int[] x;

    private final int[] result;

    public MethodOneTest(int[] x, int[] result) {
        this.x = x;
        this.result = result;
    }

    private static Method method;
    
    public void init() {
        System.out.println("init Method");
        method = new Method();
    }

    @Test
    public void massTestAdd() {
        Assert.assertEquals(result, method.myMethodOne(x));
    }

}
