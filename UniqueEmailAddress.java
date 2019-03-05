class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> addrSet = new HashSet<>();
        for(String email : emails) addrSet.add(filterEmail(email));
        return addrSet.size();
    }

    private String filterEmail(String email){
        String res;
        int plusPos = email.indexOf('+');
        int atPos = email.indexOf('@');
        if(plusPos >= 0) res = email.substring(0, plusPos);
        else res = email.substring(0, atPos);
        res = res.replaceAll("\\.", "");
        res += email.substring(atPos);
        return res;
    }
}