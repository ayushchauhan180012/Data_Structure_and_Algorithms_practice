class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(String s, int start,
                           List<String> list,
                           List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (isPalindrome(s, start, i)) {

                list.add(s.substring(start, i + 1));

                backtrack(s, i + 1, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}