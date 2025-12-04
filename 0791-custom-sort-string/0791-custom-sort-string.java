
class Solution 
{
    public String customSortString(String order, String s) 
    {
        String temp = "";
        Map<Character,Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        for(char ch : order.toCharArray())
        {
            if(map.containsKey(ch))
            {
                temp += String.valueOf(ch).repeat(map.get(ch));
                map.remove(ch);
            }
        }
        for(char ch : map.keySet())
        {
            temp += String.valueOf(ch).repeat(map.get(ch));
        }
        return temp;
    }
}