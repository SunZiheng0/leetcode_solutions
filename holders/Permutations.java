package leetcode.holders;
/*
46. Permutations
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 */
import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> newL = new ArrayList<Integer>();
        newL.add(nums[0]);
        result.add(newL);
        //result.add(new ArrayList<Integer>(nums[0]));
        //这是很典型的错误，想创造一个只有单个元素的列表时，不能  new ArrayList<Integer>(nums[0]),
        // 这个赋值是默认长度。要创造后再add

        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> before = new ArrayList<>(result);  //List<List<Integer>>的处理
            System.out.println(before);
            result.clear();
            for(List<Integer> l : before){

                for(int j = 0; j <= i; j++){
                    newL = new ArrayList<Integer>(l);  //最后一位也能用index加进去
                    newL.add(j, nums[i]);              //不能直接把l引用放进去，因为后面处理l，会改变
                                                       //已经进去的l的值
                                                      // 只能把值取出来生成新的newL 去处理

                    result.add(newL);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        Permutations t = new Permutations();
        t.permute(new int[]{3,4,5,6});
    }
}
