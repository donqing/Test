package com.zqd.leedcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	
	private int[] numbers = new int[]{1,2,2,3,4,5};
	
	private int n = numbers.length;
	
	private boolean[] visited = new boolean[n];
	//图的二维数组表示
	private int[][] graph = new int[n][n];
	//数字的组合
	private String combination="";
	
	public Set<String> getAllCombinations(){
		//构造图
		buildGraph();
		//用来存放所有组合
		Set<String> set = new HashSet<String>();
		//分别从不同结点出发深度遍历图
		for (int i = 0; i < n; i++) {
			this.depthFirstSearch(i,set);
		}
		return set;
	}
	
	private void buildGraph(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) {
					graph[i][j] = 0;
				}
				else
					graph[i][j] = 1;
			}
		}
		//确保在遍历时3与5是不可达的
		graph[3][5] = 0;
		graph[5][3] = 0;
	}
	//对图从结点start位置开始进行深度遍历
	private void depthFirstSearch(int start, Set<String> set){
		visited[start] = true;
		combination = combination + numbers[start];
		if (combination.length()==n) {
			//4不出现在第三个位置
			if (combination.indexOf("4")!=2) {
				set.add(combination);
			}
		}
			for (int i = 0; i < n; i++) {
				if (graph[start][i]==1 && visited[i]==false) {
					depthFirstSearch(i, set);
				}
			}
		combination = combination.substring(0, combination.length()-1);
		visited[start] = false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Set<String> set = solution.getAllCombinations();
		Iterator<String> it = set.iterator();
		int count = 0;
		while (it.hasNext()) {
			System.out.println(it.next());
			count++;
		}
		System.out.println(count);
	}
	
}
