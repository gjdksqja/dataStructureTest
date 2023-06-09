package dataStructure;

public class CircleQueue {
 
	    private final Object[] queue;

	    private int front = 0; // 현재 pull 위치
	    private int rear = 0; // 현재 add 위치 

	    public CircleQueue(int size) {
	        this.queue = new Object[size];
	    }
	    
	    public void add(Object o) {
	        if (front == rear && null != queue[rear]) {
	            throw new RuntimeException("Queue is Full");
	        }
	        
	        queue[rear] = o;
	        ++rear;
	        rear = rear % queue.length;
	    }
	    
	    public Object pull() {
	        if (front == rear && null == queue[front]) {
	            return null;
	        }	    	
	    	Object d = new Object();
	    	d = queue[front];
	    	queue[front] = null;

	    	++front;
	    	front = front % queue.length;
	    	
	    	return d;
	    }
	    
	    public Object peek() {
	        return queue[front];
	    }
}
