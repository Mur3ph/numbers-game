package ie.murph.main.euro;

import ie.murph.main.euro.random.api.RandomNumberGenerator;
import ie.murph.main.euro.random.numbers.EuromillionsBonusNumbers;
import ie.murph.main.euro.random.numbers.EuromillionsMainNumbers;
import ie.murph.main.euro.read.conversion.ConvertVariables;
import ie.murph.main.euro.read.file.ReadEuromillionsTextFile;
import ie.murph.main.euro.read.model.numbers.BonusNumbers;
import ie.murph.main.euro.read.model.numbers.MainNumbers;
import ie.murph.main.euro.read.statistics.MostFrequentNumbers;

public class RunEuromillions {
	public static void main(String[] args) {
		System.out.println("Reading from random number generation!\n");
		runLottoUsingRandomGenerator();

		System.out.println(" ");

		System.out.println("Reading from file!\n");
		runLottoUsingTextFile();
	}

	private static void runLottoUsingRandomGenerator() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		EuromillionsMainNumbers firstFiveEuroNumbers = new EuromillionsMainNumbers(randomNumberGenerator);
		firstFiveEuroNumbers.selectMainEuroNumbers();
		firstFiveEuroNumbers.printMainEuroNumbers();

		System.out.println(" ");
		EuromillionsBonusNumbers bonusEuroNumbers = new EuromillionsBonusNumbers(randomNumberGenerator);
		bonusEuroNumbers.selectBonusEuroNumbers();
		bonusEuroNumbers.printBonusEuroNumbers();
	}

	private static void runLottoUsingTextFile() {
		ConvertVariables convertVariables = new ConvertVariables();
		ReadEuromillionsTextFile readEuromillionsTextFile = new ReadEuromillionsTextFile(convertVariables);
		readEuromillionsTextFile.readTextFile();
		MainNumbers mainNumbers = new MainNumbers(readEuromillionsTextFile.getUnsortedMainLottoNumbersFromTextFile());
		BonusNumbers bonusNumbers = new BonusNumbers(
				readEuromillionsTextFile.getUnsortedBonusLottoNumbersFromTextFile());

		MostFrequentNumbers mode = new MostFrequentNumbers();
		mode.getMostFrequentLottoNumbers(mainNumbers.getMainLottoNumbers(), 5);
		mode.printMostFrequentLottoNumbers();
		mode.clearMostFrequentNumbers();

		System.out.println(" ");
		mode.getMostFrequentLottoNumbers(bonusNumbers.getBonusLottoNumbers(), 2);
		mode.printMostFrequentLottoNumbers();
		mode.clearMostFrequentNumbers();
	}
}
