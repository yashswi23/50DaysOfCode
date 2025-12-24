// This is the Editorial Solution (first), but I have edited it to make
// more use of constants instead of literals
class Solution {
    private static final int START_TIME = 0;
    private static final int END_TIME = 1;
    private static final int VALUE = 2;

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);
    }

    // Recursive function to find the greatest sum for the pairs.
    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
        // Nowhere to go at this point
        if (cnt == 2 || idx >= events.length) return 0;

        if (dp[idx][cnt] == -1) {
            int currentEventEnd = events[idx][END_TIME];
            int lo = idx + 1, hi = events.length - 1;

            // The found value is the earliest event that does not overlap the current one
            int nextNonOlapInx = binarySearch(events, lo, hi, currentEventEnd);

            // Exclude is the 'score' from just ignoring the current event.
            int exclude = findEvents(events, idx + 1, cnt, dp);
            if (nextNonOlapInx < events.length && events[nextNonOlapInx][START_TIME] > currentEventEnd) {
                // Add the value of current event to the value of future choice.
                dp[idx][cnt] = Math.max(events[idx][VALUE] + findEvents(events, nextNonOlapInx, cnt + 1, dp), exclude);
            } else {
                // No further choices may be made. It's the current choice vs excluding it
                dp[idx][cnt] = Math.max(events[idx][VALUE], exclude);
            }
        }
        return dp[idx][cnt];
    }

    private int binarySearch(int[][] events, int lo, int hi, int curEventEnd) {
        // Binary Search
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (events[mid][START_TIME] > curEventEnd) hi = mid;
            else lo = mid + 1;
        }    
        return lo;
    }
}