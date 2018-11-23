import java.util.Scanner;
import java.util.Arrays;

public class ArraysEample {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[] myIntArray = new int[10];
    int[] myIntArray2 = {1, 2, 3,4, 5, 6,7,8,9,10};
    myIntArray[5] = 50;

    myIntArray = new int[] {2,2,2,2,2,2,2,2,2,2};

    int[] myIntArray3 = getIntegers(5);
   
    //printArray(myIntArray3);
    printArray(sortIntegers(myIntArray3));

    System.out.println("myIntArray2 contents: " + Arrays.toString(myIntArray2));
    System.out.println("Average: " + getAverage(myIntArray3));
  }

  public static int[] sortIntegers(int[] array) {
    // int[] sorted = new int[array.length];

    // for(int i = 0; i < array.length; ++i) {
    //   sorted[i] = array[i];
    // }

    int[] sorted = Arrays.copyOf(array, array.length);

    boolean flag = true;
    int temp;
    while(flag) {
      flag = false;
      for(int i =0; i< sorted.length-1; ++i) {
        if(sorted[i] < sorted[i+1]){
          temp = sorted[i];
          sorted[i] = sorted[i+1];
          sorted[i+1] = temp;
          flag = true;
        }
      }
    }

    return sorted;
  }

  public static void printArray(int[] array) {
    for(int i = 0; i < array.length; ++i) {
      System.out.print(array[i] + ", ");
    }
    System.out.println("");
  }

  public static int[] getIntegers(int count) {
    System.out.println("Enter" + count + " integer values. \r");
    int[] values = new int[count];

    for(int i = 0; i < values.length; ++i) {
      values[i] = scanner.nextInt();
    }

    return values;
  }

  public static double getAverage(int[] array) {
    int sum = 0;

    for(int i = 0; i < array.length; ++i) {
      sum += array[i];
    }

    return (double) sum/array.length;
  }
}