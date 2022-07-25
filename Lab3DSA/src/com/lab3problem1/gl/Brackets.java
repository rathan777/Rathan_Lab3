package com.lab3problem1.gl;

import java.util.Stack;

public class Brackets {
	static boolean checkingBracketsBalanced( String expression)
	{
		Stack<Character> Stack = new Stack<Character>();
		for( int i=0;i<expression.length(); i++)
		{
			char character = expression.charAt(i);
			if(character=='(' || character == '{' || character == '[') {
				Stack.push(character);
				continue;
				
			}
			if(Stack.isEmpty())
				return false;
			char c;
			switch (character){
			
			case '}':
				c= Stack.pop();
				if(c=='(' || c=='[')
					return false;
				break;
				
			case ')':
				c= Stack.pop();
				if(c=='{' ||c=='[')
					return false;
				break;
				
			case ']':
				c= Stack.pop();
				if(c=='(' || c== '{')
					return false;
				break;
			
			}}
		return (Stack.isEmpty());
		
			}
          public static void main(String args[]) {
        	  String expression = "([[{}]])";
        	  Boolean result;
        	  
        	  result= checkingBracketsBalanced(expression);
        	  
        		if(result)
        			System.out.println("The entered string has Balanced Brackets");
        		else
        			System.out.println("The entered string do not have Balanced Brackets");
}
	}


