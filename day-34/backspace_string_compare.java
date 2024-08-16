class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = helper(s);
        String s2 = helper(t);

        return s1.equals(s2);    
    }
    static String helper(String str){
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i=0; i<len; i++){
            if(str.charAt(i)!='#'){
                stk.push(str.charAt(i));
            }else{
                if(stk.isEmpty()){
                    continue;
                }
                stk.pop();
            }
        }
        while(stk.isEmpty() !=true){
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}



