package dataStructure.recursion;

import java.util.Arrays;

public class SplitRecursion {
	int[] sumArr = {5,6,7,8,4,3,2,9}; // length = 8 일때
	
	public SplitRecursion() {

        int[] split1 = Arrays.copyOfRange(sumArr, 0, sumArr.length/2);
        int[] split2 = Arrays.copyOfRange(sumArr, sumArr.length/2+1, sumArr.length+1);
		
		System.out.println(sumFunction(split1,0,0) + sumFunction(split2,0,0));
	}
	
	// 반으로 쪼개서 하나씩 더하기
	public int sumFunction(int[] i,int num , int sum) { // i:계산 배열, num: 현재 번호, sum: 합계
		if(i.length == num ) {			
			return sum;
		}
		
		sum += i[num];
		num ++;
	
		return sumFunction(i,num,sum);
	}
}
