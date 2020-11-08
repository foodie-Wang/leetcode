/**
 * @author wyd
 * @date 2020/11/8 - 21:58
 */
public class test121_BestTimeToBuyAndSellStock {


    /**
     * 暴力解法（ 时间复杂度O(n²)，空间复杂度O(1) ）
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int value;
//        int _maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                value = prices[j] - prices[i];
//                if (value > _maxProfit) {
//                    _maxProfit = value;
//                }
//            }
//        }
//        return _maxProfit;
//    }


    /**
     * 我们的目的是寻找最低股价，找到最低股价之后，就知道要在哪一天买入，然后再去找看哪天卖出的利润最大即可。
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        //这一步的目的其实就是要先把minprice的值设置为prices数组中的第一个元素，因为Integer.MAX_VALUE的值是2147483647
        int minprice = Integer.MAX_VALUE;
        //System.out.println(minprice);
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            //如果当前价格比最低股价要低，那么就把当前价格赋给最低价格
            if (prices[i] < minprice) {
                minprice = prices[i];
            //如果当前价格比最低价格要高，那说明目前最低价格就是minprice，那直接计算当前价格卖出时，利润是多少:price[i]-minprice
            //还要在进行一次比较，如果当前价格卖出时的利润不是最大的，那就继续看下一天卖出时是不是利润最大。如果当前价格卖出时的利润
            //比maxprofit大，那说明在这一天卖出时利润最大，更新maxprofit。
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }



    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        test121_BestTimeToBuyAndSellStock stock = new test121_BestTimeToBuyAndSellStock();
        int profit = stock.maxProfit(prices);
        System.out.println(profit);
    }
}
