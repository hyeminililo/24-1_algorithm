package hw8_1;

import java.util.Scanner;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("hw8_1 : 남궁혜민");
		Scanner input = new Scanner(System.in);

		// 원소 수 입력
		int n = input.nextInt();

		// 사용자가 원하는 갯수의 원소를 갖는 상호배타적 집합 Myset 객체를 생성
		MySet set = new MySet(n);

		// 사용자가 원하는 횟수의 union 연산을 수행
		int m = input.nextInt();
		for (int i = 0; i < m; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			set.union(x, y); // 두 원소를 합치는 union 연산 수행
		}

		// 모든 원소에 대한 부모 출력을 통해 트리 구조 확인
		set.printParent();

		// 모든 원소에 대해 findSet 연산 수행하여 경로 압축 확인
		for (int x = 0; x < n; x++) {
			set.findSet(x);
		}

		// 경로 압축 후 모든 원소의 부모를 출력하여 트리 구조 확인
		set.printParent();

		input.close();
	}
}

class MySet {
	private int n; // 집합의 원소 개수
	private int parent[];

//	 생성자 ( 원소 n개를 가진 집합 객체 초기화 및 각 원소에 대해 makeSet 연산 수행 
	public MySet(int n) {
		this.n = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			makeSet(i);
		}
	}

	// x 하나로 이루어진 집합을 만드는 메서드
	public void makeSet(int x) {
		parent[x] = x; // 자신을 부모로 설정
	}

	// x의 대표 원소를 찾는 메서드, 경로압축 사용
	public int findSet(int x) {
		if (x != parent[x]) {
			parent[x] = findSet(parent[x]); // x의 부모를 x의 최종 대표 원소로 설정
		}
		return parent[x];

	}

	// x와 y가 속한 집합을 합치는 메서드, x의 대표 원소가 최종 대표 원소가 되도록 구현
	public void union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot; // y의 대표 원소를 x의 대표 원소로 설정
		}
	}

	// 모든 원소의 부모(또는 대표 원소)를 출력
	public void printParent() {
		for (int i = 0; i < n; i++) {
			System.out.print(parent[i] + " "); // 각 원소의 부모 출력
		}
		System.out.println("");
	}
}
