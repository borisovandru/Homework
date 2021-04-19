package ru.geekbrains.lesson14.hw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class MethodOneTest {
    @Parameterized.Parameters
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


    @Before
    public void init() {
        System.out.println("init Method");
        method = new Method();
    }

    @Test
    public void massTestAdd() {
        Assert.assertArrayEquals(result, method.myMethodOne(x));
    }

}
