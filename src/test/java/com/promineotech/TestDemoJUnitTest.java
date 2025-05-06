package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest 
{
	private TestDemo testDemo;
	
//  Before Each
		@BeforeEach
			void setUp() throws Exception 
		{	
			testDemo = new TestDemo();
		}
	

		
// JUnit Tests:  Parameterized && Test  ( The method must have package visibility (not public!) or JUnit won't find it!! )
		
		//  Add Two Numbers
					// Para Test
				@ParameterizedTest	
				@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
					void addTwoNumbersParaTest(int a, int b, int expected, boolean expectException ) 
					{
						if ( !expectException )
							{	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);	}
						else	
							{	assertThatThrownBy(()-> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);	}
					}
			
					// @Test
				@Test
					void addTwoNumbersTest() 
					{
						assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
						assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
					}
				
		
		// Compare Two Words  
				//Para Test
				@ParameterizedTest	
				@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForCompareWords")
					void compareTwoWordsParaTest(String word1, String word2, boolean expected, boolean expectException ) 
					{
						if ( !expectException )
							{	assertThat(testDemo.correctWord(word1,word2)).isEqualTo(expected);	}
						else	
							{	assertThatThrownBy(()-> testDemo.correctWord(word1,word2)).isInstanceOf(IllegalArgumentException.class);	
							
						}
					}
	
				// @test
				@Test
					void compareTwoWordsTest() 
				{
					assertThat(testDemo.correctWord("Daniel", "Daniel")).isEqualTo(true);
					assertThat(testDemo.correctWord("Daniel", "Jeffrey")).isEqualTo( false);
					assertThat(testDemo.correctWord("Daniel", "daniel")).isEqualTo(false);
					assertThrows( IllegalArgumentException.class, () -> { testDemo.correctWord("Daniel", null); });
				}
		
		
//  JUnit Parameterized Testing Arguments		
		
		//  Add Two Numbers Arguments
				static Stream<Arguments> argumentsForAddPositive()
			{	return Stream.of( arguments(2,4, 6, false),
					              arguments(3,7, 10, false),
					              arguments(-3,7,8, true),
					              arguments(1,-7,8, true),
					              arguments(0,2,2,true),
					              arguments(2,0,2, true)
					);
			}
			
		//  Compare Two Words Arguments
				static Stream<Arguments> argumentsForCompareWords()
			{	return Stream.of( arguments("Daniel", "Daniel", true, false),
					              arguments("Daniel", "Jeffrey", false, false),
					              arguments("One", "one", false, false),
					              arguments("Daniel", null, false, true)
	
					            );
			}   
			


	// Random Number Squared
		@Test
			private void assertThatNumberSquaredIsCorrect()
		{
			TestDemo mockDemo = spy(testDemo);
			doReturn(5).when(mockDemo).getRandomInt();
			int fiveSquared = mockDemo.randomNumberSquared();
			assertThat(fiveSquared).isEqualTo(25);
			
		}

}  // END CLASS
