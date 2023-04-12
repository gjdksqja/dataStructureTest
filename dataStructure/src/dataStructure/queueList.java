package dataStructure;

public class QueueList {
		
	private Node rear; // add 위치 (마지막 노드)
	private Node front; // pull 위치
				    
	public boolean isEmpty() {
	    return null == front;
	}
	
	public void add(Object o) {
		Node n = new Node();
		n.data = o;
		if (isEmpty()) { // 최초 , 모든 pull 상태
			front = rear = n;
		}else {
			
			//현재의 다음에 새로 만든 주소를 넣고
			rear.next = n;
			
			//현재를 새로 만든 Object로 변경
			rear = n;			
		}

	}
  
	public Object pull() {
		if(isEmpty()) { // 현재 노드에 data가 없음
            return null;
		}	
        // TODO : 항상 삭제될 노드는 head가 가리키는 노드이다. => pull 자체가 되어야 한다.
        Node pullNode = front;
        Object tempData = pullNode.data;
        front = pullNode.next; // 다음 노드로 넘긴다. 마지막이라면 다음 노드의 주소가 null일지도

        if( front.next == null ) { // 마지막이라면 
        }
        
        return tempData;
    }
}
