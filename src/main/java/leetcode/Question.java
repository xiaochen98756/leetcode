package leetcode;

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

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] a=new int[2];
        for (int i = 0; i < nums.length; i++) {
            int res=target-nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j]==res){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return a;
    }

    /**
     * 28. 找出字符串中第一个匹配项的下标
     * haystack = "sadbutsad", needle = "sad" 0
     * haystack = "leetcode", needle = "leeto" -1
     *  // System.out.println(strStr("leetcode","leeto"));
     *  // System.out.println(strStr("badmodebad","mode"));
     *  //System.out.println(strStr("mississippi","issipi"));
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
      if (needle.length()>haystack.length()){
          return -1;
      }
      else if (needle.length()==haystack.length()){
          if (haystack.equals(needle)){
              return 0;
          }else {
              return -1;
          }
      }
      else {
          for (int i = 0; i < haystack.length(); i++) {
              String a=haystack.substring(i,i+1);
              String b=needle.substring(0,1);
              if (a.equals(b) && i+needle.length()<=haystack.length()){
                  String c=haystack.substring(i,i+needle.length());
                  if (c.equals(needle)){
                      return i;
                  }
              }
          }
      }
      return -1;
    }

    /**
     * 151. 反转字符串中的单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder builder=new StringBuilder();
        String[] lists=s.trim().split("\\s+");
        for (int i = lists.length - 1; i >= 0; i--) {
            builder.append(lists[i]).append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
       return builder.toString();
    }

    /**
     * 100. 相同的树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p==null && q==null){
          return true;
      }else if (p!=null && q!=null){
          if (p.val==q.val){
              return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
          }else {
              return false;
          }
      }else {
          return false;
      }
    }

    /**
     * 226. 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=right;
        root.right=left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 101. 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        if (isSameTree(invertTree(root.left),root.right)){
            return true;
        }
        return false;
    }

    /**
     * 104. 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
       return calDepth(root,0);
    }

    private int calDepth(TreeNode root, int count) {
        if (root==null){
            return count;
        }else {
            if (root.left!=null ||root.right!=null){
                count++;
                int countleft=calDepth(root.left,0);
                int countrigtht=calDepth(root.right,0);
                count=Math.max(countleft,countrigtht);
            }
        }
        return count;
    }

    public static void main(String[] args) {


    }
}
