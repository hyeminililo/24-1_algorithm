## 구현할 기능 목록
- Main 클래스 
  - [] 연산에 사용할 키값 배열 초기화 
  - [] 정수 키값을 저장할 공백 이진검색트리 tree를 생성
  - [] addList에 저장된 키값들을 차례대로 트리에 삽입 
  - [] tree를 중순위 순회하여 키값들을 출력 
  - [] searchList에 저장된 키값들을 차례대로 트리에서 검색하여 결과 출력 
  - [] tree의 키값 합을 구하려 출력
  - [] removeList에 저장된 키값들을 차례대로 트리에서 삭제 
  - [] tree를 중순위 순회하여 키값을 출력
  - [] tree의 키 값을 구하려 출력


- BinarySearch 클래스 
  - 정수형 키값을 저장하는 이진검색트리 클래스 
  - 루트 노드를 가리키는 인스턴스 변수 root
  - 노드의 구조를 정의하는 클래스 Node - key, left, right 필드로 구성 
  - public 메소드
    - add :  key 값을 매개변수로 받아 root가 가리키는 트리에 삽입. private treeInsert 호출
    - inorder : 매개변수 없이 root가 가리키는 전체 트리를 중순위 순회. private inorder 호출
    - contains :  key 값을 매개변수로 받아 트리에 존재하는지 여부(true/false)를 리턴
    - sum : 매개변수 없이 트리 전체의 키값 합을 구하여 리턴. private sum 호출
    - remove :   매개변수로 받은 키값을 트리에서 삭제. 키값이 없으면 삭제하지 않으면 됨. private treeDelete 호출 **** 선택 과제
  - private 메소드 :  public 메소드 구현을 보조하는 메소드들
    - treeInsert :  루트 t와 key 값을 매개변수로 받아 t를 루트로 하는 트리에 key를 삽입하는 재귀 메소드
    - inorder :  루트 t를 매개변수로 받아 t를 루트로 하는 트리를 중순위 순회하는 재귀 메소드
    - sum :  루트 t를 매개변수로 받아 t를 루트로 하는 트리의 키값 합을 구하여 리턴하는 재귀 메소드
    - treeDelete :  부모 노드가 p인 노드 r을 트리에서 삭제. deleteNode 호출 **** 선택 과제
    - deleteNode : 노드 r을 삭제하고 r을 대신할 노드를 리턴 **** 선택 과제

## 요구 사항 
- [] 정수값을 저장하는 이진트리 클래스 정의 
- [] 자바에서 제공하는 트리 클래스 이용하지 않기 
- [] tree 키 값 합을 구할 때 배열 원소를 더하여 구하면 안 됨 
