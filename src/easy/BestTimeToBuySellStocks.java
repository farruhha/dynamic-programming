package easy;

public class BestTimeToBuySellStocks {

    public int maxProfit(int[] prices) {
        return linearSolution(prices);
    }

    /**
     * By brute force solution
     * */
    private int solveByBruceForce(int[] prices){
        if(prices.length <= 1) return 0;
        int max = 0;

        for(int buy = 0; buy < prices.length - 1; buy++){
            for(int sell = buy + 1; sell < prices.length; sell++){
                max = Math.max(max, prices[sell] - prices[buy]);
            }
        }
        return max;
    }

    private int linearSolution(int [] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
