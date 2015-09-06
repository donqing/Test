package com.zqd.leedcode;

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = {1,3,3,4,7,10};
		int[] nums2 = {2,4,5};
		int num[]=merge(nums1, nums1.length, nums2, nums2.length);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}  
	
	}
	/**
	 * 合并两个已排序序列
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
    public static int[]  merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m+n];
        int current1 = 0;
        int current2 = 0;
        int current = 0;
        while (current1<m && current2 < n) {
    			if (nums1[current1] < nums2[current2]) {
    				num[current] = nums1[current1];
    				current++;
    				current1++;
    			}
    			else {
    				num[current] = nums2[current2];
					current++;
					current2++;
				}
    		}
 
	  if (current2==n) {
		for (int i = current1; i < nums1.length; i++) {
			num[current]=nums1[i];
			current++;
		}
	}
	  else if (current1==m) {
		for (int i = current2; i < nums2.length; i++) {
			num[current] = nums2[i];
			current1++;
		}
	}
	  return num;
    }
}
