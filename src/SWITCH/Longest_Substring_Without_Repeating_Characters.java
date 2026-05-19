package SWITCH;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstrApproach2(s));
    }
    public static int longestUniqueSubstrApproach1(String s){
        int n = s.length(), res = 0;
        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[26];//default false;
            for(int j=i;j<n;j++){
                if(visited[s.charAt(j) - 'a'])
                    break;
                else{
                    res = Math.max(res, j-i+1);
                    visited[s.charAt(j)-'a'] = true;
                }
            }
        }
        return res;
    }
    public static int longestUniqueSubstrApproach2(String s){
        int left = 0, right = 0, res = 0;
        boolean[] visited = new boolean[26];
        while(right < s.length()){
            while(visited[s.charAt(right)-'a']){
                visited[s.charAt(left)-'a'] = false;
                left++;
            }
            visited[s.charAt(right)-'a'] = true;
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int longestUniqueSubstrApproach3(String s){
        int n = s.length();
        int res = 0;

        int[] lastIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            lastIndex[i] = -1;
        }

        int start = 0;
        for (int end = 0; end < n; end++) {

            // Find the last index of s[end]
            // Update starting index of current window as
            // maximum of current value of end and last index + 1
            start = Math.max(start, lastIndex[s.charAt(end) - 'a'] + 1);

            // Update result if we get a larger window
            res = Math.max(res, end - start + 1);

            // Update last index of s[end]
            lastIndex[s.charAt(end) - 'a'] = end;
        }
        return res;
    }

}
