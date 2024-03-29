package hw4_2;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("hw4_1:남궁혜민");

		// 객체 입력받기
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		// 배열 생성 및 배열에 저장
		double[] array = new double[a];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextDouble();
		}

		int s;
		int p;
		int l;

	}

	public void quickSort(double a[], int p, int r) {
		
	}

	// r은 배열의 마지막 인덱스 값 -> 배열의 길이 ,,? , p는 시작 인덱스 값
	public int partition(double a[], int r, int p) {
		double x = a[r]; // 마지막 원소룰 기준 원소로 설정
		int i = p - 1; // i는 1구역이 끝 지점
		for (int j = p; j < r; j++) { // j는 3구역의 시작 지점 (검사를 아직 안한 원소들)
			if (a[j] <= x) {
				double tmp; // 임시공간 생성
				i++;
				a[i] = a[j];
			} else if (a[j] > x) {
				a[j - 1] = a[j];
			}
		}
		return i + 1;
	}
}
