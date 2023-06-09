package dataStructure.recursion;

public final class MazeProblem {

    // 예시 : 미로 배열
    private final int[][] mazeArray = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
    };
    
    // 방문 확인 : 최초는 false임.
    private final boolean[][] mazeVisitArray = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false}
    };
    
    private boolean isFinished = false;
    
    public MazeProblem () {
    	
    	// start 
    	int x = 1;
    	int y = 0;
    	
    	visit(x,y);
    	
    	//System.out.print(mazeVisitArray);

    }
    
    public void visit(int x , int y) { // x,y 좌표 평면
    	// 완료
    	if(isFinished) return;
    	
    	// 이미 방문
    	if(mazeVisitArray[x][y] == true ) return;
    	
    	// 벽 확인
    	if(mazeArray[x][y] == 1) return;
    	
    	// 완료 확인
    	if(x==3 && y==7) {
    		mazeVisitArray[x][y] = true; // 방문
    		System.out.println("x: "+x+", "+"y: "+ y+ " visited");
    		isFinished = true;
    		return;
    	}
    	
    	// 방문
    	mazeVisitArray[x][y] = true;
    	System.out.println("x: "+x+", "+"y: "+ y+ " visited");
    	
    	/* 상하좌우 이동
    	 * 이동 시 x,y 좌표가 밖으로 나가지 않는 규칙을 넣어줘야 하나 이번에는 그럴 일이 없음으로 넣지 않는다.
    	 */
    	visit(x + 1, y); // 오른쪽
    	visit(x, y + 1); // 아래		
    	visit(x - 1, y); // 왼쪽
    	visit(x, y - 1); // 위
    }
    
}