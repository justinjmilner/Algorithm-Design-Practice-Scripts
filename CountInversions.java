import java.util.*;
import java.io.*;

public class CountInversions{

	//This method prints the contents of an int[]
	private static void printArray(int[] arr){
		//Prints out the contents of an array if it is not -1000, with each element in the array on a new line
		for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			
		}
	}

	public static int CountInversions(int[] arr){
		int invCount = 0;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			// Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position and count the moves as inversions
			while (j >= 0 && arr[j] > key && invCount < ((n*(n - 1))/2)) {
				arr[j + 1] = arr[j];
				j = j - 1;
				invCount++;
			}
			arr[j + 1] = key;
		}
		return invCount;
	}

	public static void main(String []args){
			Scanner s;
			if (args.length > 0){
				try{
					s = new Scanner(new File(args[0]));
				} catch(java.io.FileNotFoundException e){
					System.out.printf("Unable to open %s\n",args[0]);
					return;
				}
				System.out.printf("Reading input values from %s.\n",args[0]);
			}else{
				s = new Scanner(System.in);
				System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
			}
			Vector<Integer> inputVector = new Vector<Integer>();
			int v;
			while(s.hasNextInt() && (v = s.nextInt()) >= 0)
				inputVector.add(v);

			int[] array = new int[inputVector.size()];
	
			for (int i = 0; i < array.length; i++)
				array[i] = inputVector.get(i);

			System.out.printf("Read %d values.\n",array.length);
			


			long startTime = System.currentTimeMillis();
			int numberOfInversions = CountInversions(array);
			System.out.println(numberOfInversions);
			long endTime = System.currentTimeMillis();
			double totalTimeSeconds = (endTime-startTime)/1000.0;

			//System.out.printf("Array %s a pair of values which add to 225.\n",pairExists? "contains":"does not contain");
			System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
		}
}
