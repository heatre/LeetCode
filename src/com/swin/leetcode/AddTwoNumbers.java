package com.swin.leetcode;

/**
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author Swin
 * 
 */



public class AddTwoNumbers
{
	public class ListNode//内部类，定义链表数据结构
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
		}

	}
	public ListNode addTwoNumbers(ListNode l1,ListNode l2)
	{
		if(null == l1 || null == l2)
			return null;
		ListNode node = new ListNode(0);
		ListNode headNode = node;
		int sum =0;
		int carry = 0;
		int tmp = 0;
		while(l1 != null || l2 != null || carry != 0)//关键点，两个链表内元素个数可能不同。

		{
			tmp = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0)+carry;
			sum = tmp%10;
			carry = tmp/10;
			node.next = new ListNode(sum);
			node = node.next;
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return headNode.next;
	}

	public static void main(String[] args)
	{
		AddTwoNumbers adn = new AddTwoNumbers();
		ListNode l1 = adn.new ListNode(0);
		ListNode l2 = adn.new ListNode(0);

		ListNode node = l1;
		for(int i =0;i<5;i++)
		{
			node.next = adn.new ListNode(i);
			node = node.next;
		}

		node = l2;
		for(int i =3;i>0;i--)
		{
			node.next = adn.new ListNode(i);
			node = node.next;
		}

		node = adn.addTwoNumbers(l1.next, l2.next);
		while(node!= null)
		{
			System.out.println(node.val);
			node = node.next;
		}
	}

}

