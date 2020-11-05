package com.test.board.vo;

public class PageListVO {

	int a = 1;
	
	void print(int a) {
		this.a = a;
		System.out.println(this.a);
	}
	
	public static void main(String[] args) {
		PageListVO p = new PageListVO();
		p.print(3);
	}
}
