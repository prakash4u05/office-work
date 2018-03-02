package com.threadtest;

import java.util.function.Function;
import java.util.function.Supplier;

//@FunctionalInterface
public interface AnotherInterface {
	
	
	
	default void optionalcheck()
	{
		System.out.println("Another check");
	}

}
