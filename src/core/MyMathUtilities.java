package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class MyMathUtilities
{
	public static boolean isPrime(long number)
	{
		if (number < 2)
			return false;
		long maximum = (long) Math.sqrt(number);
		for (long i = 2; i <= maximum; i++)
		{
			if (number % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome(int number)
	{
		int reverseNumber = 0;
		int placeHolder = number;
		while (placeHolder >= 1)
		{
			reverseNumber = reverseNumber * 10 + placeHolder % 10;
			placeHolder = placeHolder / 10;
		}
		if (reverseNumber == number)
			return true;
		return false;
	}

	public static Set<Integer> getFactors(Integer value)
	{
		Set<Integer> factors = new TreeSet<Integer>();
		for (int i = 1; i <= Math.sqrt(value); i++)
		{
			if (value % i == 0)
			{
				factors.add(i);
				factors.add(value / i);
			}
		}
		return factors;
	}

	public static void getPrimeFactors(Integer value, List<Integer> primeFactors)
	{
		if(isPrime(value))
		{
			primeFactors.add(value);
			return;
		}
		for (int i = 2; i <= Math.sqrt(value); i++)
		{
			if (value % i == 0)
			{
				if (isPrime(i))
				{
					primeFactors.add(i);
					getPrimeFactors(value /i, primeFactors);
					return;
				}
			}
		}
	}
	
	public static Integer getLeastCommonMultiple(List<Integer> numbers)
	{
		Map<Integer, Integer> masterPrimeFactorMap = new HashMap<Integer, Integer>();
		List<Integer> primeFactors = new ArrayList<Integer>();
		Map<Integer, Integer> primeFactorMap = new HashMap<Integer, Integer>();
		for(Integer i : numbers)
		{
			primeFactors.clear();
			primeFactorMap.clear();
			getPrimeFactors(i, primeFactors);
			for(Integer j : primeFactors)
			{
				if(primeFactorMap.get(j) == null)
					primeFactorMap.put(j, 0);
				primeFactorMap.put(j, primeFactorMap.get(j) + 1);
			}
			
			for(Integer j : primeFactorMap.keySet())
			{
				if(masterPrimeFactorMap.get(j) == null)
					masterPrimeFactorMap.put(j, 0);
				if(masterPrimeFactorMap.get(j) < primeFactorMap.get(j))
					masterPrimeFactorMap.put(j, primeFactorMap.get(j));
			}
		}
		Integer lcm = 1;
		for(Entry<Integer, Integer> entry : masterPrimeFactorMap.entrySet())
		{
			lcm *= (int)Math.pow(entry.getKey(), entry.getValue());
		}
		return lcm;
	}

}
