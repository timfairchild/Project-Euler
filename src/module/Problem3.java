package module;

import java.util.ArrayList;
import java.util.List;

import core.Module;
import core.MyMathUtilities;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Tim
 *
 */
public class Problem3 implements Module
{

	@Override
	public void run()
	{
		long maximum = (long) Math.sqrt(600851475143l);
		List<Long> uncheckedFactors = new ArrayList<Long>();

		for (long i = 2; i <= maximum; i++)
		{
			if (600851475143l % i == 0)
			{
				uncheckedFactors.add(i);
				if (MyMathUtilities.isPrime(600851475143l / i))
				{
					System.out.println("Answer: " + i);
					break;
				}
			}
		}

		for (int i = uncheckedFactors.size() - 1; i >= 0; i--)
		{
			if (MyMathUtilities.isPrime(uncheckedFactors.get(i)))
			{
				System.out.println("Answer: " + uncheckedFactors.get(i));
				break;
			}
		}
	}
}
