package ie.murph.main.euro;

import ie.murph.main.euro.random.api.RandomNumberGenerator;
import ie.murph.main.euro.random.numbers.EuromillionsBonusNumbers;
import ie.murph.main.euro.random.numbers.EuromillionsMainNumbers;
import ie.murph.main.euro.read.conversion.ConvertVariables;
import ie.murph.main.euro.read.file.ReadEuromillionsTextFile;
import ie.murph.main.euro.read.model.numbers.BonusNumbers;
import ie.murph.main.euro.read.model.numbers.MainNumbers;
import ie.murph.main.euro.read.statistics.PopularNumbers;

public class RunEuromillions
{
    public static void main(String[] args)
    {
	RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
	
	System.out.println(" ");
	
	EuromillionsMainNumbers firstFiveEuroNumbers = new EuromillionsMainNumbers(randomNumberGenerator);
	firstFiveEuroNumbers.selectMainEuroNumbers();
	firstFiveEuroNumbers.printMainEuroNumbers();
	
	System.out.println(" ");
	
	EuromillionsBonusNumbers bonusEuroNumbers = new EuromillionsBonusNumbers(randomNumberGenerator);
	bonusEuroNumbers.selectBonusEuroNumbers();
	bonusEuroNumbers.printBonusEuroNumbers();
	
	System.out.println(" ");
	
	System.out.println("Reading from file");
	ConvertVariables convertVariables = new ConvertVariables();
	ReadEuromillionsTextFile readEuromillionsTextFile = new ReadEuromillionsTextFile(convertVariables);
	readEuromillionsTextFile.readTextFile();
	MainNumbers mainNumbers = new MainNumbers(readEuromillionsTextFile.getUnsortedMainLottoNumbersFromTextFile());
	BonusNumbers bonusNumbers = new BonusNumbers(readEuromillionsTextFile.getUnsortedBonusLottoNumbersFromTextFile());
	
	System.out.println(" ");
	PopularNumbers mode = new PopularNumbers();
	mode.getMostFrequentLottoNumbers(mainNumbers.getMainLottoNumbers(), 5);
	mode.printMostPopularLottoNumbers();
	mode.clearMostPopularNumbers();
	
	System.out.println(" ");
	mode.getMostFrequentLottoNumbers(bonusNumbers.getBonusLottoNumbers(), 2);
	mode.printMostPopularLottoNumbers();
	mode.clearMostPopularNumbers();
	
	System.out.println(" ");
//	mainNumbers.printMainLottoNumbers();
	System.out.println(" ");
//	bonusNumbers.printBonusLottoNumbers();
    }
}
