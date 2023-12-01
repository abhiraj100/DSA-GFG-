class Solution{
    public List<Integer> pattern(int N){
        // code here
        
        List<Integer> li = new ArrayList<Integer>();
        if(N == 0 || N < 0){
            li.add(N);
            return li;
        }
        li.add(0,N);
        int i=0;
        do{
            li.add(i+1, (li.get(i)-5));
            i++;
        }while(li.get(i)>0);
        
        do{
            li.add(i+1,(li.get(i)+5));
            i++;
        }while(li.get(i) < N);
      
    return li;

    }
}