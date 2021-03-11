package coding_test.SummerWinterCoding2019;
import java.util.*;
/*
 * 
 * 테스트명 : 멀쩡한 사각형
 * 
 * @ 김지민
 * 
 */

public class NormalRectangle {
	    public long solution(int w, int h) {
	        long answer = 0;
			long min = (long)h;
			long max = (long)w;
	        
			if (w < h) {
				min = (long)w;
				max = (long)h;
			}

			long value = 1;
	        //유클리드 호제법으로 최대 공약수 구하기
			while (value > 0) {
				value = max % min;
				max = min;
				min = value;
			}
			answer = (long)w * (long)h - ((long)w + (long)h - max);
			return answer;
	    }
}
