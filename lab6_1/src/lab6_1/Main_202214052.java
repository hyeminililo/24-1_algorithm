package lab6_1;

public class Main_202214052 {
	public static void main(String[] args) {
		System.out.println("lab6_1:남궁혜민");

		// (1) 연산에 사용할 키값 배열 초기화
		int[] addList = { 13, 6, 2, 10, 1, 5, 7, 11, 4, 3, 8, 9, 3, 6, 10, 13 };

		// (2) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();

		// (3) addList에 저장된 키값들을 차례대로 트리에 삽입
		for (int i = 0; i < addList.length; i++) {
			tree.add((addList[i]));
		}

		// (4) tree를 중순위 순회하여 키값을 출력
		tree.inorder();
	}
}

// 정수 키값을 갖는 이진검색트리를 구현하는 클래스
class MyBinarySearchTree { // private Node root =null;
	private Node root = null; // (가)
	// (가)________________________ // 루트 노드를 가리키는 인스턴스 변수 root
	// 노드의 구조를 정의하는 클래스

	private class Node {
		int key;
		Node left;
		Node right;
	}

	// 트리를 중순위 순회하는 public 메소드 - 구현 세부사항을 알지 못해도 호출할 수 있음
	public void inorder() {
		System.out.print("( ");
		inorder(root);
		System.out.println(")");
	}

	// t를 루트로 하는 트리를 중순위 순회하여 키값 출력 - 매개변수(루트노드 t)로 인해 구현 세부사항을 알아야 호출할 수 있으므로
	// private 메소드로 따로 두었음
	private void inorder(Node t) {
		if (t != null) {
			inorder(t.left); // (나)
			// (나) _____________________
			System.out.print(t.key + " ");
			inorder(t.right); // (다)
			// (다) _____________________

		}
	}

	// 매개변수로 받은 키값을 트리에 삽입 - 구현 세부사항을 알지 못해도 호출할 수 있음
	public void add(int key) {
		root = treeInsert(root, key);
	}

	// t를 루트로 하는 트리에 key를 삽입하고 삽입 후 루트 노드를 리턴 - 매개변수(루트노드 t)로 인해 구현 세부사항을 알아야 호출할 수
	// 있으므로 private 메소드로 따로 두었음 => 재귀메소드
	private Node treeInsert(Node t, int key) {
		if (t == null) {
			Node r = new Node();
			r.key = key;
			return r;
		} else if (key < t.key) {
			t.left = treeInsert(t.left, key); // (라)
			// (라)_________________________________
			return t;
		} else if (key > t.key) {
			t.right = treeInsert(t.right, key); // (마)
			// (마)__________________________________
			return t;
		} else { // key == t.key 즉, 이미 존재하는 키값인 경우
			return t; // (바)
			// (바)_________________________________
		}
	}
}