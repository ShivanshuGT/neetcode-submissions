class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;

        while(left != right){
            // finding longest common prefix between left and right
            left = (left >> 1);
            right = (right >> 1);
            shiftCount += 1;
        }
        return (left << shiftCount);
        
    }
}