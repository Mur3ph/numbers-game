package ie.murph.main.euro;

import ie.murph.main.euro.random.api.RandomNumberGenerator;
import ie.murph.main.euro.random.numbers.BonusEuroNumbers;
import ie.murph.main.euro.random.numbers.MainEuroNumbers;
import ie.murph.main.euro.read.file.ReadEuromillionsTextFile;
import ie.murph.main.euro.read.model.numbers.BonusNumbers;
import ie.murph.main.euro.read.model.numbers.MainNumbers;

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
	
	System.out.println(" ");
	
	System.out.println("Reading from file");
	ReadEuromillionsTextFile readEuromillionsTextFile = new ReadEuromillionsTextFile();
	readEuromillionsTextFile.readTextFile();
	MainNumbers mainNumbers = new MainNumbers(readEuromillionsTextFile.getMainNumbers());
	BonusNumbers bonusNumbers = new BonusNumbers(readEuromillionsTextFile.getBonusNumbers());
	
	System.out.println(" ");
	mainNumbers.printMainLottoNumbers();
	System.out.println(" ");
	bonusNumbers.printBonusLottoNumbers();
    }
}
