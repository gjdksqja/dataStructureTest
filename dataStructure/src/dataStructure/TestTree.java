package dataStructure;

import dataStructure.tree.BinarySearchTree;
import dataStructure.tree.NormalTree;
import dataStructure.tree.SideNomalTree;

public class TestTree {
	
	TestTree() {
		//getSideNomalTree();
		//getBinarySearchTree();
	}
	
	public void getBinarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(5);
		binarySearchTree.add(2);
		binarySearchTree.add(9);
		binarySearchTree.add(3);
		binarySearchTree.add(7);
		binarySearchTree.add(4);
		binarySearchTree.add(8);
		binarySearchTree.add(1);
		binarySearchTree.add(6);
		binarySearchTree.search(0);
		binarySearchTree.search(8);
		binarySearchTree.search(11);
		binarySearchTree.search(1);
		binarySearchTree.removeNode(5);
//		binarySearchTree.printTree();
//		System.out.println("traversal");
//		binarySearchTree.traversal();
	}
	
	public void getNomalTree() {
        NormalTree normalTree = new NormalTree();
        normalTree.addData(1);
        normalTree.addData(2);
        normalTree.addData(3);
        normalTree.addData(4);
        normalTree.addData(5);
        normalTree.addData(6);
        normalTree.addData(7);

        // TODO : 전위 순회       
        normalTree.preOrderTraversal();
        // TODO : 중위 순회
        normalTree.inOrderTraversal();
        // TODO : 후위 순회     
        normalTree.postTraversal();		
	}
	
    public void getSideNomalTree() {
    	SideNomalTree sideNomalTree = new SideNomalTree();
    	sideNomalTree.add(1);
    	sideNomalTree.add(2);
    	sideNomalTree.add(3);
    	sideNomalTree.add(4);
    	sideNomalTree.add(5);
    	sideNomalTree.add(6);
    	sideNomalTree.add(7);
    	sideNomalTree.add(8);
    	sideNomalTree.add(9);
    	sideNomalTree.add(10);
    	sideNomalTree.add(11);
    	sideNomalTree.add(12);

    	sideNomalTree.levelTraversal();
    }
}
