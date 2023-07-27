//1. Two Sum

/*
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] ans=new int[2];
        int i=0,j=n-1;
        int[] a=nums.clone();
        Arrays.sort(a);
        while(i<=j){
            int sum=a[i]+a[j];
            if(sum==target){
                ans[0]=a[i];
                ans[1]=a[j];
                break;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
        for(i=0;i<n;i++){
            if(nums[i]==ans[0]){
                ans[0]=i;
                break;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]==ans[1] && i!=ans[0]){
                ans[1]=i;
                break;
            }
        }
        return ans;      
    }
}