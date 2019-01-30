/********************************************************************************************************
* Name: Insert
* Description: Insert a value into an array.
* Note: you can test this online using: https://www.compilejava.net/
********************************************************************************************************/

//main() method
public class main
{

  public static void main(String[] args)
  {
    System.out.print("testing");
    int initialSize = 3;
    Object[] initialObjectArray = new Object[initialSize];
    Object initialObject = new Object();
    int newPosition = 2;
    insert(initialObjectArray, initialSize,initialObject, newPosition);
  }
  
  /**
  * @param arr - input array
  * @param curSize - current size of array. For this discussion we can assume that curSize < arr.length so dont worry about array resizing
  * @param element - element to be inserted
  * @param position - the position at which element is to be inserted.
  */
  public static Object[] insert(Object[] arr, int curSize, Object element, int position) 
  {
    // declare an array to store the values
    Object[] outputObjectArray = new Object[(curSize + 1)];
    
    //copy everything in the array up to the insert point
    int i = 0;
    for(i = 0; i < position; i++) {
      outputObjectArray[i] = arr[i];
    }
    
    //insert the new object
    i++;
    outputObjectArray[i] = element;
    
    //copy everything after the insert point
    for(i = (position + 1); i < (curSize + 1); i++) {
      outputObjectArray[i] = arr[(i - 1)];
    }
    
    return outputObjectArray;
  }
}

