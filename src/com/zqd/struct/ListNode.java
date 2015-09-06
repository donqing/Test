package com.zqd.struct;

import javax.xml.bind.ValidationEvent;

public class ListNode {
	
	private int val;
	
	private ListNode next;
	
	public ListNode(){
		
	}
	
	public ListNode(int val){
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return  this.val+"" ;
	}
	
	
}
