package com.test;

public final class Test1 {
	public static void main(String[] args) {
		System.out.println(new Test1().test());
	}
	
	int test() {
		int s = 1;
		String a = new String();
		@SuppressWarnings("unused")
		Integer c = Integer.parseInt(a);
		//Integer.valueOf(i);
		try {
			System.out.println(s);
			return s;
		} finally {
			++s;
			System.out.println(s);
		}
	}
}
