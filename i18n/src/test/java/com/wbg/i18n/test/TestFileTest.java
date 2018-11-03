package com.wbg.i18n.test;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class TestFileTest {
    TestFile testFile=new TestFile();
    @Test
    public void simpleFile() {

    }
    @Test
    public void simpleFiles() {

    }
    public static long abc(long x){
        if(x==1||x==2){
            return 1;
        }
        else
            return abc(x-1)+abc(x-2);
    }
}