package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

// 이진 탐색 트리
public class BinarySearchTree {
	Node root;
	
	public void add(int key) {
		Node newNode = new Node();
		newNode.key = key;
		if(root == null) {
			root = newNode;
		} else {
			insertNode(newNode);
		}
	}
	
	private void insertNode(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node parentNode = queue.poll();
			
			// 우선 부모 노드와 비교 => 일단은 무조건 노드에 값이 있는 가정으로 간다.
			if (parentNode.key > node.key) { // 왼졲 노드로 가는 경우
				if(parentNode.left == null) {
					parentNode.left = node;
					break;
				} else {
					queue.add(parentNode.left);
					//break;
					/*
					 * break가 잘 안먹히는 이유 설명 , break 문의 사용
					 *  break 문은 현재 실행 중인 제어문(예: for, while, do-while, switch)에서 빠져나오는데 사용됩니다. 특히, break가 중첩된 제어문에서 사용될 때 한 단계의 제어문만 빠져나옵니다.
					 *	if 문 내부에서 break를 사용하면, if 문 자체에 영향을 끼치지 않습니다. 대신, break가 포함된 현재 실행 중인 가장 가까운 반복문(여기서는 while 문)을 종료합니다.						
					 *	예제에서의 break 사용은 다음과 같은 흐름을 갖습니다:
					 *	while 문은 큐가 비어있지 않은 동안 반복됩니다.
					 *	if 문 내부에서 새 노드를 왼쪽 또는 오른쪽에 추가했거나, 왼쪽 또는 오른쪽 자식 노드를 큐에 추가한 후에 break를 실행합니다.
					 *	break가 실행되면, 현재 실행 중인 while 문을 종료하고 while 문 다음의 코드로 이동합니다.
					 *	이렇게 하면, 새 노드가 추가되거나 자식 노드가 큐에 추가되면 while 문이 종료되어 다음 노드의 처리가 가능합니다.
					 *
					 */
				}
			} else { // 오른쪽 노드로 이동
				if(parentNode.right == null) {
					parentNode.right = node;
					break;
				} else {
					queue.add(parentNode.right);
					//break;
				}
			}
			
		}
		
	}
}
