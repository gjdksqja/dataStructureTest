package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {
    Node root;

    public void addData(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (null == root) {
            root = newNode;
        } else {            
            /* 
             * 노드 탑색을 이용하여 추가 할 것인가 말 것인가를 정한다 // 재귀 응용이라고 볼 수 있음.
             */ 
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root); // 삽입, add와 비슷 => 최초의 노드를 Queue에 삽입
            
            // Queue가 완전히 빌고 작업이 끝나야 멈춘다 ===> 비자 말자 멈추는게 아님
            while(!queue.isEmpty()) {            	            	 
            	/* 
            	 * 최초의 노드가 꺼내질때 Queue는 빌 것이다. 그러나 이게 작업의 끝은 아니다
            	 * 위에서부터 자식을 하나씩 확인, 젤 아랫단위의 자식은 자식이 없으므로 꺼내지기만 하다가 종료됨.
            	 */
            	Node parentNode = queue.poll();
            	
            	if (parentNode.left == null ) { 
            		parentNode.left = newNode; // 왼쪽에 새 노드 삽입 ==> 새로 삽입 되었음. 
            								   // 해당 노드는 Queue에 넣어서 다시 확인 할 필요가 없음
            		break;
            	} else {
            		queue.add(parentNode.left); // 이미 데이터가 있다고 판단하면 탐색해 볼 노드로 본다.
            	}
            	
            	if (parentNode.right == null ) { 
            		parentNode.right = newNode; // 왼쪽에 새 노드 삽입 ==> 새로 삽입 되었음. 
            								    // 해당 노드는 Queue에 넣어서 다시 확인 할 필요가 없음
            		break;
            	} else {
            		queue.add(parentNode.right); // 이미 데이터가 있다고 판단하면 탐색해 볼 노드로 본다.
            		
            	}            	
            	            	
            }
        }
    }
    
    private void visit(Node node) {
        System.out.println("방문 : " + node.key);
    }
    
    // 탐색 방법 ::  전위,중위,후위
    
    public void preOrderTraversal() {
        // TODO : 전위 순회
    	System.out.println("전위 순회 시작");
        preOrder(root);
        System.out.println("전위 순회 완료");
    }
    
    private void preOrder(Node parent) {
        if (null == parent) {
            return;
        }
        visit(parent);
        preOrder(parent.left);
        preOrder(parent.right);
    }
    
    public void inOrderTraversal() {
        // TODO : 중위 순회
    	System.out.println("중위 순회 시작");
    	inOrder(root);
        System.out.println("중위 순회 완료");
    }
    
    private void inOrder(Node parent) {
    	if (null == parent.left) {
            return;
        }
    	
        inOrder(parent.left);
        visit(parent);        
        inOrder(parent.right);
    }    
    
    public void postTraversal() {
        // TODO : 후위 순회
    	System.out.println("후위 순회 시작");
    	postOrder(root);
        System.out.println("후위 순회 완료");
    }
    
    void postOrder(Node parent) {
        if (null == parent) {
            return;
        }
        postOrder(parent.left);
        postOrder(parent.right);
        visit(parent);
    }   
}
