package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLNodeTree {
    private AVLNode root;
    
    // 깊이 찾기 (+업데이트?)
    private int getHeight(AVLNode x) {   	
        int leftChildHeight = (null != x.left) ?      x.left.height : -1;
        int rightChildHeight = (null != x.right) ? x.right.height : -1;
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }
    
    
    // 균형도 계산
    private int getBalance(AVLNode x) {
        /**
         * 균형도 = 좌촉 노드 높이 - 우측 노드 높이
         * 만약에 노드가 없으면 높이를 -1로 계산
         */
        int leftChildHeight = (null != x.left) ? x.left.height : -1;
        int rightChildHeight = (null != x.right) ? x.right.height : -1;
        return leftChildHeight - rightChildHeight;
    }
    
    private void changeHeight(AVLNode x) {
    	x.height = getHeight(x);
    }
    
    // 회전도 계산
    private AVLNode rotate(AVLNode x) {
        /**
         * 균형도가 2, 1 이면 좌측 서브트리 비대, -2, -1 이면 우측 서브트리 비대를 의미한다
         * x 노드의 균형도가 2 이면 왼쪽 자식의 균형도를 알아본다.
         * 1) 왼쪽 자식의 균형도가 0, 1 이면 (LL)
         * 2) 왼쪽 자식의 균형도가 -1 이면 (LR)
         * x 노드의 균형도가 -2 이면 오른쪽 자식의 균형도를 알아본다.
         * 1) 오른쪽 자식의 균형도가 1 이면 (RL)
         * 2) 오른쪽 자식의 균형도가 0, -1 이면 (RR)
         */
        int xNodeBalance = getBalance(x);

        // TODO : 균형도의 절대값이 2 이상이면 회전
        if (Math.abs(xNodeBalance) >= 2) {
        	// -- 해당 노드의 하부 노드들을 수정하고 그걸 반환 함
        	if( xNodeBalance> 1 && 0 <= getBalance(x.left) ) {
        		// LL :: 왼쪽 비대
                // TODO : 좌측 서브트리가 더 비대하다. 그리고 왼쪽 자식의 균형도가 0 또는 1이다.
                // TODO : LL 회전
                x = LL_rotate(x);
        	} else if (xNodeBalance > 1 && -1 == getBalance(x.left)) {
        		// LR		
                // TODO : 좌측 서브트리가 더 비대하다. 그리고 왼쪽 자식의 균형도가 -1 이다.
                // TODO : LR 회전
                x = LR_rotate(x);
            } else if (xNodeBalance < -1 && 0 >= getBalance(x.right)) {
            	// RR
                // TODO : 우측 서브트리가 더 비대하다. 그리고 우측 자식의 균형도가 0 또는 -1이다.
                // TODO : RR 회전
                x = RR_rotate(x);
            } else if (xNodeBalance < -1 && 1 == getBalance(x.right)) {
            	// RL
                // TODO : 우측 서브트리가 더 비대하다. 그리고 우측 자식의 균형도가 1이다.
                // TODO : RL 회전
                x = RL_rotate(x); 	
        	}
        }
    	
    	return x;
    }
    
    // add
    
    // remove
    
    // 회전 작업
    private AVLNode LL_rotate(AVLNode p) { // x가 현재 부모 노드라면 
    	/*
    	 * 부모 노드를 좌측 자식 노드의 우측으로 바꾼다 (기존 우측 노드는 바뀐 우측 노드의 왼쪽으로)
    	 * 좌측 자식 노드는 부모 노드가 된다. 
    	 */
    	
    	AVLNode L = p.left;
    	AVLNode LR =  L.right;
    	
    	L.right = p;
    	p.left = LR;
    	
    	// 변경된 height를 계산  --> 해당 노드의 하위 height들에는 아무 변화가 없음으로 이 함수 그냥 쓰면 됨.
    	changeHeight(p);
    	changeHeight(L);
    	
    	return L;
    }
    private AVLNode LR_rotate(AVLNode x) {
        // TODO : 좌측 서브트리가 더 비대하다. 그리고 왼쪽 자식의 균형도가 -1 이다.
        // TODO : LR 회전
        x.left = RR_rotate(x.left);
    	
    	return x;
    }
    private AVLNode RL_rotate(AVLNode x) {   	
        // TODO : 우측 서브트리가 더 비대하다. 그리고 우측 자식의 균형도가 1이다.
        // TODO : RL 회전
        x.right = LL_rotate(x.right);
        x = RR_rotate(x);
        
        return x;
    }
    private AVLNode RR_rotate(AVLNode P) {
    	AVLNode R = P.right;
    	AVLNode RL = R.left;
        R.left = P;
        P.right = RL;

        // TODO : 높이가 영향 받는건 이전 부모 노드와 새로운 부모 노드 뿐이다.
        changeHeight(P);
        changeHeight(R);

        // TODO : 회전 후 새로운 부모 노드를 반환한다.
        return R;
    }    
    
    //재귀 함수여야 한다
    public AVLNode addData(AVLNode node, int key) {        
        // 등록 하면서 바로 Rotate가 필요함  => 리턴되면서 모든 로드가 rotate3 대상이 됨
 
        // 넣으면서 height는 같이 넣어줘야 한다.
        if (null == root) {
        	node.height = 1;
            root = node;
            return root;
        } else {
        	// Rotate => 일단 넣고 rotate를 돌리는게 맞는듯 
            // Rotate 대상? 그리고 언제까지? 균형도가 맞을때까지 
            // 이때 부모 상태에선 맞는데 아래 자식 상태에선 안 맞을 경우가 있을까?
        	
        	/**
             * 여기선 기존의 queue 방식이 아닌 그냥 기본적인 node 좌우 검색을 쓰자.
             * 그렇게 해야 넣고 바로 height 관리와 균형도 검사가 쉬움
             */
        	
        	// 이진트리 검색부 
            if (key < node.key) {
            	if(node.left == null) {            		
            		AVLNode newNode = new AVLNode();
            		newNode.key = key;
            		newNode.height = 0;
            		node.left = newNode;
            		
            		changeHeight(node);
            		
            	} else {
            	   node.left = addData(node.left,key);
            	}
            } else if (key > node.key) {    
            	if(node.right == null) {            		
            		AVLNode newNode = new AVLNode();
            		newNode.key = key;
            		newNode.height = 0;
            		node.right = newNode;
            		changeHeight(node);
            		
            	} else {
            		node.right = addData(node.right,key);
            	}
            } else {
            	// 중복된 키는 트리에 추가하지 않습니다
            	return node;
            }	
        }
        // 항상 rotate로 마무리하며 되돌아가기 전에 계속 확인
        // :: 더할때나 더한 이후 돌아올때나 한결같이 해줘서 향상성 유지
        return rotate(node);
    }
    
    // 삭제 시 오른쪽에서 제일 작은 놈을 찾음.
    private AVLNode findMin(AVLNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
    
    // 제거시마다 rotate 시켜줘야 함 이것도 -- 재귀
    public AVLNode removeNode(AVLNode node, int key ) {
        if (null == root) {
        	// 없음.
            return null;
        } else if(node.key == key ) {
            // node.key = key, 같음 = 삭제 대상
            /*
             * 1. leaf, height가 0 인경우는 지워버림
             * 2. 자식이 있으면 대체를 시켜야함.
             *  2-1. 하나의 자식이면 그 자식 사용
             *  2-2. 두개 다 있으면 왼쪽에서 젤 큰놈이나 오른쪽에서 젤 작은놈과 바꿔야 함.
             */

            // 1. No child case
            if(node.left == null && node.right == null) {
                node = null;
            } 
            // 2. One child case
            else if(node.right == null) {
                node = node.left;
            } else if(node.left == null) {
                node = node.right;
            } 
            // 3. Two children case
            else {
                // Find the minimum value node from the right subtree
                AVLNode temp = findMin(node.right);
                // Replace the value of the node to be deleted with the found minimum value
                node.key = temp.key;
                // Delete the minimum value node from the right subtree
                node.right = removeNode(node.right, temp.key);
            }
        } else {
            if (key < node.key) {
            	if(node.left != null) {
            		node.left = removeNode(node.left,key);
            	}
            }else if(key > node.key) {
            	if(node.right != null) {
            		node.right = removeNode(node.right,key);
            	}            	
            }
        }
        
    	return rotate(node);
    }
    
    private void printHelper(AVLNode x, String indent, boolean last) {
        if (x != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key + "(h:" + x.height + ")");
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }    

    public void printTree() {
        printHelper(this.root, "", true);
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(AVLNode node) {
        // TODO : 중위 순회
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inorderTraversal(node.right);
    }   
}
