class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            int num = (int)(c - 'a');
            cnt[num] += 1;
        }

        for(int i = 0; i < s.length(); i++){
            int num = (int)(s.charAt(i) - 'a');
            if(cnt[num] == 1) return i;
        }
        return -1;
    }
}
