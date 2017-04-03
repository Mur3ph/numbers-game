package ie.murph.main.euro.random.numbers;

import java.util.HashSet;
import java.util.Set;

import ie.murph.main.euro.random.api.RandomNumberGenerator;

public class EuromillionsBonusNumbers
{
    private final int MAX_NUMBER = 12;
    private final int MIN_NUMBER = 1;
    private final Set<Integer> bonusNumbers;
    private RandomNumberGenerator randomNumberGenerator;
    
    public EuromillionsBonusNumbers(RandomNumberGenerator randomNumberGenerator)
    {
	this.randomNumberGenerator = randomNumberGenerator;
	bonusNumbers = new HashSet<Integer>();
    }
    
    public void selectBonusEuroNumbers()
    {
	while(bonusNumbers.size() < 2)
	{
	    bonusNumbers.add(generateRandomNumber());
	}
    }
    
    private int generateRandomNumber()
    {
	return randomNumberGenerator.getRandomNumberBetween(MIN_NUMBER, MAX_NUMBER);
    }
    
    public void printBonusEuroNumbers()
    {
	getSetOfBonusEuroNumbers().forEach(number->System.out.println(number));
    }
    
    private Set<Integer> getSetOfBonusEuroNumbers()
    {
	return bonusNumbers;
    }
    
}
