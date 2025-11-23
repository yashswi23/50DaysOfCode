class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int sum=0;
        ArrayList<Integer> mod1= new ArrayList<>();
        ArrayList<Integer> mod2= new ArrayList<>();
        int opt1=Integer.MIN_VALUE;
        int opt2= Integer.MIN_VALUE;
        for(int n:nums){
            sum=sum+n;
            if(n%3==1)mod1.add(n);
            if(n%3==2)mod2.add(n);
        }
        Collections.sort(mod1);
        Collections.sort(mod2);

        if(sum%3==0){
            return sum;
        } 
        else if(sum%3==1){
            if(!mod1.isEmpty())opt1=sum-mod1.get(0);
            if(mod2.size()>=2)opt2=sum-mod2.get(0)-mod2.get(1);
        } else if(sum%3==2){
            if(!mod2.isEmpty())opt1=sum-mod2.get(0);
            if(mod1.size()>=2)opt2=sum-mod1.get(0)-mod1.get(1);
        }
        return Math.max(opt1,opt2);
    }
}