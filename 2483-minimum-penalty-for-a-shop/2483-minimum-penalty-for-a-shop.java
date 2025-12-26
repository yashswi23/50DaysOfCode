class Solution {
    public int bestClosingTime(String customers) {
        int maxiPen = Integer.MIN_VALUE;
        int pen = 0;
        char[] customer = customers.toCharArray();

        // Initial penalty: count of 'N'
        for (char c : customer) {
            if (c == 'N') {
                pen++;
            }
        }

        maxiPen = pen;
        int best = 0;

        int i = 0;
        for (char c : customer) {
            if (c == 'Y') {
                pen--;
            } else {
                pen++;
            }

            if (maxiPen > pen) {
                maxiPen = pen;
                best = i + 1;
            }
            i++;
        }

        return best;
    }
}