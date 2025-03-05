package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
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
	
		
	//  Parameterized Test
		@ParameterizedTest	
		@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
		void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException ) 
		{
			if ( !expectException )
				{	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);	}
			else	
				{	assertThatThrownBy(()-> testDemo.addPositive(a,b)).isInstanceOf(llegalArgumentException.class);	
				
			}
		}

		
	//  Add Positive Arguments
		static Stream<Arguments> argumentsForAddPositive()
		{	return Stream.of( arguments(2,4,6,false),
				              arguments(3,7,8, true),
				);
		}
}  // END CLASS
