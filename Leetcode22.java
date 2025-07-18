import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, 0);
        return result;
    }

    public void generateParenthesis(List<String> result, String cur, int lcnt, int rcnt) {
        if (lcnt == 0 && rcnt == 0){
            result.add(cur);
        }
         if (lcnt != 0){
            generateParenthesis(result, cur+"(", lcnt-1, rcnt+1);
        }
         if (rcnt != 0){
            generateParenthesis(result, cur+")", lcnt, rcnt-1);
        }
    }
}