/*
Given a keypad as shown in the diagram, and an N digit number which is represented by array a[ ], the task is to list all words which are possible by pressing these numbers.


Example 1:

Input: N = 3, a[] = {2, 3, 4}
Output:
adg adh adi aeg aeh aei afg afh afi 
bdg bdh bdi beg beh bei bfg bfh bfi 
cdg cdh cdi ceg ceh cei cfg cfh cfi 
Explanation: When we press 2,3,4 then 
adg, adh, adi, ... cfi are the list of 
possible words.
*/

class KeypadProblem {
    
    static ArrayList <String> possibleWords(int a[], int n) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");
        ArrayList<String> ans = new ArrayList<>();
        int[] ind = new int[n];
        find(ans, hm, ind, 0, a, n);
        return ans;
    }
    
    static void find(ArrayList<String> ans, HashMap<Integer, String> hm,
        int[] ind, int count, int[] a, int n) {
        if (count == n) {
            String temp = "";
            for(int i = 0; i < n; i++) {
                temp += (hm.get(a[i])).charAt(ind[i]);
            }
            ans.add(temp);
            return;
        }
        for(int i = 0; i < (hm.get(a[count])).length(); i++) {
            ind[count] = i;
            find(ans, hm, ind, count + 1, a, n);
        }
    }
}


