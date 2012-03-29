package module;

import core.Module;
import core.MyMathUtilities;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Tim
 *
 */
public class Problem4 implements Module
{

	@Override
	public void run()
	{
		int answer = 0;
		//(-b +- sqrt(b^2 -4ac))/2a
		for(int i = 999; i > 99; i--)
		{
			for(int j = 999; j > 99; j--)
			{
				if(MyMathUtilities.isPalindrome(i*j))
				{
					//System.out.println("i = " + i + ", j = " +j);
					//System.out.println("Answer: " + i*j);
					if(i*j > answer)
						answer = i*j;
				}
			}
		}
		System.out.println("Answer: " + answer);
	}

	

}
