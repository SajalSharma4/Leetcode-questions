//46. Permutations

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] freq = new boolean[nums.length];
        Arrays.fill(freq, false);
        getAns(freq, new ArrayList<>(), ans, nums);
        return ans;
    }

    public static void getAns(boolean[] freq, List<Integer> ds, List<List<Integer>> ans, int[] nums) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < freq.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                getAns(freq, ds, ans, nums);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}

/*
 * class Solution {
 * public List<List<Integer>> permute(int[] nums) {
 * List<Integer> arr=new ArrayList<Integer>();
 * for(int i: nums){
 * arr.add(i);
 * }
 * return permute(arr);
 * }
 * 
 * public static List<List<Integer>> permute(List<Integer> a){
 * List<List<Integer>> ans=new ArrayList<List<Integer>>();
 * if(a.size()==1){
 * ans.add(a);
 * }
 * for(int i=0;i<a.size();i++){
 * int n=a.get(0);
 * a.remove(0);
 * List<List<Integer>> p=permute(a);
 * for(List<Integer> x: p){
 * x.add(n);
 * }
 * ans.addAll(p);
 * a.add(n);
 * }
 * return ans;
 * }
 * }
 */