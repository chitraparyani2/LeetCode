class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for(String str : cpdomains) {

            String[] parts = str.split("\\ ");
            int part0 = Integer.parseInt(parts[0]);
            String[] subd = parts[1].split("\\.");

            int n = subd.length;
            StringBuilder sb = new StringBuilder();

            for(int i=n-1; i>=0; i--) {

                if(i != n-1) {
                    sb.reverse();
                    sb.append(".");
                    sb.append(new StringBuilder(subd[i]).reverse());
                    sb.reverse();
                } else {
                    sb.append(subd[i]);
                }
                countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + part0);
            }
        }

        for(String key : countMap.keySet()) {
            res.add(new String(countMap.get(key) + " " + key));
        }

      return res;  
    }
}