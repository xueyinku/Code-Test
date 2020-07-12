package com.xue.study.LinkedList;



public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
	 
	 //���Ե�ʱ���ܴ�������listNode,������Ҫ�������췽����tostring����
	 public ListNode(int[] arr) {
		 if (arr.length == 0 || arr == null) {
			throw new IllegalArgumentException("arr can not be empty.");
		}
		 this.val = arr[0];
		 ListNode cur = this;
		 for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	 }
	 @Override
	 public String toString() {
		 StringBuilder ret = new StringBuilder();
		 ListNode head = this;
		 while (head != null) {
			ret.append(head.val + "->" );
			head = head.next;
		}
		 ret.append("null");
		 return ret.toString();
	 }
}