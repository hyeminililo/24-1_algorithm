package lab0_2;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {

		System.out.println("lab0_2:남궁혜민");

		// 정수 값 입력 
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// 1부터 n까지의 합과 정수리스트 출력 
		System.out.println(sum(n));
		print(n);

		scanner.close();
	}

	// 1부터 n까지의 합을 구하여 리턴하는 메소드
	private static int sum(int n) {
		if(n==1) {
			return 1;
		}
		else
			return n + sum(n-1); 
	}

	// 1부터 n까지 출력하는 메소드 
	private static void print(int n) {
		if(n>0) {
			print(n-1);
			System.out.print(n+" ");
		}
	}
}
