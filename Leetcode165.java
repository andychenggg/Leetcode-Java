public class Leetcode165 {
    public static void main(String[] args) {
        new Solution().compareVersion("1.10", "1.2");
    }
}
class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\."), v2 = version2.split("\\.");
        System.out.println(v1.length);
        System.out.println(v2.length);
        for (int i = 0; i < v2.length || i < v1.length; i++) {
            int cv1, cv2;
            if (i < v1.length){
                cv1 = Integer.parseInt(v1[i]);
            }
            else {
                cv1 = 0;
            }

            if (i < v2.length){
                cv2 = Integer.parseInt(v2[i]);
            }
            else {
                cv2 = 0;
            }
            System.out.println(cv1+" "+cv2);
            if (cv1 < cv2) {
                return -1;
            }
            else if (cv1 > cv2){
                return 1;
            }
        }
        return 0;
    }
}
