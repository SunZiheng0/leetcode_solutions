package leetcode.array;


// 二重循环变一重
//sum[i, j] = sum[0, j] - sum[0, i-1]
//只需循环一次 sum[0, i] 就可以了
//product[i, j] = product[0, j] / product[0, i -1]
//遇到0 ，就重新计算

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int negmax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                max = Math.max(max, 0);
                product = 1;
                negmax = 0;
            }else{
                product *= nums[i];
                if(product > 0){
                    max = Math.max(max, product);
                }else{
                    if(negmax == 0) {
                        max = Math.max(max, product);
                        negmax = product;
                    }
                    else{
                        int prod = product / negmax;
                        max = Math.max(prod, max);
                        if(product > negmax) negmax = product;
                    }

                }
            }
        }
        return max;
    }
}
