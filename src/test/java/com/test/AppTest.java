package com.test;

import static org.junit.Assert.assertTrue;

import com.test.pages.BaseTest;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
public static void main(String[] Args)  {
    TestUygulama tu=new TestUygulama();
    BaseTest bt=new BaseTest();
    bt.setUp();
    tu.openPage();
    try {
        bt.tearDown();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
