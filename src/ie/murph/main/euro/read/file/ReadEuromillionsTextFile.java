package ie.murph.main.euro.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.murph.main.euro.read.conversion.ConvertVariables;

public class ReadEuromillionsTextFile
{
    //  14 columns
    private final String DATA_FILE_URL = "data/euro-lotto-numbers.txt";
    private final int FIRST_FIVE_COLUMNS_OF_TEXT_FILE = 5;
    private final int LAST_TWO_COLUMNS_OF_TEXT_FILE = 2;
    private final int FIVE_MAIN_LOTTO_NUMBERS_OF_TEXT_FILE = 5;
    private final int TWO_BONUS_LOTTO_NUMBERS_OF_TEXT_FILE = 2;
    private Scanner read;
    private final List<Integer> mainNumbers;
    private final List<Integer> bonusNumbers;
    private final ConvertVariables convertVariables;
    
    public ReadEuromillionsTextFile()
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
	convertVariables = new ConvertVariables();
    }
    
    public void readTextFile()
    {
	read.useDelimiter(",");
		
	while(read.hasNext())
	{
	   skip(FIRST_FIVE_COLUMNS_OF_TEXT_FILE);
	   addMainEurpLottoNumbers();
	   addBonusEurpLottoNumbers();
	   skip(LAST_TWO_COLUMNS_OF_TEXT_FILE);
	}
	read.close();
    }
    
    private void skip(int numberOfRowsToSkip)
    {
	for(int iteration = 0; iteration < numberOfRowsToSkip; iteration++)
	{
	    read.next();
	}
    }
    
    private void addMainEurpLottoNumbers()
    {
	for(int iteration = 0; iteration < FIVE_MAIN_LOTTO_NUMBERS_OF_TEXT_FILE; iteration++)
	{
	    mainNumbers.add(convertVariables.convertStringToInteger(read.next()));
	}
    }
    
    private void addBonusEurpLottoNumbers()
    {
	for(int iteration = 0; iteration < TWO_BONUS_LOTTO_NUMBERS_OF_TEXT_FILE; iteration++)
	{
	    bonusNumbers.add(convertVariables.convertStringToInteger(read.next()));
	}
    }
    
    public List<Integer> getMainNumbers()
    {
	return this.mainNumbers;
    }
    
    public List<Integer> getBonusNumbers()
    {
	return this.bonusNumbers;
    }
}
