
public class A734_SelectionSort {
	
	public static void main(String[] args) {
		
		int[] arrayToSort = {2,3,1,-5,235,-138};
		int[] anotherArrayToSort = {-4, 2, 5, -5, 5, -15, 15};
		
		int[] sortedArray1 = sortArray(arrayToSort);
		int[] sortedArray2 = sortArray(anotherArrayToSort);
		
		System.out.println("first array sorted: ");
		for(int i = 0; i < 6; i++)
			System.out.println(sortedArray1[i]);
		
		System.out.println("second array sorted: ");
		for(int i = 0; i < 7; i++)
			System.out.println(sortedArray2[i]);
	}
	
	public static int[] sortArray(int[] toSort) {
		
		int arrayLength = toSort.length;
		int nextLowestIndex;
		int temporaryInt;
		
		for(int i = 0; i < arrayLength; i++) {
			nextLowestIndex = i;
			for(int j = i; j < arrayLength; j++) 
				if(toSort[j] < toSort[nextLowestIndex]) nextLowestIndex = j;
			temporaryInt = toSort[nextLowestIndex];
			toSort[nextLowestIndex] = toSort[i];
			toSort[i] = temporaryInt;
		}
		
		return toSort;
	}
}
