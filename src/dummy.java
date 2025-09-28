import java.io.PrintStream;

public class dummy {
    
	public static void main(String[] args) {
		PrintStream so = System.out;
		int[] nums = {1, 2, 3, 4, 5};

		for (int num : nums) {
		  if ( num % 2 == 0) {
		     continue;
		}
		  so.println(num);
		}

    
  }
}



	