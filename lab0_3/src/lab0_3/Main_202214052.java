package lab0_3;

import java.util.Scanner;

public class Main_202214052 {
	static int i;

	public static void main(String[] args) {
		System.out.println("lab0_3: 남궁혜민");
		// 배열 초기화 
		int array[] = { 120, 990, 130, 150, 20, 300, 400, 990, 40, 100, 110, 150, 60, 80, 190, 200 };
		int sortedArray[] = { 20, 40, 60, 80, 100, 110, 120, 130, 150, 150, 190, 200, 300, 400, 990, 990 };
		Scanner scanner = new Scanner(System.in);
		int item = scanner.nextInt();
		
		//정렬되지 않은 배열에서 순차검색하여 위치 출력 
		System.out.println(sequentialSearch(array, item));
		
		//정렬된 배열에서 원소를 이진검색 
		System.out.println(binarySearch(sortedArray, 0, array.length - 1, item));
		scanner.close();
	}

	private static int sequentialSearch(int[] array, int item) {
		for (i = 0; i < array.length; i++) {
			if (array[i] == item) {
				return i;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] array, int from, int to, int item) {
	if(from>to) return -1;
	
	int mid =(from + to)/2;
	if(array[mid]==item)return mid;
	
	else if(array[mid]>item) {
		return binarySearch(array,from, mid-1,item);
		
	}
	else {
		return binarySearch(array, mid+1,to,item);
	}
	}
}
