package hw4_1;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("hw4_1:남궁혜민");

		// 객체 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 크기가 n인 배열 생성 및 배열에 입력 값 저장
		double[] array = new double[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextDouble();
		}

		// 퀵 정렬 메소드 호출
		quickSort(array, 0, n - 1);

		// 퀵 정렬된 배열 원소 출력
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}

		sc.close();

	}

	// partition 메소드에서 받은 기준 원소 인덱스 값을 통해 퀵 정렬하는 메소드
	public static void quickSort(double a[], int p, int r) {

		if (p < r) {
			// q는 partition 메소드의 기준 원소 위치 리턴 값
			int q = partition(a, p, r);

			// quickSort로 q를 기준으로 두 부분으로 나누어서, 재귀적 정렬
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	// 기준원소를 기준으로 재배치하고, 배열의 기준 원소의 위치 값을 반환하는 메소드
	public static int partition(double a[], int p, int r) {

		double x = a[r]; // 마지막 원소룰 기준 원소로 설정
		int i = p - 1; // i는 기준 원소보다 작은 원소들의 마지막 인덱스 ( 1구역의 끝 지점 )
		double tmp; // 임시공간 생성

		for (int j = p; j < r; j++) { // j는 기준 원소보다 큰 원소들의 첫 인덱스 ( 3구역의 시작 지점 -> 검사를 아직 안한 원소들)
			// 기준 원소보다 작은 원소를 기준 원소보다 앞으로 이동
			if (a[j] <= x) {
				i++;

				// a[i]와 a[j]의 위치를 교환
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		// 기준 원소를 최종 위치로 이동
		tmp = a[i + 1];
		a[i + 1] = x;
		a[r] = tmp;

		return i + 1; // 기준 원소 인덱스 값 반환
	}
}
