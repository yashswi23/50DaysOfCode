class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] firstLast = new int[26][2];
        for (int[] arr: firstLast) Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i), c2 = s.charAt(n-1-i);
            if (firstLast[c1-'a'][0] == -1) firstLast[c1-'a'][0] = i;
            if (firstLast[c2-'a'][1] == -1) firstLast[c2-'a'][1] = n-1-i;
        }
        int res = 0;
        for (int[] arr: firstLast) {
            int start = arr[0], end = arr[1];
            Set<Character> set = new HashSet<>();
            for (int i = start+1; i < end; i++) {
                set.add(s.charAt(i));
            }
            res += set.size();
        }
        return res;
    }
}