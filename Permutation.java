import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {


    public static void main(String[] args) {
        System.out.println(permutationR(Arrays.asList(1, 2, 3, 4), 2));
    }
    
    /**
     * Calculate r-permutations
     *
     * @param nums a list of comparable objects
     * @param r length of permutations
     * @return List of r-permutations, with a total number of P(n, r)
    */
    public static List<List<Integer>> permutationR(List<Integer> nums, int r) {
        List<List<Integer>> res = new ArrayList<>();
        if(r == 0){
            res.add(new ArrayList<>());
            return res;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> remain = new ArrayList<>(nums);
            int head = remain.remove(i);
            for(List<Integer> lst: permutationR(remain, r-1)){
                lst.add(0, head);
                res.add(lst);
            }
        }

        return res;


    }
}
