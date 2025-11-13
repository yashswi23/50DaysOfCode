class Solution {
    public int maxOperations(String s) {

        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur == '0' && str.charAt(str.length() - 1) == '0') continue;
            str.append(cur);
        }
        s = str.toString();
        System.out.println("newStr: " + s);
        int spaceCount = 0;
        int endIt = s.length() - 1;
        while (endIt >= 0 && s.charAt(endIt) == '1') --endIt;
        int res = 0;
        int startIt = 0;
        while (startIt < s.length()) {
            if (s.charAt(startIt) == '0') ++startIt;
            else break;
        }
        if (startIt == endIt) return 0;
        System.out.println("start: " + startIt);
        System.out.println("end: " + endIt);
        int low = startIt;
        int onesCount = 0;
        for (int i = startIt; i <= endIt; ++i) {
            char cur = s.charAt(i);
            if (cur == '0') {
                int tmp = res;
                System.out.println("tmp: " + tmp);
                System.out.println("onesCount: " + onesCount);
                res += onesCount;
            } else ++onesCount;
        }
        return res;
    }
}