package com.zqd;


public class Demo   {
	public static  void main(String[] args)  {
		String a = "1110";
		String b = "11";
		System.out.println(addBinary(a, b));
	}
	public static String addBinary(String s1, String s2){
		 int i = s1.length() - 1, j = s2.length() - 1, c = 0;
		    String s = "";

		    while (i >= 0 || j >= 0 || c == 1) {
		        int a = (i < 0) ? 0 : s1.charAt(i--) - '0';
		        int b = (j < 0) ? 0 : s2.charAt(j--) - '0';

		        s = (char)('0' + a ^ b ^ c) + s;
		        c = (a + b + c) >> 1;
		    }

		    return s;
	}
	}

	












