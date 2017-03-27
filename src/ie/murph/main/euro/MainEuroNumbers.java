package ie.murph.main.euro;

import java.util.HashSet;
import java.util.Set;

public class MainEuroNumbers
{
    private final int MAX_NUMBER = 50;
    private final int MIN_NUMBER = 1;
    private final Set<Integer> mainNumbers;
    private RandomNumberGenerator randomNumberGenerator;
    
    public MainEuroNumbers(RandomNumberGenerator randomNumberGenerator)
    {
	this.randomNumberGenerator = randomNumberGenerator;
	mainNumbers = new HashSet<Integer>();
    }
    
    public void populteDataStructure()
    {
	while(mainNumbers.size() < 5)
	{
	    mainNumbers.add(generateRandomNumber());
	}
    }
    
    private int generateRandomNumber()
    {
	return randomNumberGenerator.getRandomNumberBetween(MIN_NUMBER, MAX_NUMBER);
    }
    
    public void printMainEuroNumbers()
    {
	getSetOfMainEuroNumbers().forEach(number->System.out.println(number));
    }
    
    private Set<Integer> getSetOfMainEuroNumbers()
    {
	return mainNumbers;
    }
}
