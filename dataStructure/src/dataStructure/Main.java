package dataStructure;

public class Main {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub	
	}
	public static void getDoublyLinkedList() {
		DoublyLinkedList<String> list = new DoublyLinkedList();
        int i = 0;

        System.out.println(++i); // 1
        list.addLast("B");
        System.out.println(list);
        
        System.out.println(++i); // 2
        list.addFirst("A");
        System.out.println(list);

        System.out.println(++i); // 3
        list.addLast("E");
        System.out.println(list);

        System.out.println(++i); // 4 
        list.add(1, "C");
        System.out.println(list);

        System.out.println(++i); // 5
        list.add(2, "D");
        System.out.println(list);

        System.out.println(++i); // 6
        list.removeLast();
        System.out.println(list);

        System.out.println(++i); // 7
        list.remove(1);
        System.out.println(list);

        System.out.println(++i); /// 8
        list.removeFirst();
        System.out.println(list);
        
        System.out.println(++i); // 9
        list.addLast("TT");
        System.out.println(list);

        System.out.printf("노드의 개수:%d\n", list.size());

        System.out.printf("1번 인덱스의 값:%s", list.getData(1));		
	}
	
	public static void genericTest() {
		// TODO Auto-generated method stub
		GeneticSinglyLinkedList list = new GeneticSinglyLinkedList();
        int i = 0;

        System.out.println(++i); // 1
        list.addLast("B");
        System.out.println(list);
        
        System.out.println(++i); // 2
        list.addFirst("A");
        System.out.println(list);

        System.out.println(++i); // 3
        list.addLast("E");
        System.out.println(list);

        System.out.println(++i); // 4 
        list.add(1, "C");
        System.out.println(list);

        System.out.println(++i); // 5
        list.add(2, "D");
        System.out.println(list);

        System.out.println(++i); // 6
        list.removeLast();
        System.out.println(list);

        System.out.println(++i); // 7
        list.remove(1);
        System.out.println(list);

        System.out.println(++i); /// 8
        list.removeFirst();
        System.out.println(list);
        
        System.out.println(++i); // 9
        list.addLast(new Object());
        System.out.println(list);

        System.out.printf("노드의 개수:%d\n", list.size());

        System.out.printf("1번 인덱스의 값:%s", list.getData(1));	
	}

}
