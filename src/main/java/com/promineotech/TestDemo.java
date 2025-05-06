package com.promineotech;

import java.util.Random;





public class TestDemo 
{	
	
	// Add Two Numbers
			public int addPositive (int a, int b)
			{
				if ( a > 0 && b > 0 )
					{	return ( a + b );	}
				else 
					{	throw new IllegalArgumentException("Both Parameters must be positive!");	}
			}
		
			public int randomNumberSquared()
			{
				int square = (getRandomInt())^2;
				return square;
			}
		
			public int getRandomInt() 
			{
				Random random = new Random();
				
				return random.nextInt(10) + 1;
			}
			


	
	// Compare Two Words
			public Boolean correctWord(String word1, String word2) 
			{
				if ( word1 != null && word2 != null ) 
					{	if ( word1 == word2 )
							{	return true;	} 
						else 
							{ return false;	}
					}
				else  {	throw new IllegalArgumentException("Words can not be NULL.");	}
			}

			


			
}  // END CLASS
