class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashMap<Long , Long> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            map.put(a1[i] , map.getOrDefault(a1[i] , (long) 0) + 1);
        }
        
        for(int i = 0 ; i < m ; i++){
            
            if(map.get(a2[i]) == null || map.get(a2[i]) == 0) {
                return "No";
            }
            else {
                map.put(a2[i] , map.get(a2[i]) - 1);
            }
        }
        return "Yes";
    }
}