import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class Submit {
    public static void main(String fsdaf[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ary = new int[n];
        for(int i = 0; i < n; i++)
            ary[i] = sc.nextInt();
        
        SegmentTree_this st = new SegmentTree_this(ary);

        while(m-- != 0) {
            int t = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(t == 1) st.setMin(l,r);
            else {
                int[] val = st.getMin(l,r-1);
                System.out.println(val[0]+" "+val[1]);
            }
        }
        sc.close();
    }
}

class SegmentTree_this{
    int[][] ary;
    int size;
    public SegmentTree_this(int[] ar) {
        size = getPowerOf2(ar.length);
        ary = new int[2*size-1][2];
        for(int[] arr : ary) {
            arr[0] = Integer.MAX_VALUE;
            arr[1] = 0;
        }

        int idx = ary.length/2;
        Queue <Integer> q = new LinkedList<Integer>();
        for(int i : ar) {
            ary[idx][0] = i;
            ary[idx][1] = 1;
            q.offer(idx++);
        }
        while(idx < ary.length) q.offer(idx++);
        while(q.size() != 0) {
            int par = q.peek()/2;
            int left = q.poll();
            int right = q.poll();
            ary[par][0] = Math.min(ary[left][0], ary[right][0]);
            if(ary[left][0] == ary[right][0])
                ary[par][1] = ary[left][1] + ary[right][1];
            else ary[par][1] = ary[left][0] < ary[right][0]? 
                                ary[left][1]:
                                ary[right][1];
            
            if(par == 0) break;
            q.offer(par);
        }
    }

    private int getPowerOf2(int len) {
        int val = 1;
        while(len > 0) {
            val *= 2;len /= 2;
        }
        return val;
    }

    public void setMin(int idx, int val) {
        idx += ary.length/2;
        ary[idx][0] = val;
        ary[idx][1] = 1;
        idx = (int)Math.ceil(idx/2d)-1;
        while(idx >= 0) {
            int left = 2*idx+1;
            int right = left + 1;
            ary[idx][0] = Math.min(ary[left][0], ary[right][0]);
            if(ary[left][0] == ary[right][0])
                ary[idx][1] = ary[left][1] + ary[right][1];
            else ary[idx][1] = ary[left][0] < ary[right][0]? 
                                ary[left][1]:
                                ary[right][1];
            idx = (int)Math.ceil(idx/2d)-1;
        }
    }

    public int[] getMin(int l , int r) {
        return getMin(l, r, 0, size-1, 0);
    }

    private int[] getMin(int l, int r, int cl, int cr, int idx) {
        if(l <= cl && cr <= r) return ary[idx];
        if(l > cr || r < cl) return new int[]{Integer.MAX_VALUE, 0};
        int mid = (cl + cr)/2;
        int[] left = getMin(l, r, cl, mid, 2*idx+1);
        int[] right = getMin(l, r, mid+1, cr, 2*idx+2);
        int[] ret = new int[2];
        ret[0] = Math.min(left[0], right[0]);
        ret[1] = left[0] == right[0]?
                 left[1] + right[1]:
                    left[0] < right[0]?
                    left[1]:
                    right[1];
        return ret;
    }

    public void print() {
        for(int i[] : ary) System.out.print("("+i[0]+","+i[1]+")"+" ");
        System.out.println();
    }
}