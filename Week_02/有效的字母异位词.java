package byc.imagewatcher.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 有效的字母异位词 {
    //方法一
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int a[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int num : a) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    //方法二
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
