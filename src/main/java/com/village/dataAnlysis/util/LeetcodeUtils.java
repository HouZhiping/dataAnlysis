package com.village.dataAnlysis.util;

import java.util.*;

public class LeetcodeUtils {




    /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
*/
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        int[] nums1 = {0, 1};

        for(int len = nums.length,i=0;i<len;i++){
            int num = nums[i];
            Integer index = map.get(num);
            if(index != null){
                nums1[0] = index;
                nums1[1] = i;
                break;
            }else{
                Integer anoNum = target - num;
                map.put(anoNum,i);
            }

        }

        return nums1;

    }


    /*

    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807*/
      public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);


        ListNode listNode = addTwoNumbers(listNode1,listNode2);
        while (listNode != null){

            System.out.println(listNode.val);

            listNode =listNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode(0);
        ListNode curNode = newNode;
        //是否
        boolean hasCarryBit = false;
        while(l1 !=null || l2 != null ){
            int val1 = 0;
            int val2 = 0;
            if(l1 !=null){
                val1 = l1.val;
            }
            if(l2 !=null){
                val2 = l2.val;
            }

            int sum = val1 + val2;
            if(hasCarryBit){
                sum += 1;
            }

            if(sum > 9){
                sum = sum -10;
                hasCarryBit = true;
            }else{
                hasCarryBit = false;
            }

            l1 = l1.next;
            l2 = l2.next;

            curNode.val =sum;
            if(l1 == null && l2 == null){
                continue;
            }
            ListNode anoList = new ListNode(0);
            curNode.next =anoList;
            curNode =anoList;

        }
        return newNode;

    }








}
