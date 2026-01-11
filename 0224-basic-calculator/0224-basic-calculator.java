class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        int res=0;
        int num=0;
        int sign=1;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10+(ch-'0');
            }
            else if(ch =='+'){
                res+=(num*sign);
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                res+=(num*sign);
                num=0;
                sign=-1;
            }
            else if(ch=='('){
                st.add(res);
                st.add(sign);

                num=0;
                res=0;
                sign=1;
            }
            else if(ch==')'){
                res+=(num*sign);
                num=0;

                int st_sign = st.pop();
                int st_res = st.pop();
                res*=st_sign;
                res+=st_res;
            }

        }

        res+=(num*sign);
        return res;
    }
}