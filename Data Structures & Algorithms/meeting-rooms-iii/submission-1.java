class Solution {

    private void assingMeetingRoom(int[] meeting, int[] arr, int[] counter){
        int n = arr.length;
        int startTime = meeting[0];
        int minIndex = (int) 1e9;
        int minValue = (int) 1e9;

        for(int i = 0; i < n; i++){

            if(arr[i] <= startTime){
                arr[i] = meeting[1];
                counter[i] += 1;
                return;
            }

            if(minValue > arr[i]){
                minValue = arr[i];
                minIndex = i;
            }
        }

        counter[minIndex] += 1;
        arr[minIndex] += meeting[1] - meeting[0];


    }
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] arr = new int[n];
        int[] counter = new int[n];

        int m = meetings.length;

        for(int i = 0; i < m; i++){
            int[] meeting = meetings[i];

            assingMeetingRoom(meeting, arr, counter);

        }

        int maxValue = 0;
        int ans = -1;

        for(int i = 0; i < n; i++){
            if(counter[i] > maxValue){
                maxValue = counter[i];
                ans = i;
            }
        }
        return ans;
        
    }
}