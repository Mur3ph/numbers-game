package ie.murph.main.euro.read.statistics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopularNumbers
{
    private Set<Integer> mostPopularNumbers;
   
    public PopularNumbers()
    {
	mostPopularNumbers = new HashSet<Integer>();
    }
    
    public void getMostPopularLottoNumbersMode( List<Integer> numbers, int amount)
    {
	int mostPopularNumber, count = 0;
	while(mostPopularNumbers.size() < amount)
	{
	    mostPopularNumber = getMostPopularMainLottoNumberMode(numbers);
	    mostPopularNumbers.add(mostPopularNumber);
	    numbers = removeTopMostPopularNumbersFromList(numbers, mostPopularNumber);
	    count++;
	}
	System.out.println("Count: " + count);
    }
    
    private List<Integer> removeTopMostPopularNumbersFromList(List<Integer> numbers, int mostPopularNumber)
    {
	numbers.removeAll(Arrays.asList(mostPopularNumber));
	return numbers;
    }
    
    private int getMostPopularMainLottoNumberMode(List<Integer> numbers)
    {
	int count = 1, tempCount = 0, mostCommonNumber = 0;
	for(int firstNumber : numbers)
	{
	    for(int secondNumber : numbers.subList(1, numbers.size()))
	    {
		if(firstNumber == secondNumber)
		{
		    tempCount++;
		}
	    }
	    if(tempCount > count)
	    {
		mostCommonNumber = firstNumber;
		count = tempCount;
	    }
	}
	return mostCommonNumber;
    }
    
    public Set<Integer> getMostPopularNumbers()
    {
	return mostPopularNumbers;
    }
    
    public void clearMostPopularNumbers()
    {
	mostPopularNumbers.clear();
    }
    
    public void printMostPopularLottoNumbers()
    {
	mostPopularNumbers.forEach(System.out::println);
    }
    
}
