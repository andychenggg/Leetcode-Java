import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i: nums) {
            numList.add(i);
        }

        return per(numList);

    }

    public List<List<Integer>> per(List<Integer> numList){
        List<List<Integer>> res = new ArrayList<>();
        if(numList.size() == 0){
            res.add(new ArrayList<>());
            return res;
        }

        for (int i = 0; i < numList.size(); i++) {
            List<Integer> remain = new ArrayList<>(numList);
            int tail = remain.remove(i);
            for(List<Integer> num: per(remain)){
                num.add(tail);
                res.add(num);
            }
        }
        return res;
    }

}