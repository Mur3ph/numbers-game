package ie.murph.main.euro.read.model.numbers;

import java.util.List;

public class MainNumbers
{
    private final List<Integer> mainLottoNumbers;
    
    public MainNumbers(List<Integer> mainLottoNumbers)
    {
	this.mainLottoNumbers = mainLottoNumbers;
    }
    
    public void printMainLottoNumbers()
    {
	mainLottoNumbers.forEach(System.out::println);
    }
}
