class Solution {
    public int fillCups(int[] amount) {
        int n = amount.length;

        int maxval=Math.max(amount[0],Math.max(amount[1],amount[2]));
        int sum= amount[0]+amount[1]+amount[2];


        return Math.max(maxval, (sum+1)/2);


    }
}