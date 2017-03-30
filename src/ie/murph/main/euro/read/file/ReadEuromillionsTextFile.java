package ie.murph.main.euro.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadEuromillionsTextFile
{
//  14 columns
    private static final String DATA_FILE_URL = "data/euro-lotto-numbers.txt";
    private static List<Integer> mainLottoNumbers = new ArrayList<Integer>();
    private static List<Integer> bonusLottoNumbers = new ArrayList<Integer>();
    
    public static void readTextFile()
    {
	Scanner read = scanner();
	read.useDelimiter(",");
//	String firstLottoNo, secondLottoNo, thirdLottoNo, fourthLottoNo, fifthLottoNo, firstLottoBonusNo, secondLottoBonusNo;
		
	while(read.hasNext())
	{
	   skip(read, 5);
	   addMainEurpLottoNumbers(read, 5);
	   addBonusEurpLottoNumbers(read, 2);
	   skip(read, 2);
	}
	read.close();
	
	System.out.println("############################################-Mains-############################################");
	printMainList();
	System.out.println("############################################-Bonus-############################################");
	printBonusList();
    }
    
    private static Scanner scanner()
    {
	try
	{
	    return new Scanner (new File(DATA_FILE_URL));
	}
	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	return new Scanner("");
    }
    
    private static void skip(Scanner read, int numberOfRowsToSkip)
    {
	for(int iteration = 0; iteration < numberOfRowsToSkip; iteration++)
	{
	    read.next();
	}
    }
    
    private static void addMainEurpLottoNumbers(Scanner read, int numberOfLottoResults)
    {
	for(int iteration = 0; iteration < numberOfLottoResults; iteration++)
	{
	    mainLottoNumbers.add(convertStringToInteger(read.next()));
	}
    }
    
    private static void addBonusEurpLottoNumbers(Scanner read, int numberOfLottoResults)
    {
	for(int iteration = 0; iteration < numberOfLottoResults; iteration++)
	{
	    bonusLottoNumbers.add(convertStringToInteger(read.next()));
	}
    }
    
    private static int convertStringToInteger(String stringToConvert)
    {
	return Integer.parseInt(stringToConvert.trim());
    }
    
    private static void printMainList()
    {
	mainLottoNumbers.forEach(System.out::println);
    }
    
    private static void printBonusList()
    {
	bonusLottoNumbers.forEach(System.out::println);
    }
}
