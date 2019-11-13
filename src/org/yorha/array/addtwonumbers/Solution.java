package org.yorha.array.addtwonumbers;

class Solution {

	ListNode findFinal(ListNode listNode) {
		ListNode p = listNode;
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int val = l1.val + l2.val;
		int temp = val / 10;
		ListNode head = new ListNode(val%10);
		l1=l1.next;
		l2=l2.next;
		while (l1 != null && l2 != null) {
			val = l1.val + l2.val + temp;
			temp = val / 10;
			findFinal(head).next = new ListNode(val%10);
			l1=l1.next;
			l2=l2.next;
		}
		while (l1 != null) {
			val = l1.val + temp;
			temp = val / 10;
			findFinal(head).next = new ListNode(val%10);
			l1=l1.next;
		}
		while (l2 != null) {
			val = l2.val + temp;
			temp = val / 10;
			findFinal(head).next = new ListNode(val%10);
			l2=l2.next;
		}
		if(temp != 0){
			findFinal(head).next = new ListNode(temp);
		}
		return head;
	}

}