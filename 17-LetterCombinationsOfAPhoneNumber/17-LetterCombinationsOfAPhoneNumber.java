// Last updated: 7/9/2026, 3:10:21 PM
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, "", digits, 0, map);
        return result;
    }

    private void backtrack(List<String> result, String current,
                           String digits, int index, String[] map) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            backtrack(result, current + c, digits, index + 1, map);
        }
    }
}