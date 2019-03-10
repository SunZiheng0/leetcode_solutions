package leetcode.UseString;

import test.Test;

import java.util.ArrayList;
import java.util.List;

public class BasicUsage {
    public void test(){
        String s = "abcd";
        s.length();
        String[] a = s.split("c");
        char[] b = s.toCharArray();

        //get the last can't arr[-1]
        String c = a[a.length-1];
        s.charAt(4);
        s.indexOf('a');
        s.indexOf("abc");
        s.compareTo("aaa");
        s.equals("abcd");

        //char[] to string
        char[] c1 = {'x', 'y', 'z'};
        String s1 = String.valueOf(c);

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        String s2 = sb.toString();
        sb.append(1);
        sb.append('a');
        sb.insert(0, 'a');
        Character.isDigit('a');
        Character.isLowerCase('a');
        Character.isUpperCase('A');
        Character.toLowerCase('a');
        Character.toUpperCase('a');

        Character.getNumericValue('1');

        Integer.parseInt("1234", 1,2,10);
        //String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
    }
    public static void main(String[] args){
        //Test t = new Test();

        System.out.println("\\/".length());
    }
}
