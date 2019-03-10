package leetcode.UseString;
/*
557. Reverse Words in a String III
Easy

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

 */
public class reverseString3 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        for(int j = 0; j < c.length; j++){
            if(c[j] == ' '){
                reverse(c, i, j-1);
                i = j+1;
            }
        }
        reverse(c, i, c.length-1);
        return new String(c);  //char[] to string
    }

    private void reverse(char[] c, int i, int j) {
        char temp;  //这种写法，比把生成temp写到循环里要快很多。
        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++; j--;
        }
    }

}

