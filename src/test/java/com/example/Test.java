package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by byeon on 2017-03-30.
 */
public class Test {
    public static void main(String[] a){
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        List<String> cList = new ArrayList<>();

        aList.add("a");
        bList.add("b");
        cList = aList;
        System.out.println(aList.toString()); //a
        System.out.println(bList.toString()); //b
        System.out.println(cList.toString()); //a
        System.out.println("-----------------------------------------------------");
        cList = bList;
        System.out.println(aList.toString()); //a
        System.out.println(bList.toString()); //b
        System.out.println(cList.toString()); //b
        System.out.println("-----------------------------------------------------");
        cList.add("c");
        aList.add("d");
        System.out.println(aList.toString()); //a, d
        System.out.println(bList.toString()); //b, c
        System.out.println(cList.toString()); //b, c
        System.out.println("-----------------------------------------------------");
        aList.add("1");
        bList.add("2"); //b와 c는 같은 주소값을 가지고 있다.
        cList.add("3"); //b와 c는 같은 주소값을 가지고 있다.
        System.out.println(aList.toString()); //a, d
        System.out.println(bList.toString()); //b, c
        System.out.println(cList.toString()); //b, c
        System.out.println("-----------------------------------------------------");
        List<String> dList = new ArrayList<>(cList); //리스트 객체가 복사된걸 볼 수 있다. c, d는 다른 주소를 나타낸다.
        cList.add("A");
        dList.add("B");
        System.out.println(aList.toString()); //a, d
        System.out.println(bList.toString()); //b, c
        System.out.println(cList.toString()); //b, c
        System.out.println(dList.toString()); //b, c
        System.out.println("-----------------------------------------------------");
        List<String> eList = new ArrayList<>(aList.size()); //리스트 객체가 복사된걸 볼 수 있다. c, d는 다른 주소를 나타낸다.
        aList.add("C");
        eList.add("D");
        System.out.println(aList.toString()); //a, d
        System.out.println(bList.toString()); //b, c
        System.out.println(cList.toString()); //b, c
        System.out.println(dList.toString()); //b, c
        System.out.println(eList.toString()); //b, c
    }
}
