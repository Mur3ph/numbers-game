package ie.murph.main.euro.read.model.numbers;

import java.util.List;

public class BonusNumbers
{
    private List<Integer> bonusLottoNumbers;
    
    public BonusNumbers(List<Integer> bonusLottoNumbers)
    {
	this.bonusLottoNumbers = bonusLottoNumbers;
    }
    
    public void printBonusLottoNumbers()
    {
	bonusLottoNumbers.forEach(System.out::println);
    }
}
