package leetcode;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public class Question {
    public static int[] plusOne(int[] digits) {
        StringBuilder builder=new StringBuilder();
        for (int digit : digits) {
            builder.append(digit);
        }
        long res=Long.parseLong(builder.toString());
        res=res+1;
        String ret= String.valueOf(res);

        int[] intArray = new int[ret.length()];
        for (int i = 0; i < ret.length(); i++) {
            intArray[i] = Integer.parseInt(String.valueOf(ret.charAt(i)));
        }
         return intArray;
    }

    /**
     * 136. 只出现一次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
         int res=0;
         Map<Integer,Boolean> map=new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)){
                res+=num;
                map.put(num,true);
            }else {
                res=res-num;
                map.remove(num);
            }
        }
        return res;
    }

    /**
     * 287. 寻找重复数
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>1){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**TODO 重新做
     * 55. 跳跃游戏 [2,3,1,1,4]
     * [3,2,1,0,4]
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        return false;
    }
    public static void main(String[] args) {

    }
}
