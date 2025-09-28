import java.io.PrintStream;
import java.util.Scanner;

import javax.print.event.PrintJobListener;

public class dummy {
    
	public static void main(String[] args) {
    
    int[][] matriz = {		{00, 01, 02},		{10, 11, 12},		{20, 21, 22},		{30, 31}	          }    ;
    System.out.println(matriz.length);
    for (int[] is : matriz) {
      System.out.println(is.length);  
    }
    
  }
}



	