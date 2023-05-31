package practice.algos;

public class InsertionSort {

	static void printArray(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " -> ");
		}
		System.out.println();
	}
	
	static void insertionSort(int arr[])
    {
        int n = arr.length;
        for(int i=1; i<n; i++) {
        	int current = arr[i];
        	int j = i-1;
        	while(j>=0 && arr[j] > current) {
        		arr[j+1] = arr[j];
        		j--;
        	}
        	arr[j+1] = current;
        }
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, -6, 3, 8};
		printArray(arr);
		insertionSort(arr);
		System.out.println("After sorting");
		printArray(arr);
	}

}
