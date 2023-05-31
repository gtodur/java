package practice.algos;

public class SelectionSort {

	static void printArray(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " -> ");
		}
		System.out.println();
	}
	
	static void selectionSort(int arr[])
    {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, -6, 3, 8};
		printArray(arr);
		selectionSort(arr);
		System.out.println("After sorting");
		printArray(arr);
	}

}
