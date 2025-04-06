import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        System.out.println(allCombinations(
            Arrays.asList(1, 2, 3)
        ));

        System.out.println(combinationsR(
            Arrays.asList(1, 2), 1
        ));
    }
    /**
     * Calculate all combinations of a list
     * @param nums a list
     * @return a list of all combinations, inlcuding an empty list, with a 
     *          total number of C(n, 0)+...+C(n, n) = 2^n
     */
    public static List<List<Integer>> allCombinations(List<Integer> nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.size() == 0){
            return res;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            int head = nums.get(i);
            List<Integer> remain = nums.subList(i+1, nums.size());
            for(List<Integer> lst: allCombinations(remain)){
                lst.add(0, head);
                res.add(lst);
            }
        }
        return res;
    }

    public static List<List<Integer>> combinationsR(List<Integer> nums, int r){
        List<List<Integer>> res = new ArrayList<>();
        if(r==0){
            res.add(new ArrayList<>());
            return res;

        }
        
        for (int i = 0; i < nums.size() - r + 1; i++) {
            int head = nums.get(i);
            List<Integer> remain = nums.subList(i+1, nums.size());
            for(List<Integer> lst: combinationsR(remain, r-1)){
                lst.add(0, head);
                res.add(lst);
            }
        }
        
        
        return res;
    }
}
