package ie.murph.main.euro;

public class RunEuromillions
{
    public static void main(String[] args)
    {
	RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
	
	System.out.println(" ");
	
	MainEuroNumbers firstFiveEuroNumbers = new MainEuroNumbers(randomNumberGenerator);
	firstFiveEuroNumbers.populteDataStructure();
	firstFiveEuroNumbers.printMainEuroNumbers();
	
	System.out.println(" ");
	
	BonusEuroNumbers bonusEuroNumbers = new BonusEuroNumbers(randomNumberGenerator);
	bonusEuroNumbers.populteDataStructure();
	bonusEuroNumbers.printBonusEuroNumbers();
    }
}
