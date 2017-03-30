package ie.murph.main.euro.random.api;

import java.util.Random;

public class RandomNumberGenerator
{
    private final Random randomNumber;
    
    public RandomNumberGenerator()
    {
	randomNumber = new Random();
    }
    
    public int getRandomNumberBetween(int min, int max)
    {
	return randomNumber.nextInt(max - min + 1) + min;
    }
}
