package BackTracking.Problems;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    
}
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s, -1, -1, -1, res);
        return res;
    }

    public void backTracking(String s, int p1, int p2, int p3, List <String> res){
        if (p3 != -1){
            // check p3
            if (isValid(s.substring(p3+1))){
                res.add(s.substring(0, p1+1)+"."+s.substring(p1+1, p2+1)+"."+s.substring(p2+1, p3+1)+"."+s.substring(p3+1));
            }
            return;
        }

        if (p2 != -1){
            // check p2
            for(int i = p2+1; i < s.length()-1; i++){
                if (isValid(s.substring(p2+1, i+1)))
                    backTracking(s, p1, p2, i, res);
            }
            
            return;
        }

        if (p1 != -1){
            // check p1
            for(int i = p1+1; i < s.length()-2; i++){
                if (isValid(s.substring(p1+1, i+1)))
                    backTracking(s, p1, i, -1, res);
            }
            return;
        }

        for(int i = 0; i < s.length()-3; i++){
            if(isValid(s.substring(0, i+1))){
                backTracking(s, i, -1, -1, res);
            }
            
        }
    }

    public boolean isValid(String s){
        return "0".equals(s) || s != null && s.length() > 0 && s.length() <= 3 && !s.startsWith("0") && Integer.parseInt(s) <= 255;
    }
}