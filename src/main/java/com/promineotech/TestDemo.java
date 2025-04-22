package com.promineotech;

public class TestDemo 
{	
	
	// 
	public int addPositive (int a, int b)
	{
		if ( a > 0 && b > 0 )
			{	return ( a + b );	}
		else 
			{	throw new IllegalArgumentException("Both Parameters must be positive!");	}
	}


	
	
	
}  // END CLASS
