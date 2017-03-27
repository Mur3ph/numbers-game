package ie.murph.main.euro;

import java.util.HashSet;
import java.util.Set;

public class BonusEuroNumbers
{
    private final int MAX_NUMBER = 12;
    private final int MIN_NUMBER = 1;
    private final Set<Integer> bonusNumbers;
    private RandomNumberGenerator randomNumberGenerator;
    
    public BonusEuroNumbers(RandomNumberGenerator randomNumberGenerator)
    {
	this.randomNumberGenerator = randomNumberGenerator;
	bonusNumbers = new HashSet<Integer>();
    }
    
    public void populteDataStructure()
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
