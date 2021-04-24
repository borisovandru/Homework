package ru.geekbrains.lesson14.hw;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodTwoTest {

    private static Method method;


    public void init() {
        System.out.println("init Method");
        method = new Method();
    }

    @Test
    public void test1() {
        Assert.assertTrue(method.myMethodTwo(new int[]{1, 5, 4, 6}));
    }

    @Test
    public void test2() {
        Assert.assertTrue(method.myMethodTwo(new int[]{4, 2, 3, 5}));
    }
    @Test
    public void test3() {
        Assert.assertTrue(method.myMethodTwo(new int[]{2, 2, 0, 1}));
    }

    @Test
    public void test4() {
        Assert.assertFalse(method.myMethodTwo(new int[]{5, 5, 5, 5}));
    }
    @Test
    public void test5() {
        Assert.assertFalse(method.myMethodTwo(new int[]{3, 8, 5, 9}));
    }

}
