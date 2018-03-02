package com.threadtest;

@FunctionalInterface
public interface DefaultInterface {
	
	public void check();
	
	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
	
	default void optionalcheck()
	{
		System.out.println("Optional check");
	}

}
