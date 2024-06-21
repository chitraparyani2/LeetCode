class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();

        for(String email : emails) {

            String[] parts = email.split("\\@");

            String part1 = parts[0];

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<part1.length(); i++) {

                char ch = part1.charAt(i);

                if(ch == '.') {
                    continue;
                } else if(ch == '+') {
                    break;
                }

                sb.append(ch);
            }

            set.add(sb.toString()+ "@" + parts[1]);
          //  System.out.println(sb.toString()+ "@" + parts[1]);
        }

      return set.size();  
    }
}