package ie.murph.main.euro;

import ie.murph.main.euro.api.RandomNumberGenerator;
import ie.murph.main.euro.numbers.BonusEuroNumbers;
import ie.murph.main.euro.numbers.MainEuroNumbers;
import ie.murph.main.euro.read.file.ReadEuromillionsTextFile;

public class RunEuromillions
{
    public static void main(String[] args)
    {
	RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
	
	System.out.println(" ");
	
	MainEuroNumbers firstFiveEuroNumbers = new MainEuroNumbers(randomNumberGenerator);
	firstFiveEuroNumbers.selectMainEuroNumbers();
	firstFiveEuroNumbers.printMainEuroNumbers();
	
	System.out.println(" ");
	
	BonusEuroNumbers bonusEuroNumbers = new BonusEuroNumbers(randomNumberGenerator);
	bonusEuroNumbers.selectBonusEuroNumbers();
	bonusEuroNumbers.printBonusEuroNumbers();
	
	ReadEuromillionsTextFile.readTextFile();
    }
}
