package practice.test;

import java.time.Clock;
import java.time.OffsetDateTime;

public class MultiDimensionArraysPractice {

	public static void main(String[] args) {
		int [][] a2dArray = new int[10][20];
		int [][][] a3dArray = new int[10][20][30];
		
		//RxC = 1x3 matrix
		int [][] sample2dArray = {{2, 3, 7}, {-1, -6, -4}, {34, 52, 77}};
		for(int i=0; i<3; i++) {	//iterate rows
			for(int j=0; j<3; j++) {	//iterate columns
				System.out.print(sample2dArray[i][j] + " ");
			}
			System.out.println();
		}
		
		//Multidimensional array clone is a shallow copy
		//it creates only a single new array with each element array a reference to an original element array 
		//but subarrays are shared.
		int[][] clonedSample2DArray = sample2dArray.clone();
		
		//separate copy is created as clone, hence false
		System.out.println(sample2dArray == clonedSample2DArray);
		
		//subarrays are shared, so true
		System.out.println(sample2dArray[0] == clonedSample2DArray[0]);
		System.out.println(sample2dArray[1] == clonedSample2DArray[1]);
		System.out.println(sample2dArray[2] == clonedSample2DArray[2]);
		
		System.out.println(OffsetDateTime.now(Clock.systemUTC()));
	}
	
}
