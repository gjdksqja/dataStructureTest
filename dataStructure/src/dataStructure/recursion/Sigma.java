package dataStructure.recursion;

public class Sigma {

	private int sum = 0;
	
	public Sigma() {
		sum = sigma(1,0);
		System.out.print(sum);;
	}
	
	// 해당 함수의 재귀로 
	// 5회 이상이면 중지
	public int sigma (int i, int j ) { // i:  들어온 값, j: 현재 휫수까지의 합
		if(i > 5) {
			return j;
		}
		
		j= i+j;
		i++;
		
		return sigma(i,j);
	}
	
}


