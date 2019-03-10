package leetcode.math;

public class base7 {
    public String convertToBase7(int num) {
        boolean negative = false;
        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if(num < 0){
            negative = true;
            num = -num;
        }

        while(num > 0){
            sb.append(num % 7);              //先出来的排后面，用reverse（）
            num /= 7;
        }
        String res = sb.reverse().toString();
        return negative ? '-' + res : res;
    }
}
