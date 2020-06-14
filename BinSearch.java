//https://leetcode.com/contest/weekly-contest-193/problems/minimum-number-of-days-to-make-m-bouquets/

class BinSearch {
    public int minDays(int[] bd, int m, int k) {
        if(bd.length < m*k) return -1;
        
        int min = 0;
        int max = 1000000007;
        
        while(min+1 < max) {
            int h = min + max >> 1;
            if(check(h, bd, m, k))
                max = h;
            else min = h;
        }
        return max;
    }
    
    private boolean check(int val, int[] bd, int m, int k) {
        int cnt = 0;
        int idx = 0;
        while(idx <= bd.length-k) {
            int right = idx+k;
            int i = idx;
            while(i < right) {
                if(bd[i] > val) break;
                i++;
            }
            if(i == right){ 
                cnt++;
                idx = right;
                if(cnt == m) return true;
            }
            else idx = i+1;
        }
        return false;
    }
}
