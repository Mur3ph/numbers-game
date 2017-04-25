package ie.murph.main.euro.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.murph.main.euro.read.conversion.ConvertVariables;

public class ReadEuromillionsTextFile
{
    // 14 columns
//    private final String DATA_FILE_URL = "data/euro-lotto-numbers.txt";
    private final String DATA_FILE_URL = "data/euro-lotto-numbers-24april2017.txt";
    private final int FIRST_FIVE_COLUMNS_OF_TEXT_FILE = 5;
    private final int LAST_TWO_COLUMNS_OF_TEXT_FILE = 2;
    private final int FIVE_MAIN_LOTTO_NUMBERS_OF_TEXT_FILE = 5;
    private final int TWO_BONUS_LOTTO_NUMBERS_OF_TEXT_FILE = 2;
    private Scanner read;
    private final List<Integer> mainNumbers;
    private final List<Integer> bonusNumbers;
    private final ConvertVariables convertVariables;
    
    public ReadEuromillionsTextFile(ConvertVariables convertVariables)
    {
	try
	{
	    read = new Scanner (new File(DATA_FILE_URL));
	} 
	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	mainNumbers = new ArrayList<Integer>();
	bonusNumbers = new ArrayList<Integer>();
	this.convertVariables = convertVariables;
    }
    
    public void readTextFile()
    {
	searchForComa();
		
	while(isStillDataInTextFile())
	{
	   skip(FIRST_FIVE_COLUMNS_OF_TEXT_FILE);
	   addMainEuroLottoNumbers();
	   addBonusEuroLottoNumbers();
	   skip(LAST_TWO_COLUMNS_OF_TEXT_FILE);
	}
	closeScanner();
    }

    private void searchForComa()
    {
	read.useDelimiter(",");
    }
    
    private boolean isStillDataInTextFile()
    {
	return read.hasNext();
    }
    
    private void skip(int numberOfRowsToSkip)
    {
	for(int iteration = 0; iteration < numberOfRowsToSkip; iteration++)
	{
	    read.next();
	}
    }
    
    private void addMainEuroLottoNumbers()
    {
	for(int iteration = 0; iteration < FIVE_MAIN_LOTTO_NUMBERS_OF_TEXT_FILE; iteration++)
	{
	    mainNumbers.add(convertVariables.convertStringToInteger(read.next()));
	}
    }
    
    private void addBonusEuroLottoNumbers()
    {
	for(int iteration = 0; iteration < TWO_BONUS_LOTTO_NUMBERS_OF_TEXT_FILE; iteration++)
	{
	    bonusNumbers.add(convertVariables.convertStringToInteger(read.next()));
	}
    }
    
    private void closeScanner()
    {
	read.close();
    }
    
    public List<Integer> getUnsortedMainLottoNumbersFromTextFile()
    {
	return this.mainNumbers;
    }
    
    public List<Integer> getUnsortedBonusLottoNumbersFromTextFile()
    {
	return this.bonusNumbers;
    }
}
