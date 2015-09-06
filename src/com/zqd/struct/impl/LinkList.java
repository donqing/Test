package com.zqd.struct.impl;

import com.zqd.struct.ListNode;

public class LinkList {
	
	/**
	 * 链表头节点
	 */
	private ListNode head;
	
	public void setHead(ListNode head){
		this.head = head;
	}
	/**
	 * 获得头节点
	 * @return
	 */
	public ListNode getHead(){
		return this.head;
	}
	public String toString(){
		return head+" ";
	}
	
	public LinkList(){
		
	}
	public LinkList(ListNode node){
		head = node;
	}
	/**
	 * 添加节点
	 * @param node
	 */
	public void add(ListNode node){
		if (head == null) {
			head = node;
			return;
		}
		ListNode temp = head;
		while (temp.getNext()!=null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		
	}
	/**
	 * 删除某一个节点
	 * @param node
	 */
	public void delete(ListNode node){
		if (head == null) {
			return;
		}
		ListNode temp = head;
		if (temp == node) {
			if (temp.getNext()!=null) {
				head = temp.getNext();
			}else{
				head = null;
			}
			return;
		}
		while (temp.getNext()!=node) {
			temp = temp.getNext();
			if (temp.getNext()==null) {
				System.out.println("节点不存在");
				return ;
			}
		}
		temp.setNext(temp.getNext().getNext());
	}
	/**
	 * 删除重复节点,leetcode测试通过
	 */
	public void deleteDuplicate(){
		if (head == null) {
			return ;
		}
		ListNode temp = head;
		//前一个节点
		ListNode pre = null;
		while (temp!=null) {
			ListNode temp2 = temp.getNext();
			pre = temp;
			while (temp2!=null) {
				if (temp2.getVal()==temp.getVal()) {
					pre.setNext(temp2.getNext());
				}
				else {
					pre = pre.getNext();
				}
				temp2 = temp2.getNext();
			}
			temp = temp.getNext();
		}
	}
	/**
	 * 在单链表中找出倒数第n个元素
	 * @param n
	 * @return
	 */
	public ListNode findElemFromEnd(int n){
		ListNode node = head;
		if (head == null) {
			return null ;
		}
		if (n < 1 || n > this.size()) {
			return null;
		}
		for (int i = 0; i < this.size()-n; i++) {
			node = node.getNext();
		}
		return node;
	}
	//单链表中元素个数
	public int size(){
		int size=0;
		if (head==null) {
			size = 0;
		}
		ListNode temp = head;
		while (temp!=null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}
	/**
	 * 实现单链表的反转，返回一个新的单链表
	 */
	public LinkList reverseList(){
		LinkList list2 = new LinkList();
		if (this.getHead()==null) {
			return null;
		}
		ListNode temp = this.getHead();
		if (temp.getNext()==null) {
			return this;
		}
		ListNode newHead = head;
		ListNode pNode = head;
		//反转后指向下一节点的引用
		ListNode pre = null;
		while (pNode!=null) {
			ListNode pNext = pNode.getNext();
			if (pNext == null) 
				newHead = pNode;
			pNode.setNext(pre);
			pre = pNode;
			pNode = pNext;			
		}
		list2.setHead(newHead);
		return list2;
	}
	
	/**
	 * 递归从尾到头输出单链表
	 * @param head
	 */
	public void printListReversely(ListNode head){
		ListNode node = head;
		if (node != null) {
			printListReversely(node.getNext());
			System.out.print(node.getVal()+" ");
		}
	}
	/**
	 * 快速寻找单链表的中间节点*/
	public ListNode searchMid(ListNode head){
		ListNode p = head;
		ListNode q = head;
		while (p!=null&&p.getNext()!=null&&p.getNext().getNext()!=null) {
			p =p.getNext().getNext();
			q= q.getNext();
		}
		return q;
	}
	//在不知道头指针的情况下删除指定节点
	public boolean deleteNode(ListNode node){
		if(node == null||node.getNext()==null)
			return false;
		int temp = node.getVal();
		node.setVal(node.getNext().getVal());
		node.getNext().setVal(temp);
		node.setNext(node.getNext().getNext());
		return true;
	}
	//测试while循环
	public void testWhile(){
		ListNode temp1 = head;
		ListNode temp2 = head;
		while (temp1!=null) {
			System.out.print(temp1+" ");
			temp1 = temp1.getNext();
		}
		//此时temp1指向尾节点的下一个节点为空节点
		System.out.println(temp1);
		//如果当前结点的下一个节点为空，则不执行循环，当前结点
		//为尾节点时不执行循环
		while (temp2.getNext()!=null) {
			System.out.print(temp2+" ");
			temp2 = temp2.getNext();
		}
		//此时temp2指向尾节点
		System.out.println(temp2);
	}
	public void printList(){
		if (head == null) {
			return;
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getVal()+" ");
			temp = temp.getNext();
		}
		System.out.println("Numbers: "+ this.size());
	}
	
}
