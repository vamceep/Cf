
public class FindRankD {
	
	public int findRankD(int[] ary, int rank) {
		int val = ary[findRankD(ary, 0, ary.length - 1, rank)];
		return val;
	}
	
	private int findRankD(int[] ary, int left, int right, int rank) {
		while(left < right) {
			int k = getPivot(ary, left, right);
			swap(ary , left, k);
			k =partition(ary, left, right);
			int cr = right - k + 1;
			if(cr == rank)
				return k;
			else if(cr > rank)
				left  = k + 1;
			else {
				right = k-1;
				rank = rank - cr;
			}
		}
		return left;
	}
	
	private int getPivot(int[] ary, int left, int right) {
		if(right - left  + 1 <= 5) return median5Nums(ary, left, right);
		int sets = (right - left + 1)/5;
		int index = left;
		int i = left;
		for(i = left; i < sets*5; i += 5)
			swap(ary, index++, median5Nums(ary, i, i + 4));
		if((right - left + 1)%5  > 0)
			swap(ary, index, median5Nums(ary, i, right));
		
		return getPivot(ary, left, left + sets - 1);
//		return findRankD(ary, left, left + sets - 1, sets/2 -1);
	}

	private int partition(int[] ary, int left, int right) {
		int i = left;
		int j = right;
		int pivot = ary[left];
		
		while(i < j) {
			while(i < j && ary[i] < pivot) i++;
			while(i < j && ary[j] > pivot)j--;
			if(i<j) swap(ary, i, j);
		}
		return i;
	}
	
	private int median5Nums(int[] ary, int left, int right) {
		for(int i =0; i <= (right - left + 1) /2; i++) {
			for(int j = left + i; j <= right; j++)
				if(ary[j] < ary[left + i]) 
					swap(ary, left + i, j);
		}
		return left + (right - left + 1)/2;
	}
	
	private void swap(int[] ary, int i, int j) {
		
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
	}

}