// Last updated: 7/9/2026, 3:09:37 PM
class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 1; j <= result.length(); j++) {
                if (j < result.length() &&
                    result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            result = sb.toString();
        }

        return result;
    }
}