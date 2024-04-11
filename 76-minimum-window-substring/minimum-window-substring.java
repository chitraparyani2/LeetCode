class Solution {
    /*

    --
            l, r
        S -> ADOBECODEBANC (N2* N -> N3)
        T -> ABC

        Map -> charcter, count

        Everything becomes 0 -> 
        counter -> once value becomes 0

        AABC

        A ,2

    */
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> countMap = new HashMap<>();
        for(Character ch : t.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        int count = countMap.size(); // no of unique characters in target string

        int st = 0, e = 0;

        int counter = 0;

        int len = Integer.MAX_VALUE, si = -1, ei = -1;
        // left, right
        // 1. while -> (right < length of String)
        // 2. take character from right pointer
        // 3. Do app operation on it
        // 4. Check the condtion where you need to move left pointer
        // 5. while -> (left <= right)
        // 6. now take the left char and reset/reduce the appropriate operation
        // 7. when to break and start pointer ++
        // 8. Outside second while -> increment right pointer
        while(e < s.length()){

            char ch = s.charAt(e);

            if(countMap.containsKey(ch)){
                countMap.put(ch, countMap.get(ch) - 1);
                if(countMap.get(ch) == 0){
                    counter++;
                }
            }


                while(st <= e && counter == count){
                    if(len > e - st + 1){
                        len = e - st + 1;
                        si = st;
                        ei = e;
                    }
                    char chSt = s.charAt(st);
                    if(countMap.containsKey(chSt)){
                        countMap.put(chSt, countMap.get(chSt) + 1);
                        if(countMap.get(chSt) == 1){
                            counter--;  
                        }
                    }
                    st++;
                }

            e++;

        }

        return si == -1?"":s.substring(si, ei + 1);

    }
}