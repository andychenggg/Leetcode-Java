import java.util.HashSet;
import java.util.Set;


class solution {


    /**
     * CodeTop1, Leetcode3: https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int resLen = 0;
        // use slide window(2-pointer) to solve.
        int p1 = 0, p2 = 0;
        Set<Character> charSet = new HashSet<>();
        while(p2 != str.length){
            // Calculate the max len from index p1
            while(p2 != str.length && !charSet.contains(str[p2])){
                charSet.add(str[p2]);
                p2++;
            }
            if(charSet.size() > resLen)
                resLen = charSet.size();
            charSet.remove(str[p1++]);
            if(p2 < p1)
                p2 = p1;
        }
        return resLen;
    }
}