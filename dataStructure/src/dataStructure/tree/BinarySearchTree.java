package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

// 이진 탐색 트리
public class BinarySearchTree {
	Node root;
	
	public void printNode(Node node) {
		System.out.print(node);
	}
	
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
	/*
	 * 시간 복잡도
	 * 이진 탐색 트리(Binary Search Tree, BST)의 시간 복잡도가 logN인 이유는 트리의 구조 때문입니다. 
	 * 각 노드는 최대 두 개의 자식 노드를 가질 수 있고, 왼쪽 자식 노드는 부모 노드보다 작은 값을 가지며, 오른쪽 자식 노드는 부모 노드보다 큰 값을 가집니다.
	 * 이진 탐색 트리에서 값을 찾거나 추가하거나 삭제할 때, 트리의 높이에 따라 시간이 걸립니다. 
	 * 트리가 균형 잡혀 있을 때, 트리의 높이는 log₂(N)이며, 여기서 N은 트리에 있는 노드의 개수입니다. 이 때, 시간 복잡도는 O(logN)이 됩니다.
	 * 예를 들어, 이진 탐색 트리에서 값을 찾는 과정에서, 매번 탐색 범위가 절반으로 줄어들기 때문에 빠르게 원하는 값을 찾을 수 있습니다.
	 * 
	 * => 결국 탐색은 log₂(N)에 수렴함
	 */
	
    public Node search(int key) {
        Node searchNode = getData(root, key);
        
        if(searchNode == null) {
        	System.out.println("notFound");
        }else {        	
        	System.out.println("Find : " +  searchNode.key);
        }
        return searchNode;
        
    }
	
	// 탐색
	private Node getData(Node node, int key) { // 검색 key 값
		
		Node searchNode = null;
		if(node == null ) {
			return searchNode;
		}
		
		if(node.key == key) {			
			return searchNode = node;
		}
		if(node.key > key ) {
			searchNode = getData(node.left , key);
		} else if (node.key < key) {
			searchNode = getData(node.right , key);
		}
		return searchNode;
	}
		
	// 삭제) 왼쪽 노드중 가장 큰 키와 오른쪽으로 가장 큰 키 값을 구한다. 
	// => 이른 해당 위치의 노드와 변경한다. 이번에는 key를 찾아낸 노드것으로 바꾸고 찾아낸 node는 삭제 시키자.
	public void removeNode(int key) {
		Node updateNode =  search(key);
		
		//printNode(updateNode);
		
		if(updateNode == null) {
			System.out.println("삭제하려는 노드가 없습니다.");
			return;
		}
		
		// 왼쪽 --      가장 큰
		// 1.if getLagestNode, 
		// 2.change updateNode and, 
		// 3.you play to go LagestNode's Parent and change that's right Node Null
		//   3-1. if largestNode.left is not null , largestNode.left adjust parent Node
		if(updateNode.left != null ) {			
			updateNode.key = getLargestNode(updateNode.left).key;
			Node adjustNode = getData(updateNode.left, updateNode.key);
			if(adjustNode.left != null) {
				int adjustNodeleftKey = adjustNode.left.key;
				adjustNode.key = adjustNodeleftKey;
				adjustNode.left = null;
				
			} else {
				adjustNode = null;
			}
		}else {
			updateNode = null;
		}
		
		System.out.println("삭제 완료");
		
		// 오른쪽 -- 가장 작은 --> 어차피 둘 중에 하나 아무거나 써도 됨으로 하나만 살린다
//        if (updateNode.right != null) {
//            updateNode.key = getSmallestNode(updateNode.right).key;
//            Node adjustNode = getData(updateNode.right, updateNode.key);
//            if (adjustNode.right != null) {
//                int adjustNoderightKey = adjustNode.right.key;
//                adjustNode.key = adjustNoderightKey;
//                adjustNode.right = null;
//            } else {
//                adjustNode = null;
//            }
//        } else {
//            updateNode = null;
//        }		
		
	}
	
	/*
	 * node : 탐색 노드
	 */
	private Node getLargestNode(Node node) { 
		
		// 첫시작은 deleteNode의 왼쪽임 -> 이 후 오른쪽으로 계속 이동 하면서 결과를 찾다가, 없으면 해당 노드가 제일 큼		
		if(node.right == null) {
			return node;
		}
		
		return getLargestNode(node.right); 
	}
	
	private Node getSmallestNode(Node node) { 
	    if(node.left == null) {
	        return node;
	    }
	    return getSmallestNode(node.left); 
	}
}
