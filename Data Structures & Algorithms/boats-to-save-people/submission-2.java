class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = n-1;
        int ans = 0;

        while(left <= right){
            if(people[right] + people[left] <= limit){
                ans += 1;
                right -= 1;
                left += 1;
            }else{
                right -= 1;
                ans += 1;
            }
        }
        return ans;
        
    }
}