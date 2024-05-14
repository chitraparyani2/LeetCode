class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();

        for(int i=0; i<emails.length; i++) {

            String str = emails[i];
            StringBuilder sb = new StringBuilder();
            boolean flag = false;

            for(int j=0; j<str.length(); j++) {

                char ch = str.charAt(j);

                if(ch == '.' && !flag) {
                    continue;
                } else if(ch == '+' && !flag) {
                    int ind = str.indexOf('@');
                    j=ind-1;
                    flag = true;
                } else if(ch == '@') {
                    sb.append(ch);
                    flag = true;
                } else {
                    sb.append(ch);
                }
            }
           // System.out.println(sb.toString() + " ");
            set.add(sb.toString());
            
        }
      return set.size();  
    }
}