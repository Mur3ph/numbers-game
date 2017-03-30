package ie.murph.main.euro.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadEuromillionsTextFile
{
//  14 columns
    private static final String DATA_FILE_URL = "data/euro-lotto-numbers.txt";
    
    public static void readTextFile()
    {
	Scanner read = scanner();
	read.useDelimiter(",");
	String firstLottoNo, secondLottoNo, thirdLottoNo, fourthLottoNo, fifthLottoNo, firstLottoBonusNo, secondLottoBonusNo;
		
	while(read.hasNext())
	{
	    read.next();
	    read.next();
	    read.next();
	    read.next();
	    read.next();
	   firstLottoNo = read.next();			//6
	   secondLottoNo = read.next();			//7
	   thirdLottoNo = read.next();			//8
	   fourthLottoNo = read.next();			//9
	   fifthLottoNo = read.next();			//10
	   firstLottoBonusNo = read.next();		//11
	   secondLottoBonusNo = read.next();		//12
	   read.next();					//13
	   read.next();					//14
	   System.out.println(firstLottoNo + " " + secondLottoNo + " " + thirdLottoNo + " " + fourthLottoNo + " " + fifthLottoNo + "\n");
	   System.out.println(firstLottoBonusNo + " " + secondLottoBonusNo  + "\n");
	}
	read.close();
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
}
