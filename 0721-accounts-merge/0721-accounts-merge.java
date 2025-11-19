class Solution {
    class DSU{
        int par[];
        DSU(int n){
            par= new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }
        }

        int find(int i){
            if(i==par[i]){
                return par[i];
            }
             return par[i] = find(par[i]);

            
        }

        void union(int x, int y){
            int par_x = find(x);
            int par_y = find(y);

            if(par_x == par_y) return;

            if(par_x!=par_y){
                par[par_x]= par_y;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> emname = new HashMap<>();
        Map<String,Integer> emid = new HashMap<>();
        int id=0;

        for(List<String> acc: accounts){
            String name = acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email= acc.get(i);
                if(!emid.containsKey(email)){
                    emid.putIfAbsent(email,id++);
                    emname.put(email,name);
                }
            }
        }

        DSU dsu = new DSU(id);

       for(List<String> acc: accounts){
        int first = emid.get(acc.get(1));
        for(int i=2;i<acc.size();i++){
            dsu.union(first,emid.get(acc.get(i)));
        }
       }


       //group them cooardin to their root parent
    Map<Integer,List<String>> groups = new HashMap<>();
    for(String email: emid.keySet()){
        int root = dsu.find(emid.get(email));
        groups.putIfAbsent(root,new ArrayList<>());
        groups.get(root).add(email);
    }

    List<List<String>> res = new ArrayList<>();
    for(List<String> list: groups.values()){
        Collections.sort(list);
        List<String> temp = new ArrayList<>();
        temp.add(emname.get(list.get(0)));
        temp.addAll(list);
        res.add(temp);
    }

    return res;
    }
}