
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    void solve(List<String> ans, StringBuilder sb,
               int open, int close, int n) {

        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            solve(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            solve(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
