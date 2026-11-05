class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
            '1', "",
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );
        StringBuilder diary = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(map,digits,digits.length(),0,diary,res);
        return res;

    }

    public void backtrack(Map<Character, String> map,String digit,int n,int idx,StringBuilder diary, List<String> res){
        if(idx==n){
            res.add(diary.toString());
            return;
        }

        char[] choices = map.get(digit.charAt(idx)).toCharArray();

        for(int i=0; i<choices.length; i++){
            diary.append(choices[i]);
            backtrack(map,digit,n,idx+1,diary,res);
            diary.deleteCharAt(diary.length()-1);
        }
        return;
    }
}