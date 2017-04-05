package ie.murph.main.euro.read.statistics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopularNumbers
{
    private final Set<Integer> mostFrequentNumbers;
   
    public PopularNumbers()
    {
	mostFrequentNumbers = new HashSet<Integer>();
    }
    
    public void getMostFrequentLottoNumbers( List<Integer> numbers, int amount)
    {
	int mostFrequentNumber, count = 0;
	while(searchingForNumbers(amount))
	{
	    mostFrequentNumber = getMostFrequentLottoNumber(numbers);
	    storeNumberInSet(mostFrequentNumber);
	    removeNumbersFromList(numbers, mostFrequentNumber);
	    count++;
	}
	System.out.println("Count: " + count);
    }
    
    private boolean searchingForNumbers(int amount)
    {
	return mostFrequentNumbers.size() < amount;
    }
    
    private int getMostFrequentLottoNumber(List<Integer> numbers)
    {
	int mostFrequentNumber = 0;
	for(int numberChosenByFirstLoop : numbers)
	{
	    mostFrequentNumber = findMostFrequentLottoNumber(numbers, numberChosenByFirstLoop);
	}
	return mostFrequentNumber;
    }
    
    private int findMostFrequentLottoNumber(List<Integer> numbers, int numberChosenByFirstLoop)
    {
	int tempCount = 0;
	for(int numberChosenBySecondLoop : numbers.subList(1, numbers.size()))
	{
	    tempCount = increaseCountCheck(tempCount, numberChosenByFirstLoop, numberChosenBySecondLoop);
	}
	return mostFrequentNumber(numberChosenByFirstLoop, tempCount);
    }
    
    private int increaseCountCheck(int tempCount, int numberChosenByFirstLoop, int numberChosenBySecondLoop)
    {
	if(isSameNumber(numberChosenByFirstLoop, numberChosenBySecondLoop))
    	{
    	   tempCount++;
    	}
	return tempCount;
    }
    
    private boolean isSameNumber(int firstNumber, int secondNumber)
    {
	return firstNumber == secondNumber;
    }
    
    private int mostFrequentNumber(int numberChosenByFirstLoop, int tempCount)
    {
	int count = 1, mostFrequentNumber = 0;
	if(tempCountGreaterThanLastCount(tempCount, count))
	{
	    mostFrequentNumber = numberChosenByFirstLoop;
	    count = tempCount;
	}
	return mostFrequentNumber;
    }
    
    private boolean tempCountGreaterThanLastCount(int tempCount, int count)
    {
	return tempCount > count;
    }

    private void storeNumberInSet(int mostPopularNumber)
    {
	mostFrequentNumbers.add(mostPopularNumber);
    }
    
    private void removeNumbersFromList(List<Integer> numbers, int mostPopularNumber)
    {
	numbers.removeAll(Arrays.asList(mostPopularNumber));
    }
    
    public Set<Integer> getMostPopularNumbers()
    {
	return mostFrequentNumbers;
    }
    
    public void clearMostPopularNumbers()
    {
	mostFrequentNumbers.clear();
    }
    
    public void printMostPopularLottoNumbers()
    {
	mostFrequentNumbers.forEach(System.out::println);
    }
    
}
