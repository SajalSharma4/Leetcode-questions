//40. Combination Sum II

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getAns(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }

    public void getAns(int index, int[] arr, List<List<Integer>> ans, List<Integer> vals, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(vals));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            vals.add(arr[i]);
            getAns(i + 1, arr, ans, vals, target - arr[i]);
            vals.remove(vals.size() - 1);
        }
    }
}