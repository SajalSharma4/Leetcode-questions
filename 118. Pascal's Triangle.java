//118. Pascal's Triangle

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
*/ 

class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[] dp=new int[numRows];
        Arrays.fill(dp,1);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> val=new ArrayList<Integer>();
            if(i==0){
                val.add(1);
                ans.add(val);
                continue;
            }
            if(i==1){
                val.add(1);
                val.add(1);
                ans.add(val);
                continue;
            }
            if(i>1){
                int[] temp=new int[i+1];
                temp[0]=1;
                temp[i]=1;
                for(int j=1;j<i;j++ ){
                    temp[j]=dp[j]+dp[j-1];
                }
                for(int x: temp){
                    val.add(x);
                }
                ans.add(val);
                dp=temp;
            }
        }
        return ans;
    }
}