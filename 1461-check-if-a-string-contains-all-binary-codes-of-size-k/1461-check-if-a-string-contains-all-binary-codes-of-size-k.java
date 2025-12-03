class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int need = 1<<k; // equal to 2^k => no of possible binary Substrings of length k

        HashSet<String> st = new HashSet<>();

        for(int i=0;i+k<=n;i++){
            String sub = s.substring(i,i+k);
            st.add(sub);

            if(st.size()== need){
                return true;
            }

        }

        return false;

    }
}