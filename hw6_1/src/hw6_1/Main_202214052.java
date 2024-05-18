package hw6_1;

public class Main_202214052 {
	// main 클래스
	public static void main(String args[]) {
		System.out.println("hw6_1:남궁혜민");

		// 연산에 사용할 키값 배열 초기화
		int[] addList = { 13, 6, 2, 10, 1, 5, 7, 11, 4, 3, 8, 9, 3, 6, 10, 13 };
		int[] searchList = { 12, 3, 6, 10, 13 };
		int[] removeList = { 12, 3, 6, 10, 13, 2, 1, 5, 4, 7, 8, 9, 11 };

		// 정수 키값을 저장할 공백 이진검색트리 tree 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();

		// addList에 저장된 키값들을 차례대로 트리에 삽입
		for (int i = 0; i < addList.length; i++) {
			tree.add((addList[i]));
		}

		// tree를 중순위 순회하여 키 값을 출력
		tree.inorder();

		// searchList에 저장된 키 값들을 차례대로 트리에서 검색하여 결과 출력
		for (int i = 0; i < searchList.length; i++) {
			System.out.print(tree.contains(searchList[i]) + " ");
		}
		System.out.println();

		// tree의 키값 합을 구하여 출력
		System.out.println(tree.sum());

		for (int i = 0; i < removeList.length; i++) {
			tree.remove((removeList[i]));
		}

		// tree를 중순위 순회하여 키값을 출력
		tree.inorder();

		// tree의 키값 합을 구하여 출력
		System.out.println(tree.sum());
	}
}

// 정수형 키값을 저장하는 이진검색트리 클래스
class MyBinarySearchTree {
	// 루트 노드를 가리키는 인스턴스 변수 root
	private Node root = null;

	// 노드의 구조를 정의하는 클래스
	private class Node {
		int key; // key 값
		Node left; // key 보다 작은 값의 node
		Node right; // key 보다 큰 값의 node
	}

	// key 값을 매개변수로 받아 root가 가리키는 트리에 삽입.
	public void add(int key) {
		root = treeInsert(root, key); // private treeInsert 호출
	}

	// 매개변수 없이 root가 가리키는 전체 트리를 중순위 순회하는 메소드
	public void inorder() {
		System.out.print("( ");
		inorder(root); // private inorder 호출
		System.out.println(")");
	}

	// key 값을 매개변수로 받아 트리에 존재하는지 여부(true/false)를 리턴
	public boolean contains(int key) {
		Node t = root; // 현재 검사 중인 노드를 루트로 시작
		while (t != null) { // 현재 노드가 null이 아닐 때까지 반복
			if (key < t.key) { // 찾으려는 키 값이 현재 노드의 키 값보다 작으면 왼쪽 서브트리로 이동
				t = t.left;
			} else if (key > t.key) { // 찾으려는 키 값이 현재 노드의 키 값보다 크면 오른쪽 서브트리로 이동
				t = t.right;
			} else { // 찾고자 하는 키 값이 현재 노드의 키 값과 같으면 true 반환
				return true;
			}
		}
		// 트리 전체를 순회했지만 찾고자 하는 키 값을 가진 노드를 찾지 못한 경우 false 반환
		return false;
	}

	// 매개변수 없이 트리 전체의 키 값 합을 구하여 리턴. private sum 호출
	public int sum() {
		return sum(root);
	}

	// 매개변수로 받은 키값을 트리에서 삭제. 키값이 없으면 삭제하지 않으면 됨. private treeDelete 호출 public void
	public void remove(int key) {
		Node p = null; // 부모 노드 설정
		while (root != null) {

			if (root.key == key) {
				break; // 삭제할 노드를 만나면 break
			}

			p = root; // 부모 노드를 현재 탐색 노드로 설정

			// root의 key 값 보다 작으면 왼쪽 노드로 이동
			if (key < root.key) {
				root = root.left;
			}

			// root의 key 값 보다 크면 오른쪽 노드로 이동
			if (key > root.key) {
				root = root.right;
			}
		}
		// root의 값이 null이면 공백 트리 이므로 아무 것도 하지 않음
		if (root == null) {
			return;
		}
		// 찾은 노드 삭제
		treeDelete(root, p);

	}

	// 루트 t와 key 값을 매개변수로 받아 t를 루트로 하는 트리에 key를 삽입하는 재귀 메소드
	private Node treeInsert(Node t, int key) {
		if (t == null) {
			Node r = new Node(); // t가 null 값일 때 r을 루트로 하는 새로운 노드 생성
			r.key = key;
			return r;
		}
		if (key < t.key) { // t.key보다 작으면 t.left를 루트로 하는 treeInsert 재귀 호출
			t.left = treeInsert(t.left, key);
			return t;
		}
		if (key > t.key) { // t.key보다 크면 t.right를 루트로 하는 treeInsert 재귀 호출
			t.right = treeInsert(t.right, key);
			return t;
		} else { // key == t.key 즉, 이미 존재하는 키값인 경우
			return t;
		}
	}

	// 루트 t를 매개변수로 받아 t를 루트로 하는 트리를 중순위 순회하는 재귀 메소드
	private void inorder(Node t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.key + " ");
			inorder(t.right);
		}
	}

	// 루트 t를 매개변수로 받아 t를 루트로 하는 트리의 키값 합을 구하여 리턴하는 재귀 메소드
	private int sum(Node t) {
		if (t == null)
			return 0;
		int sumResult = t.key + sum(t.left) + sum(t.right);
		return sumResult;
	}

	// 부모 노드가 p인 노드 r을 트리에서 삭제.
	private void treeDelete(Node r, Node p) {

		// deleteNode를 호출하여 삭제 후 새 노드로 대체
		if (p == null) { // 루트 노드인 경우
			root = deleteNode(r);
		}
		// r이 p의 왼쪽 자식인 경우 ( r < P )
		if (p.left == r) {
			p.left = deleteNode(r);
		}
		// r이 p의 오른쪽 자식인 경우 ( r > P )
		if (p.right == r) {
			p.right = deleteNode(r);
		}
	}

	// 노드 r을 삭제하고 r을 대신할 노드를 리턴
	private Node deleteNode(Node r) {
		if (r.left == null) {
			return r.right;
		}
		if (r.right == null) {
			return r.left;
		} else {
			// r보다 큰 값 중 가장 작은 minNode 설정
			Node minNode = r.right; // r의 오른쪽 서브트리에서 가장 왼쪽에 위치
			Node parentMin = r;

			while (minNode.left != null) {
				parentMin = minNode;
				minNode = minNode.left;
			}

			// 트리를 계속 내려가면서 r의 오른쪽 서브트리에서 가장 작은 값 찾기
			if (parentMin != r) {
				parentMin.left = minNode.right;
				minNode.right = r.right;
			}
			// minNode의 왼쪽 자식을 r의 왼쪽 자식으로 설정한다.
			minNode.left = r.left;

			return minNode; // r보다 큰 값 중 가장 작은 값 리턴
		}
	}

}
