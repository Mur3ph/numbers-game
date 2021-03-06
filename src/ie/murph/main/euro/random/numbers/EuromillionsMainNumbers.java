package ie.murph.main.euro.random.numbers;

import java.util.HashSet;
import java.util.Set;

import ie.murph.main.euro.random.api.RandomNumberGenerator;

public class EuromillionsMainNumbers
{
    private final int MAX_NUMBER = 50;
    private final int MIN_NUMBER = 1;
    private final Set<Integer> mainNumbers;
    private RandomNumberGenerator randomNumberGenerator;
    
    public EuromillionsMainNumbers(RandomNumberGenerator randomNumberGenerator)
    {
	this.randomNumberGenerator = randomNumberGenerator;
	mainNumbers = new HashSet<Integer>();
    }
    
    public void selectMainEuroNumbers()
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
