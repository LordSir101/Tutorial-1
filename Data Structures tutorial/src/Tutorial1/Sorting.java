package Tutorial1;

public class Sorting {

	public static void main(String[] args) {
		int arr[] = new int[10];
		
		int k = 4;
		
		//fill array up to k
		for(int i = 0; i < k; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		
		/*
		//print
		for(int c = 0; c < arr.length; c++) {
			System.out.println(arr[c]);
		}*/
		
		//sort first k numbers
		for(int i = 0; i < arr.length; i++) {
			int min_idx = i;
			
			//find min
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] > arr[min_idx]) {
					min_idx = j;
				}
			}
			
			//swap
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		/*
		System.out.println("--------------------------------------------");
		//print
		for(int c = 0; c < arr.length; c++) {
			System.out.println(arr[c]);
		}*/
		
		//do insertion sort for each number after k
		long startTime = System.nanoTime();
		for(int j = k; j < arr.length; j++) {
			arr[j] = (int)(Math.random() * 100);
			//sort
			for(int l = 1; l < arr.length; l++) {
				int key = arr[l];
				int current_idx = l - 1;
				
				//if the current number is less than the number we are adding in
				//swap them and continue checking
				while(current_idx >= 0 && arr[current_idx] < key) {
					arr[current_idx + 1] = arr[current_idx];
					current_idx -= 1;
				}
				
				//when finished checking, we are either at the end of the array
				//or at the right position of the number
				arr[current_idx + 1] = key;
			}
		}
		
		/*
		//print sorted
		System.out.println("--------------------------------------------");
		for(int c = 0; c < arr.length; c++) {
			System.out.println(arr[c]);
		}*/
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("COMPLETED IN: " + (float) totalTime / 1000000 + "ms");

		System.out.print("The " + k + " largest number is: " + arr[k-1]);

	}

}
