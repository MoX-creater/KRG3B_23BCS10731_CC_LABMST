import java.util.List;
import java.util.Map;
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007;
    
        int[] bitCounts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> i & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }

        long totalSumOfSquares = 0;

        
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 32; bit++) {
                
                if (bitCounts[bit] > 0) {
                    currentNum += (1L << bit);
                    bitCounts[bit]--;
                }
            }
            
            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum)) % MOD;
        }

        return (int) totalSumOfSquares;
    }
}