package com.xue.study.LinkedList;
public class LeetCode237 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	 public ListNode removeElements(ListNode head, int val) {
		 /*
		 while(head != null && head.val == val) {
			ListNode delNode = head;
			head = head.next;
			delNode.next = null;
		}
		if (head == null) {
			return null;
		} 
		ListNode prev = head;
		while (prev.next != null) {
			if (prev.next.val == val) {
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			} else {
				prev = prev.next;
			}
		}
	    return head;
	  */
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.val == val) {
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			} else {
				prev = prev.next;
			}
		}
	    return dummyHead.next;
	 }
	 public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		ListNode test = new ListNode(arr); 
		System.out.println("input : " + test);
		ListNode ret = (new LeetCode237()).removeElements(test, 5);
		System.out.println("output : " + ret);
	}
}
