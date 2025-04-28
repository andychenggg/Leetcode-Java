package Queue.Leetcodes;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();

        HashMap<Character, Integer> needMap = new HashMap<>();
        int needCnt = t.length();
        String res = "";
        for (int i = 0; i < tArr.length; i++) {
            Integer cnt = needMap.get(tArr[i]);
            if(cnt != null){
                needMap.put(tArr[i], cnt+1);
            }
            else {
                needMap.put(tArr[i], 1);
            }
        }

        int p1 = 0, p2 = 0;
        while(p1 < s.length() && p2 < s.length()){
            while(needCnt > 0 && p2 < s.length()){
                Integer cnt = needMap.get(sArr[p2]);
                if(cnt == null){
                    needMap.put(sArr[p2], -1);
                }
                else if (cnt <= 0){
                    needMap.put(sArr[p2], cnt-1);
                }
                else{
                    // cnt>0
                    needCnt--;
                    needMap.put(sArr[p2], cnt-1);
                }
                p2++;
            }
            // System.out.println(p1+" "+p2);
            // System.out.println(needMap);
            while(needCnt == 0 && p1 < p2){
                if("".equals(res)){
                    res = s.substring(p1, p2);
                }
                else{
                    res = res.length() < p2-p1? res:s.substring(p1, p2);
                }
                // System.out.println("res: "+res);
                Integer cnt = needMap.get(sArr[p1]);
                if (cnt < 0){
                    needMap.put(sArr[p1], cnt+1);
                }
                else{
                    // cnt>=0
                    needCnt++;
                    needMap.put(sArr[p1], cnt+1);
                }
                p1++;
            }
            
        }
        return res;
    }
}

