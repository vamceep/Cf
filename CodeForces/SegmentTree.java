import java.util.*;

class SegmentTree{
    long[] ary;
    int size;
    public SegmentTree(int[] ar) {
        size = getSegmentTreeSize(ar.length);
        ary = new long[2*size-1];
        // buildTreeSum(ar);
        buildTreeMin(ar);
    }

    public void setSum(int idx, long val) {
        idx += ary.length/2;
        long diff = ary[idx] - val;
        while(idx >= 0) {
            ary[idx] -= diff;
            idx = idx%2==0? idx/2-1: idx/2;
        }
        val = val - ary[ary.length/2+idx];
    }

    public void setMin(int idx, int val) {
        idx += ary.length/2;
        ary[idx] = val;
        idx = idx%2 == 0? idx/2-1: idx/2;
        while(idx >= 0) {
            ary[idx] = Math.min(ary[2*idx+1], ary[2*idx+2]);
            idx = idx%2 == 0? idx/2-1: idx/2;
        }
    }

    public long getSum(int l, int r) {
        return getSum(l,r, 0, size-1, 0);
    }

    private long getSum(int l, int r, int cl, int cr, int idx) {
        if(cl > r || l > cr) return 0;
        if(l <= cl && cr <= r) return ary[idx];
        if(cl == cr) return ary[idx];
        int mid =  cl + (cr - cl)/2;
        long left = getSum(l, r, cl, mid, 2*idx+1);
        long right = getSum(l, r, mid+1, cr, 2*idx+2);
        return left + right;
    }

    public long getMin(int l, int r){
        return getMin(l, r, 0, size-1, 0);
    }

    private long getMin(int l, int r, int cl, int cr, int idx) {
        if( l <= cl && cr <= r) return ary[idx];
        if(l > cr || r < cl) return Integer.MAX_VALUE;
        int mid = cl + (cr - cl)/2;
        long left =getMin(l, r, cl, mid, 2*idx+1);
        long right =getMin(l, r, mid+1, cr, 2*idx+2);
        return Math.min(left, right);
    }

    private int getSegmentTreeSize(int size) {
        int val = 1 << 30;
        while((val & size) == 0)val >>= 1;
        return val << 1;
    }

    public void print() {
        for(long i : ary) System.out.print(i+" ");
        System.out.println();
    }

    private void buildTreeSum(int[] ar) {
        Queue<Integer> q = new LinkedList<Integer>();
        int idx = ary.length/2;
        for(int i : ar) {
            ary[idx] = i;
            q.offer(idx++);
        }
        while(idx < ary.length)q.offer(idx++);

        while(true) {
            int par = q.peek()/2;
            ary[par] += ary[q.poll()];
            ary[par] += ary[q.poll()];
            if(par == 0) break;
            q.offer(par);
        }
    }

    private void buildTreeMin(int[] ar) {
        Queue<Integer> q = new LinkedList<Integer>();
        int idx = ary.length/2;
        Arrays.fill(ary, Integer.MAX_VALUE);
        for(int i : ar) {
            ary[idx] = i;
            q.offer(idx++);
        }

        idx = q.poll();
        while(idx != 0) {
            int par;
            if(idx%2 == 0)
                par = idx/2-1;
            else
                par = idx/2;
            ary[par] = Math.min(ary[par], ary[idx]);
            q.offer(par);
            idx = q.poll();
        }
    }
}