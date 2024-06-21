class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        char maxChar = '_';
        int maxFreq = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.get(ch) > maxFreq) {
                maxFreq = map.get(ch);
                maxChar = ch;
            }
        }

        if(maxFreq > (n+1)/2) {
            return "";
        }

        int index = 0;
        char[] arr = new char[n];

        for(int i=0; i<maxFreq; i++) {
            arr[index] = maxChar;
            index+=2;
        }

        map.remove(maxChar);

        for(int i=0; i<s.length(); i++) {
            if(index>= n) {
                index=1;
            }
            char ch = s.charAt(i);
            int val = map.getOrDefault(ch,0);

            for(int j=0; j<val; j++) {
                if(index>=n) {
                    index=1;
                }
                arr[index] = ch;
                index+=2;
            }
            map.remove(ch);
        }
       return new String(arr);
    }
}