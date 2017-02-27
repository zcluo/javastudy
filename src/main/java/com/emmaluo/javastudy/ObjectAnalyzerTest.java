package com.emmaluo.javastudy;

import java.util.ArrayList;

/**
 * Created by zcluo on 2017/2/27.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args)
    {
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for(int i = 1; i <= 5; i++){
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
