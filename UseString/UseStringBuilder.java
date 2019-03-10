package leetcode.UseString;

public class UseStringBuilder {
    private void useStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        System.out.println(sb.length());
        sb.charAt(sb.length()-1);
    }
    public static void main(String[] args){
        UseStringBuilder t = new UseStringBuilder();
        t.useStringBuilder();
    }
}
