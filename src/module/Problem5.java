package module;

import java.util.ArrayList;
import java.util.List;

import core.Module;
import core.MyMathUtilities;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Tim
 *
 */
public class Problem5 implements Module
{

	@Override
	public void run()
	{
		StringBuilder sb = new StringBuilder();
		List<Integer> primeFactors = new ArrayList<Integer>();
		for(int i = 1; i < 21; i++)
		{
			primeFactors.clear();
			sb.delete(0, sb.length());
			sb.append(i);
			sb.append(" : ");
			MyMathUtilities.getPrimeFactors(i, primeFactors);
			for(Integer factor : primeFactors)
			{
				sb.append(factor);
				sb.append(", ");
			}
			System.out.println(sb.toString());
		}
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 20; i++)
		{
			numbers.add(i);
		}
		System.out.println("Answer: " + MyMathUtilities.getLeastCommonMultiple(numbers));
	}
	
	
	
	

}
