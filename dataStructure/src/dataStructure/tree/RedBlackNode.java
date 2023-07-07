package dataStructure.tree;

public class RedBlackNode extends Node {
    int color; // 1 for Red, 0 for Black
    
    RedBlackTree parent; // 관리 가능할시만 필요함. 있으면 위로 검사도 가능해져서 좋긴 함.
}
