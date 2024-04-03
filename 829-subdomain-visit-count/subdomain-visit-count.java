class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(String str : cpdomains) {

            String[] strArray = str.split(" ");

            int count = Integer.valueOf(strArray[0]);
            
            String s = strArray[1];

            String[] temp = s.split("\\.");
            String ans = "";

            for(int i=temp.length-1; i>=0; i--) {

                if(i != temp.length-1) {
                    ans = temp[i] + "." + ans;
                } else {
                    ans = temp[i];
                }
                System.out.println("ans " + ans + " " + count);
              map.put(ans, map.getOrDefault(ans, 0) + count);

            //   if(!map.containsKey(ans)) {
            //     map.put(ans, count);
            //   } else {
            //     map.put(ans, map.get(ans) + count);
            //   }


            }

            
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getValue() + " " + entry.getKey();
            result.add(str);
        }

        return result;
    }
}