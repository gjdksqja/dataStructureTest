package dataStructure;

public class GeneticSinglyLinkedList<T> {
	GeneticNode<T> head; // 첫번째 노드
	int size = 0; // 크기
	
	
	public GeneticNode<T> findNode(int searchIndex) {
		// head에서 부터 하나씩 넘어가면서 찾아가야 함
		
	    /**
	     * 찾는 노드의 index가 음수거나
	     * 노드의 개수보다 많거나 같으면 예외를 발생시킨다.
	     */
	    if (0 > searchIndex || size <= searchIndex) {
	        throw new ArrayIndexOutOfBoundsException();
	    }
		
	    int nodeIndex = 0;
	    GeneticNode<T> pointer = head; // 처음부터 확인
	    
	    /**
	     * 찾는 노드의 index와 노드의 순서가 동일할 때 까지
	     * 노드의 참조값을 이용하여 이동한다.
	     */
	    while (nodeIndex != searchIndex) {
	        ++nodeIndex;
	        pointer = pointer.next;
	    }
	    
	    return pointer;
	}	
		
	public void add(int index, T data) { 
		GeneticNode<T> node = new GeneticNode<T>();
		// node.data = node; // 참조값이 나온다.
		node.data = data;
		
		if(index == 0) { // 첫번째면 node는 head가 된다
			node.next = head;
			head = node; // 이거 해줘야 하나? => 첫뻔재 노드의 주소 복사 
		} else {
			// 아니면 index의 앞쪽을 찾아서 새로운 node를 연결하고 기존의 node는 새로운 node의 next가 된다
			GeneticNode<T> foundNode = findNode(index - 1);
			// 찾은 Node의 next에 새로 만든 노드를 넣는다
			node.next = foundNode.next; // 없으면 노드의 마지막에서 error 발생. null이라는 값이라도 있어야 함
			foundNode.next = node;
		}
		++size;
	}

    public T getData(int searchIndex) {
        return findNode(searchIndex).data;
    }
    
    public boolean isEmpty() {
        // TODO : 노드가 비어있는지 확인하는 메서드
        return 0 == size; // size가 0이면 true
    }
    
    public int size() {
        // TODO : 노드의 개수를 반환하는 메서드
        return size;
    }
    
    public void addFirst(T data) {
        // TODO : 첫 번째 노드로 추가하는 메서드
        add(0, data);
    }

    public void addLast(T data) {
        // TODO : 마지막 노드로 추가하는 메서드
        add(size, data);
    }
    
	public void remove(int index) {
		if(index == 0 && null != head) { // 첫번째, 없을경우
			head = head.next;
		}else {
			GeneticNode<T> preNode = findNode(index - 1);
			//preNode.next = findNode(index).next;
			preNode.next = preNode.next.next;
		}
		
		--size;
	}
	
    public void removeFirst() {
        // TODO : 첫 번째 노드 삭제하는 메서드
        remove(0);
    }
	
    public void removeLast() {
        // TODO : 마지막 노드를 삭제하는 메서드
        remove(size - 1);
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        GeneticNode<T> pointer = head;
        
        stringBuilder.append("head");
        
        while (null != pointer) {
        	stringBuilder.append(" -> ").append(pointer.data);
            pointer = pointer.next;
        }
    	
        //stringBuilder.append(" -> ").append("null");
        return stringBuilder.toString();
    }
}
