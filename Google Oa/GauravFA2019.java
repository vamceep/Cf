import java.util.*;
import java.io.*;

public class GauravFA2019 {

  private static Map<String, Integer> cache;
  private static int[] posts;
  private static int maxJumps;
  private static final int DEFAULT = 1000000;
  private static Set<Integer> uniques;

  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // This is the number of test cases.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int K = in.nextInt();
      int[] heights = new int[N];
      for (int j = 0; j < N; j++) {
        heights[j] = in.nextInt();
      }
      int answer = solveCase(heights, K);
      System.out.printf("Case #%d: %d%n", i, answer);
    }
  }

  private static int solveCase(int[] posts, int K) {
    GauravFA2019.cache = new HashMap<>();
    GauravFA2019.maxJumps = K;
    GauravFA2019.posts = posts;
    GauravFA2019.uniques = new HashSet<>();
    for (int post : posts) {
        GauravFA2019.uniques.add(post);
    }
    int answer =  recursivelySolve(0, -1, 0);
    return answer;
  }

  private static int recursivelySolve(int index, int previous, int jumps) {
    // String key = getKey(index, previous, jumps);
    // if (cache.containsKey(key)) {
    //   return cache.get(key);
    // }
    
    // Base cases.
    // If jumps is over maxJumps, this is invalid, so return DEFAIULT.
    if (jumps > maxJumps) return DEFAULT;
    // If index is over the array, we're done, so return a cost of 0.
    if (index == posts.length) return 0;

    // Recursive cases:
    int answer = DEFAULT;

    // We want to consider changing this post to all other post numbers known.
    for (int otherPost : uniques) {
      int thisPost = posts[index];
      int extraCost = 0;
      int extraJumps = 0;
      if (index != 0 && previous != otherPost) {
        extraJumps = 1;
      }
      if (thisPost != otherPost) {
        extraCost = 1;
      }
      int option = extraCost + recursivelySolve(index + 1, otherPost, jumps + extraJumps);
      answer = Math.min(answer, option);
    }

    // cache.put(key, answer);
    return answer;
  }

  private static String getKey(int index, int previous, int jumps) {
    return index + ":" + previous + ":" + jumps;
  }
}






// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;

// public class GauravFA2019 {

// 	public static void main(String[] args) {
// 		Scanner s = new Scanner(System.in);
// 		int t = s.nextInt(), testCase = 1;
// 		while(t-->0) {
// 			int n = s.nextInt(), k = s.nextInt();
// 			int[] arr = new int[n];
// 			for(int i = 0; i < n; i++) {
// 				arr[i] = s.nextInt();
// 			}
// 			int[][] elem = new int[n][n];
// 			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
// 			for(int i = 0; i < n; i++) {
// 				for(int j = i; j < n; j++) {
// 					int max = 0;
// 					for(int idx = i; idx <= j; idx++) {
// 						if(map.containsKey(arr[idx])) {
// 							map.put(arr[idx], map.get(arr[idx]) + 1);
// 						} else {
// 							map.put(arr[idx], 1);
// 						}
// 						max = Math.max(max, map.get(arr[idx]));
// 					}
// 					elem[i][j] = j - i + 1 - max;
// 					map.clear();
// 				}
// 			}
// 			int[] prev = new int[n];
// 			int ans = Integer.MAX_VALUE;
// 			for(int i = 0; i < n; i++) {
// 				prev[i] = elem[0][i];
// 				ans = Math.min(ans, prev[i]);
// 			}
// 			ans = prev[n - 1];
// 			for(int l = 1; l <= k; l++) {
// 				int[] next = new int[n];
// 				for(int i = 0; i < n; i++) {
// 					next[i] = prev[i];
// 				}
// 				for(int i = 0; i < n; i++) {
// 					for(int j = i + 1; j < n; j++) {
// 						next[j] = Math.min(next[j], prev[i] + elem[i + 1][j]);
// 					}
// 				}
// 				ans = Math.min(ans, next[n - 1]);
// 				prev = next;
// 			}
// 			System.out.println("Case #" + testCase + ": " + ans);
// 			testCase++;
// 		}

// 	}

// }
