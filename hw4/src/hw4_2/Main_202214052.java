package hw4_2;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("hw4_2:남궁혜민");

		// 객체 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 크기가 n인 배열 생성 및 배열에 입력 값 저장
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextDouble();
		}

		// 병합 정렬 메소드 호출
		mergeSort(a, 0, n - 1);

		// 병합 정렬된 배열 원소 출력
		for (int k = 0; k < n; k++) {
			System.out.print(a[k] + " ");
		}

		sc.close();
	}

	// 병합 정렬하는 메소드
	public static void mergeSort(double a[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2; // q는 중간 지점
			mergeSort(a, p, q); // 전반부 정렬을 재귀적으로 호출
			mergeSort(a, q + 1, r); // 후반부 정렬을 재귀적으로 호출
			merge(a, p, q, r); // 전반부와 후반부 병합

		}

	}

	// 두 부분을 병합하는 메소드
	public static void merge(double a[], int p, int q, int r) {

		int i = p; // 전반부 부분 배열의 시작 인덱스
		int j = q + 1; // 후반부 부분 배열의 시작 인덱스
		int t = 0; // 임시 배열의 인덱스

		double[] tmp = new double[r - p + 1]; // 배열 a와 동일한 크기의 임시배열 생성

		// 두 부분 배열의 원소를 비교해 오름차순으로 정렬해, 임시 배열에 저장
		while ((i <= q) && (j <= r)) {
			if (a[i] <= a[j])
				tmp[t++] = a[i++];
			else
				tmp[t++] = a[j++];
		}

		// 반복문이 끝나고 전반부 배열에 남은 원소가 있으면 임시 배열에 추가
		while (i <= q) {
			tmp[t++] = a[i++];
		}

		// 반복문이 끝나고 후반부 배열에 남은 원소가 있으면 임시 배열에 추가
		while (j <= r) {
			tmp[t++] = a[j++];
		}

		// 임시 배열의 원소들을 원본 배열에 복사
		i = p;
		t = 0;
		while (i <= r) {
			a[i++] = tmp[t++];
		}

	}
}
