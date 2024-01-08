/* PairSum.java
   CSC 225 - Summer 2016

   Template for the PairSum225 problem, which takes an array A and returns
	- true if there are two elements of A which add to 225
	- false otherwise

*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class PairSum_template {

	/* PairSum225()
	The input array A will contain non-negative integers. The function
	will search the array A for a pair of elements which sum to 225.
	If such a pair is found, return true. Otherwise, return false.
	The function may modify the array A.
	Do not change the function signature (name/parameters).
	*/

	public static boolean PairSum225(int[] A){
		// Sort the array
		MergeSort(A, 0, A.length - 1);

		// Check if the array is sorted
		boolean sorted = isSorted(A, 0, A.length - 1);
		if (sorted == true) {

			// Check if any 2 elements in array sum to 225
			int left = 0;
			int right = A.length - 1;
			while (left < right) {
				int sum = A[left] + A[right];
				if (sum == 225) {
					return true;
				} else if (sum < 225) {
					left++;
				} else {
					right--;
				}
			}
		}
		return false;
	}


	/*  MergeSort()
	 *  MergeSort function will sort the numbers in array A with index from le to ri.
	 *  The time complexity of this function is O(nlogn).
	 */
	public static void MergeSort(int[] A, int le, int ri){
		if (le < ri) {
			int mid = le + ((ri - le) / 2);
			MergeSort(A, le, mid);
			MergeSort(A, mid + 1, ri);
			Merge(A, le, mid, ri);
		}
	}

	/*  Merge()
	 *  Merge() function merges two sorted sub-arrays to a sorted unit. The two
	 *  sub-arrays are numbers of A with index from le to mid, and from mid+1 to
	 *  ri respectively.
	 */
	public static void Merge(int[] A, int le, int mid, int ri){

		// Find sizes of the two subarrays to be merged
		int size_l = mid - le + 1;
		int size_r = ri - mid;

		// Create temporary arrays
		int[] L = new int[size_l];
		int[] R = new int[size_r];

		// copy data to temporary arrays
		for (int i = 0; i < size_l; ++i) {
			L[i] = A[le + i];
		}
		for (int j = 0; j < size_r; ++j) {
			R[j] = A[mid + 1 + j];
		}

		// Merge the temporary arrays

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = le;
		while (i < size_l && j < size_r) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}
		
		// Copy remaining elements of L[] if any
		while (i < size_l) {
			A[k] = L[i];
			i++;
			k++;
		}

		// Copy remaning elements of R[] if any
		while (j < size_r) {
			A[k] = R[j];
			j++;
			k++;
		}
	}

	/* isSorted()
	 Check whether or not the given array is successfully sorted.
	 If it is, return true; otherwise return false.
	*/
    public static boolean isSorted(int[] A, int le, int ri){
    	for (int i= le+1;i<=ri;i++)
    		if (A[i]<A[i-1]) return false;
    	return true;
    }


	/* main()
	 Contains code to test the PairSum225 function.
	*/
	public static void main(String[] args){
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

		boolean pairExists = PairSum225(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		System.out.printf("Array %s a pair of values which add to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
