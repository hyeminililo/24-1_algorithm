package hw10_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_202214052 {

	private static int[] parent; // 정점의 부모 정점을 저장하는 배열 
	private static int[] rank; // 정점의 랭크를 저장하는 배열 (트리의 깊이를 낮게 해 , 검색시간 최적화하기 위해 사용 )
	private static int[][] graph; // 그래프의 모든 간선을 저장하는 2차원 배열 

	// 최소신장트리의 간선 목록을 저장하기 위한 배열리스트 선언
	private static ArrayList<int[]> mstEdges;

	public static void main(String[] args) {

		System.out.println("hw10_1 : 남궁혜민");
		Scanner input = new Scanner(System.in);

		int n = input.nextInt(); // 정점 수 n 입력 받기
		int e = input.nextInt(); // 간선 수 e 입력 받기

		// e행 3열 이차원 배열 선언 (v1,v2,weight)
		graph = new int[e][3];

		// 정점 수 크기로 배열 선언
		parent = new int[n];
		rank = new int[n];

		// 최소신장트리
		mstEdges = new ArrayList<>();
		
		// 정점쌍과 가중치 입력받기
		for (int i = 0; i < e; i++) {
			for (int j = 0; j < 3; j++) {
				graph[i][j] = input.nextInt();
			}
		}

		// 가중치를 기준으로 간선들을 오름차순으로 정렬
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		// 모든 정점에 대해 부모를 자기 자신으로 초기화
		for (int i = 0; i < n; i++) {
			makeSet(i);
		}

		// for문을 이용해, 정점, 가중치 설정하면서, 최소신장트리 구하기
		for (int i = 0; i < e; i++) {
			int v1 = graph[i][0];
			int v2 = graph[i][1];
			int weight = graph[i][2];

			// findSet() 메소드를 이용해서, v1과 v2의 부모 원소 찾기
			int setV1 = findSet(v1);
			int setV2 = findSet(v2);

			// 정점 v1과 v2가 다른 집합에 속해있을 경우에만 간선 선택(사이클을 형성하지 않을 때)
			if (setV1 != setV2) {
				union(setV1, setV2);
				mstEdges.add(new int[] { v1, v2, weight });
			}

			// 최소신장트리의 간선 수가 n-1이 되면 종료
			if (mstEdges.size() == n - 1) {
				break;
			}
		}

		// 최소신장트리 출력
		for (int[] edge : mstEdges) {
			System.out.print("(");
			System.out.print(Arrays.toString(edge));
			System.out.print("),");
		}
		input.close(); // Scanner 객체 닫기
	}

	// 단 하나의 정점만으로 구성된 n개의 집합을 초기화
	public static void makeSet(int x) {
		parent[x] = x;
		rank[x] = 0;
	}

	// x의 대표 원소를 찾는 메서드, 경로압축 사용
	public static int findSet(int x) {
		if (x != parent[x]) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}

	// 각각의 정점이 속한 집합 2개를 하나의 집합으로 합치는 메소드
	public static void union(int v1, int v2) {
		int rootX = findSet(v1);
		int rootY = findSet(v2);

		if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		} else {
			parent[rootX] = rootY;
			if (rank[rootX] == rank[rootY]) {
				rank[rootY]++;
			}
		}
	}
}
