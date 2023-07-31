//409. Longest Palindrome

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] ans = new int[124];
        Arrays.fill(ans, 0);
        for (char c : s.toCharArray()) {
            ans[c]++;
        }
        int len = 0;
        int count = 0;
        for (int i : ans) {
            if (i % 2 != 0 && count == 0) {
                count++;
                len += 1;
            }
            if (i % 2 == 0) {
                len += i;
            } else {
                len += (i - 1);
            }
        }
        return len;

        /*
         * HashMap<Character,Integer> h=new HashMap<Character,Integer>();
         * for(char c: s.toCharArray()){
         * if(h.containsKey(c)){
         * h.replace(c,h.get(c)+1);
         * }else{
         * h.put(c,1);
         * }
         * }
         * int len=0;
         * int count=0;
         * for(Map.Entry<Character,Integer> x: h.entrySet()){
         * if(x.getValue()%2!=0 && count==0){
         * count++;
         * len++;
         * }
         * if(x.getValue()%2==0){
         * len+=x.getValue();
         * }else{
         * len+=(x.getValue()-1);
         * }
         * }
         * return len;
         */
    }
}