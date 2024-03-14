package lab0_3;

import java.util.Scanner;

public class Main_202214052 {
public static void main(String[] args) {
	System.out.println("ㅣab0_3: 남궁혜민");
	int array[] = {120,990,130,150,20,300,400,990,40,100,110,150,60,80,190,200};
	int sortedArray[] = {20,40,60,80,100,110,120,130,150,150,190,200,300,400,990,990};
	Scanner scanner = new Scanner(System.in);l
	int item  = scanner.nextInt();
	
	System.out.println(sequentialSearch(array,item));
	
	System.out.println(binarySearch(sortedArray,0,array.length-1,item));
	scanner.close();
}

private static int sequentialSearch(int[] array,int item) {
	
}
private static int binarySearch(int[] array, int from, int to, int item) {
	
}
}
