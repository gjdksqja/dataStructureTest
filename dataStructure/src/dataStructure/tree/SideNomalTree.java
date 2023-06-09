package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SideNomalTree {
    Node root;

    public void add(int key) {
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node();
        newNode.key = key;
        if (null == root) {
            root = newNode;
        } else {
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node parentNode = queue.poll();
                if (null != parentNode.left) {
                    queue.offer(parentNode.left);
                } else {
                    parentNode.left = newNode;
                    break;
                }
                if (null != parentNode.right) {
                    queue.offer(parentNode.right);
                } else {
                    parentNode.right = newNode;
                    break;
                }
            }
        }
    }
    
    private void visit(Node node) {
        System.out.println("방문 : " + node.key);
    }
    
    // 탐색 방법 ::  너비 우선 탐색
    
    public void levelTraversal() {
    	System.out.println("너비 우선 탐색 시작");
    	levelOrder(); 
    	System.out.println("너비 우선 탐색 완료");
    }
    
    
    // 2진 트리 임으로 2의 N승만큼의 자식이 생김 => 그때마다 적용되는 형태의 분기문이 필요
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	/*
        	 *  A  : 0레벨 (root)
        	 *  -> (A) B C : A의 자식 : 1레벨 
        	 *  -> (B) C : 기존 / D E : B 자식 ->  (C) / D E  F G : C 자식 및 2 level 전부 다 모임 
        	 *  -> (D) E F G : 2 level / H I : 2 level 첫번째 자식 -> (E) F G / H I J K -> (F) G / H I J K L M ....
        	 */
            Node parentNode = queue.poll();
            visit(parentNode);
            if (null != parentNode.left) {            	
                queue.offer(parentNode.left);
            }
            if (null != parentNode.right) {
                queue.offer(parentNode.right);
            }
        }
    }
    
}
