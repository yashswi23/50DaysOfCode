class Solution {
    public int minDeletionSize(String[] strs) {
        int col = strs[0].length(), row = strs.length, count = 0;
        // Keeps track of rows which are already sorted, i.e., if any row is sorted then its
        // further columns need not to be verified again in later iterations.
        Set<Integer> idx = new HashSet<>();

        for(int i = 0; i < col; i++) {
            int j = 0;
            // Keeps track of possible valid rows for current column iteration
            // This will only be added to the final idx of valid row when the,
            // entire column is valid, i.e., j == row - 1;
            Set<Integer> subIdx = new HashSet<>();
            for(;j < row - 1; j++) {
                String strA = strs[j];
                String strB = strs[j + 1];
                // If any row which has already been marked as valid during iteration of
                // previous columns then those rows need not to be verified again and can be skipped.
                if(!idx.contains(j)) {
                    char a = strA.charAt(i);
                    char b = strB.charAt(i);
                    if(a > b) {
                        count++;
                        break;
                    }
                    else if(a < b) {
                        // adding probable valid row.
                        subIdx.add(j);
                    }
                }
            }
            if(j == row - 1) {
                // added to the final set of valid rows only if the entire column is fully
                // traversed, which confirms that the current column if sorted in ascending order.
                idx.addAll(subIdx);
            }
        }

        return count;
    }
}