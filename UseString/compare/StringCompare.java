package leetcode.UseString.compare;

public class StringCompare {
    private void test(){
        String a = "a";
        String b = "b";
        String c = "a";                    //string用 compareTo， equals
                                           // 不是 ==,>,<
        System.out.println(a.equals(c));
        //lexicographical order 小的为-1
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));

        System.out.println(a.compareTo(c));
    }
    public static void main(String[] args){
        StringCompare t = new StringCompare();
        t.test();
    }
}
