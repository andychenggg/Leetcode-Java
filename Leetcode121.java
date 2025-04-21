public class Leetcode121 {

    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0], res = 0;
        for(int i : prices){
            if(i - lowest > res){
                res = i-lowest;
            }
            if(i < lowest){
                lowest = i;
            }
        }
        return res;
    }
}