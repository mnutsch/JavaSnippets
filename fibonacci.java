// Pass test number into the main method as an argument.
// Test this online with https://www.compilejava.net/
import java.lang.Math; 
import java.util.*;

public class fibonacci
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    System.out.println(fibonacciNumber(Integer.parseInt(args[0])));
  }
  
  public static List<Integer> PopulateArray(Integer arrayPosition){
    List<Integer> intList = new ArrayList<Integer>();
    intList.add(0);
    intList.add(1);
    for(Integer i = 2; i <= arrayPosition; i++){
      Integer currentValue = intList.get(i - 2) + intList.get(i - 1);
      intList.add(currentValue);
    }
    
    return intList;
  }

  public static Integer fibonacciNumber(Integer numberPosition)
  {
    Integer resultValue = 0;
    
    List<Integer> resultList = new ArrayList<Integer>();
    resultList = PopulateArray(numberPosition);
    resultValue = resultList.get(numberPosition);
    return resultValue; 
  }

}
