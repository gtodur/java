package practice.test;

public class JaggedArraysPractice {

	public static void main(String[] args) {
		/*
		 Declaration and Initialization of Jagged array
		 
		int [][] jaggedArray = new int[3][];	//where 3 number of rows
			jaggedArray[0] = new int[3];			// 3 number of columns in row - 1
			jaggedArray[1] = new int[1];			// 3 number of columns in row - 2
			jaggedArray[2] = new int[2];			// 3 number of columns in row - 3
			*/
		
		int[][] jaggedArray = new int[2][];		//Declaring 2-D array with 2 rows
		
		//Making the array as jagged array
		jaggedArray[0] = new int[3];			//First row has 3 columns
		jaggedArray[1] = new int[2];			//Second row has 2 columns
		
		int count = 0;
		
		for(int i=0; i<jaggedArray.length; i++) {
			for(int j=0; j<jaggedArray[i].length; j++) {
				jaggedArray[i][j] = ++count;
			}
		}
		
		//Alternate ways
		int [][] jaggedArray1 = new int[][] {
			new int[] {-78, -23, -45},
			new int[] {23, 45, 87, 45, 90},
			new int[] {40}
		};
		
		int [][] jaggedArray2 = {
			new int[] {-78, -23, -45},
			new int[] {23, 45, 87, 45, 90},
			new int[] {40}
		};
		
		int [][] jaggedArray3 = {
			{-78, -23, -45},
			{23, 45, 87, 45, 90},
			{40}
		};
		
		printJaggedArray(jaggedArray);
		printJaggedArray(jaggedArray1);
		printJaggedArray(jaggedArray2);
		printJaggedArray(jaggedArray3);
		
		//first row has 1 element, second row has two elements and so on.
		int r = 5;
		 
        // Declaring 2-D array with 5 rows
        int arr[][] = new int[r][];
 
        // Creating a 2D array such that first row
        // has 1 element, second row has two
        // elements and so on.
        for (int i = 0; i < arr.length; i++)
            arr[i] = new int[i + 1];
 
        // Initializing array
        count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = count++;
 
        // Displaying the values of 2D Jagged array
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
		
	}

	private static void printJaggedArray(int[][] jaggedArray) {
		// Displaying the values of 2D Jagged array
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++)
                System.out.print(jaggedArray[i][j] + " ");
            System.out.println();
        }
	}

}
