class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        for(int i=0;i<=s.length()-3;i++){
            HashSet<Character> set = new HashSet<>();
            char ch=s.charAt(i);  
            set.add(ch);
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));
            if(set.size()==3){
                count++;
            }
        }
        return count;
    }
}