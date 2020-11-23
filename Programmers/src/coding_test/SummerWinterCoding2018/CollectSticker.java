package coding_test.SummerWinterCoding2018;

class CollectSticker {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;
        if(length==1){
            return sticker[0];
        }else if(length==2){
            return Math.max(sticker[0],sticker[1]);
        }else{

        int[] dp =new int[length-1];
        int[] dp2= new int[length];
        
        dp[0]=sticker[0];
        dp[1]=sticker[0];
        dp2[0]=0;
        dp2[1]=sticker[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            dp2[i]=Math.max(dp2[i-2]+sticker[i],dp2[i-1]);
        }
        
        return Math.max(dp[length-2],dp2[length-1]);
        }
    }
}