public class Leetcode415 {
    
}
class Solution {
    public String addStrings(String num1, String num2) {
        char [] n1 = num1.toCharArray(), n2 = num2.toCharArray(), sum = new char[Math.max(n1.length, n2.length)+1];
        int s = 0, c = 0;
        int p1 = n1.length-1, p2 = n2.length-1, p3 = sum.length-1;

        while(p1 >=0 && p2 >=0){
            s = (n1[p1]+n2[p2]+c-'0'-'0')%10;
            sum[p3--] = (char)(s+'0');

            c = (n1[p1]+n2[p2]+c-'0'-'0')/10;
            
            p1--;
            p2--;
        }
        while(p1 >=0 ){
            s = (n1[p1]+c-'0') %10;
            sum[p3--] = (char)(s+'0');

            c = (n1[p1]+c-'0') /10;
            p1--;
        }
        while(p2 >=0){
            s = (n2[p2]+c-'0') %10;
            sum[p3--] = (char)(s+'0');

            c = (n2[p2]+c-'0') /10;
            p2--;
        }
        sum[p3] = (char)(c+'0');
        String res = new String(sum);
        if(res.startsWith("0")){
            res = res.substring(1);
        }
        return res;


    }
}
