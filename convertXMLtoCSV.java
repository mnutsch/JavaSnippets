/********************************************************************************************************
* Name: ConvertXMLtoCSV
* Description: This code converts a string of XML to CSV.
* Note: you can test this online using: https://www.compilejava.net/
********************************************************************************************************/

import java.io.*; //For converting a String to an InputStream
import java.nio.charset.StandardCharsets; //For converting a String to an InputStream
import javax.xml.parsers.*;  //For parsing XML
import org.w3c.dom.*;  //For parsing XML
import java.net.*;
import java.util.*; //For ArrayList
 
public class main
{
 
  public static void main(String[] args)
  {
    String myXMLString = "<?xml version=\"1.0\"?><users><user><name>jcorbin</name><email>jcorbin@acmeindustries.com</email><first>Jeremy</first><middle>L</middle><last>Corbin</last></user><user><name>slewis</name><email>slewis@acmeindustries.com</email><first>Stacy</first><middle>M</middle><last>Lewis</last></user><user><name>djones</name><email>djones@acmeindustries.com</email><first>David</first><middle>H</middle><last>Jones</last></user></users>";
    ArrayList<String> newCSV = convertXMLtoCSV(myXMLString);
 
    System.out.print(newCSV);
    
    //ToDo: do something with this output here...
     
  }
 
  /*****************************************************************************************************
  * Name: convertXMLtoCSV
  * Description:
  * This function accepts an XML string as input and outputs an ArrayList<String> with CSV formatted
  * data.
  ******************************************************************************************************/
  public static ArrayList<String> convertXMLtoCSV(String XMLInputString)
  {
     
    ArrayList<String> CSVOutput = new ArrayList<String>(); //To store an ArrayList with our output.
     
    //Convert the String parameter to an InputStream for use by the Document lib
    InputStream stream = new ByteArrayInputStream(XMLInputString.getBytes(StandardCharsets.UTF_8));
     
    //Parse the XML to a Java Object Array
    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(stream);
       
      //Create an array of CSV strings to output
      NodeList nodeList = document.getElementsByTagName("user");
 
      for (int i = 0; i < nodeList.getLength(); i++) {
          Node currentNode = nodeList.item(i);
         
          //Initialize empty variables to hold the values we read
          String newUserName = "";
          String newUserEmail = "";
          String newUserFirst = "";
          String newUserMiddle = "";
          String newUserLast = "";
         
          NodeList childList = nodeList.item(i).getChildNodes();
          for (int j = 0; j < childList.getLength(); j++) {
            Node childNode = childList.item(j);
             
            switch (childNode.getNodeName()) {
              case "name":
                newUserName = childNode.getTextContent();
                break;
              case "email":
                newUserEmail = childNode.getTextContent();
                break;
              case "first":
                newUserFirst = childNode.getTextContent();
                break;
              case "middle":
                newUserMiddle = childNode.getTextContent();
                break;
              case "last":
                newUserLast = childNode.getTextContent();
                break;
            }
             
          }
         
          String newCSVLine = newUserName + ",AcmeIndustries," + newUserEmail + "," + newUserFirst + "," + newUserMiddle + "," + newUserLast + ",1,US,en";
             
          CSVOutput.add(newCSVLine);
      }
     
    } catch (Exception ex) {
        ex.printStackTrace();
    }
     
    return CSVOutput;
  }
}
