public class Leetcode5 {

    public static void main(String[] args) {
        
    }
}

class Solution {
    public String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }

        int maxLen = 1, resL = 0;
        char [] charArr = s.toCharArray();
        boolean [][] palindrome = new boolean[s.length()][s.length()];
        

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(j + i >= s.length()){
                    continue;
                }
                else if(i <= 1){
                    palindrome[j][j+i] = charArr[j] == charArr[j+i];
                }
                else{
                    palindrome[j][j+i] = charArr[j] == charArr[j+i] && palindrome[j+1][j+i-1];
                }
                if(palindrome[j][j+i] && i+1 > maxLen){
                    maxLen = i+1;
                    resL = j;
                }
            }
        }
        return s.substring(resL, resL+maxLen);
    }
}