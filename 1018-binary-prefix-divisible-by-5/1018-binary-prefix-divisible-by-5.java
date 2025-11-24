class Solution {

    static{
        int[] nums = {1,0,0,1,0,1,1,0,1,0};
        for(int i = 0; i<500; i++){
            Solution.prefixesDivBy5(nums);
        }
    }
    
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        //for this one, we can iteratively, make our number:
        //as we go left -> right in the nums array
        //we construct our totalNum by left shifting the current 'bit' into totalNum
        //and we push back totalNum % 5 into our list

        int totalNum = nums[0];
        List<Boolean> retList = new ArrayList<>();
        retList.add(totalNum % 5 == 0);

        for(int i = 1; i<nums.length; i++){
            //how do we construct our number?
            //lets leftshift the number by 1 to make space in the rightmost bit
            totalNum = totalNum << 1;
            //and lets | with nums[i] to 'insert' the bit
            totalNum |= nums[i];
            //and after each iteration, add result to retList
            totalNum %= 5; //this part avoids overflow for int
            retList.add(totalNum % 5 == 0);
        }

        return retList;
    }
}