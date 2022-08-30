class Solution {
    public int maxProfit(int[] prices) {
        int min  = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        int[] dp = new int[prices.length] ;
        
        for(int i = 0 ;i< prices.length ; i++)
        {
            if(prices[i] > min) {
                dp[i] = prices[i] - min ;
            }
            else if(prices[i]<min) {
                min = prices[i] ;
            }
            
            if(dp[i]>max)
            {
              max = dp[i] ;
            }
        }
        
        return max>0?max:0;
        
    }
}