class Solution {
    public String reversePrefix(String word, char ch) {
        
        int index = word.indexOf(ch);

        if(index == -1) {
            return word;
        }

        String sub = word.substring(0, index+1);

        StringBuilder sb = new StringBuilder();
        sb.append(sub);
        sb.reverse();
        sb.append(word.substring(index+1, word.length()));

        return sb.toString();
    }
}