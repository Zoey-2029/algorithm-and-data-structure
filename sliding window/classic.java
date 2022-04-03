
/*
 * Classic sliding window problems
 * 3: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 159: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 340: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * there are two mian ways to do this, and which one is better depends on the occasion
 */


// 1: record the count of each occurence
public int getLongest(String s, int k) {
    Map<Character, Integer> dict = new HashMap<>();
    int len = s.length();
    int left = 0, ans = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        dict.put(ch, right);
        
        while (dict.size() > k) {
            char leftChar = s.charAt(left++);
            dict.put(leftChar, dict.get(LeftChar) - 1);
            if (dict.get(leftChar) == 0) dict.remove(leftChar);
        }
        ans = Math.max(ans, right - left + 1);
    }
        
    return ans;
}

// 2: record the most righgmost position of the occurence
public int getLongest(String s, int k) {
    Map<Character, Integer> dict = new HashMap<>();
    int len = s.length();
    int left = 0, ans = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        dict.put(ch, right);
        
        if (dict.size() > k) {
            int minLeft = Collections.min(dict.values());
            dict.remove(s.charAt(minLeft));
            left = minLeft + 1;
        }
        ans = Math.max(ans, right - left + 1);
    }
        
    return ans;
}