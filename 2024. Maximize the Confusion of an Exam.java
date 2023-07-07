//2024. Maximize the Confusion of an Exam

/*
A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.

Example 1:
Input: answerKey = "TTFF", k = 2
Output: 4
Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.
 */

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int ans = 0;
        int s = 0, e = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'F') {
                e++;
            }
            while (e > k) {
                if (arr[s] == 'F')
                    e--;
                s++;
            }
            ans = Math.max(ans, i - s + 1);
        }
        s = 0;
        e = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') {
                e++;
            }
            while (e > k) {
                if (arr[s] == 'T')
                    e--;
                s++;
            }
            ans = Math.max(ans, i - s + 1);
        }
        return ans;
    }
}