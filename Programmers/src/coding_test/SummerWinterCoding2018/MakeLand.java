package coding_test.SummerWinterCoding2018;

import java.util.*;

public class MakeLand {
	public class Solution {
	    public long solution(int[][] land, int P, int Q) {

	        int y, x;
	        int height = land.length;
	        int width = land[0].length;

	        long s = 1000000000;
	        long e = 0;
	        for (y = 0; y < height; y++) {
	            for (x = 0; x < width; x++) {
	                e = Math.max(e, land[y][x]);
	                s = Math.min(s, land[y][x]);
	            }
	        }

	        long mid = 0;

	        while (s <= e) {
	            mid = (s + e) / 2;
	            if (s == e) {
	                break;
	            }

	            long r1 = getCost(mid, land, P, Q);
	            long r2 = getCost(mid + 1, land, P, Q);
	            if (r1 == r2) {
	                break;
	            }
	            if (r1 < r2) {
	                e = mid;
	            } else {
	                s = mid + 1;
	            }
	        }
	        return getCost(mid, land, P, Q);
	    }

	    long getCost(long mid, int[][] land, int P, int Q) {
	        long result = 0;
	        for (int i = 0; i < land.length; i++) {
	            for (int j = 0; j < land[0].length; j++) {
	                if (land[i][j] > mid) {
	                    result = result + (land[i][j] - mid) * Q;
	                } else if (land[i][j] < mid) {
	                    result = result + (mid - land[i][j]) * P;
	                }
	            }
	        }
	        return result;
	    }
    }
}