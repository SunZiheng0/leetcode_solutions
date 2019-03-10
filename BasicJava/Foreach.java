package leetcode.BasicJava;
import java.util.*;

public class Foreach {
    private void test1(){
        int[] a = {5, 4, 3, 2, 1};
        //foreach 能否改变 a 中的值;
        for(int num : a){
            num = 0;
        }
        for(int num : a)
            System.out.println(num);
    }
    //测试结果： 不能

    private void test(){
        String[] a = {"1", "2", "3"};
        setZore(a[0]);
        System.out.println(a[0]);
    }
    private void setZore(String s){
        s = "0";
    }
    //测试结果：string int 都是传值，不传引用

    public static void main(String[] args){
        Foreach t = new Foreach();
        t.test();
    }
}
