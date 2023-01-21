class Solution {
    List<String> addresses;
    public List<String> restoreIpAddresses(String s) {
        addresses = new ArrayList();
        
        restoreIpAddressesHelper(s, 0, 0, new StringBuilder());
        
        return addresses;
    }
    
    private void restoreIpAddressesHelper(String s, int index, int dots, StringBuilder sb) {
        if(dots == 4) {
            if(index == s.length()) {
                addresses.add(new String(sb));
            }
            return;
        }
        
        int n = sb.length();
        
        for(int i = index; i<index+3; i++) {
            if(i >= s.length()) break;
            String substr = s.substring(index, i+1);
            StringBuilder curr = new StringBuilder(substr);
            
            if(curr.charAt(0) == '0' && curr.length() > 1) {
                continue;
            }
            if(Integer.parseInt(curr.toString()) > 255) {
                continue;
            }
            
            if(dots < 3) {
                curr.append('.');
            } 
            
            restoreIpAddressesHelper(s, i+1, dots+1, sb.append(curr));
            sb.delete(n, n+curr.length());
        }
    }
}