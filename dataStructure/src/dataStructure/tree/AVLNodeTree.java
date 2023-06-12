package dataStructure.tree;

public class AVLNodeTree {
    private AVLNode root;
    
    // 깊이 찾기 (+업데이트?)
    private int getHeight(AVLNode x) {   	
        int leftChildHeight = (null != x.left) ? x.left.height : -1;
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
    
}