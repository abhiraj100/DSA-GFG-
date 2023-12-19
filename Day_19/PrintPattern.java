/*
Print a sequence of numbers starting with N, without using loop, where replace N with N - 5, until N > 0. After that replace N with N + 5 until N regains its initial value.

Example 1:

Input: 
N = 16
Output: 
16 11 6 1 -4 1 6 11 16
Explaination: 
The value decreases until it is greater than 0. After that it increases and stops when it becomes 16 again.
Example 2:

Input: 
N = 10
Output: 
10 5 0 5 10
Explaination: It follows the same logic as per the above example.
*/    

class PrintPattern{
    public List<Integer> pattern(int N){
        
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
