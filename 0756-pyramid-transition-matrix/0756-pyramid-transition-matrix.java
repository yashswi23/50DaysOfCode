class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int len = bottom.length();
        final Map<String, List<Character>> combination = new HashMap<>();
        final Map<String, Boolean> memo = new HashMap<>();

        for (final String s : allowed) {
            final String prefix = s.substring(0, 2);
            final Character c = s.charAt(2);
            final List<Character> topChars = combination.computeIfAbsent(prefix, k -> new ArrayList<>());
            topChars.add(c);
        }
        return traverse(bottom, combination, memo, new StringBuilder());
    }

    private boolean traverse(
        final String bottom, 
        final Map<String, List<Character>> combination,
        final Map<String, Boolean> memo,
        final StringBuilder sb)
    {
        if (bottom.length() == 1) return true;

        int pairIndex = sb.length();

        if (sb.length() == 0 && memo.containsKey(bottom)) return memo.get(bottom);

        if (pairIndex == bottom.length() - 1) {
            return traverse(sb.toString(), combination, memo, new StringBuilder());
        }

        final String prefix = new String(new char[]{bottom.charAt(pairIndex), bottom.charAt(pairIndex + 1)});
        final List<Character> topChars = combination.getOrDefault(prefix, Collections.emptyList());

        for (Character c : topChars) {
            sb.append(c);
            if (traverse(bottom, combination, memo, sb)) {
                memo.put(bottom, true);
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        memo.put(bottom, false);
        return false;
    }
}