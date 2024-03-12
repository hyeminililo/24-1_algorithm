package lab0_1;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("lab0_1:남궁혜민");

		// 정수 개수, n개의 정수 입력  
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];

		double avr;
		int count = 0;
		int  sum = 0;

		for(int i =0 ; i<n; i++){
			array[i] = scanner.nextInt();
			sum += array[i];
		}

		avr = (double)sum/n;

		for (int i = 0; i<n; i++){
			if(array[i] >avr){
				count ++;
			}
			else {
				continue;
			}
		}

		// 평균값, 평균값보다 큰 정수 개수 출력
		System.out.println(avr);
		System.out.println(count);

		scanner.close();
	}
}
