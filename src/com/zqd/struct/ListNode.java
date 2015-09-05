package com.zqd.struct;

public class ListNode {
	private  int val;
    private  ListNode next;
    
    public ListNode(int x) {
    	val = x; 
    	}
	public void setVal(int val){
	this.val = val;	
	}
	public int getVal(){
		return this.val;
	}
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext(){
		return this.next;
	}
	public String toString(){
		return this.val+" ";
	}
}
