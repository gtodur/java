package practice.algos;

public class BubbleSort {

	static void printArray(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " -> ");
		}
		System.out.println();
	}
	
	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=1; j<n-i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, -6, 3, 8};
		printArray(arr);
		bubbleSort(arr);
		System.out.println("After sorting");
		printArray(arr);
	}

}
