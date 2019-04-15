/********************************************************************************************************
* Name: charReplacement
* Description: This code replaces commas with pipes.
* Note: you can test this online using: https://www.compilejava.net/
********************************************************************************************************/

import java.lang.Math; 

public class charReplacement
{

  public static void main(String[] args)
  {
    String myCSVString = "some,original,data,lives,here";
    String modifiedString = replaceCommas(myCSVString);
    System.out.print(modifiedString);
  }
  
  /*****************************************************************************************************
  * Name: replaceCommas
  * Description:
  * This function accepts a string as a parameter. It then returns the same string with commas replaced
  * by pipes.
  ******************************************************************************************************/
  public static String replaceCommas(String inputString)
  {    
    String outputString = "";
    int stringLength = inputString.length();
    
    for (int i = 0; i < stringLength; i++) {
      if(inputString.charAt(i) == ',') {
        outputString = outputString + '|';
      }
      else {
        outputString = outputString + inputString.charAt(i);
      }
    }
    
    return outputString;
  }
  
}
