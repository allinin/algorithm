package codeTop;

import java.util.Stack;

public class Leetcode224 {
        public static int calculate(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int res = 0,idx = 0;
            Stack<Integer> stack = new Stack<>();
            s = s.trim();
            int n = s.length();
            while(idx < n){
                char c = s.charAt(idx++);
                if(c == ' '){
                    continue;
                }
                if(Character.isDigit(c)){
                    int tmp = c - '0';
                    while(idx < n && Character.isDigit(s.charAt(idx))){
                        tmp = tmp * 10 + s.charAt(idx++) - '0';
                    }
                    stack.push(tmp);
                }else if(c == '+'){
                    if(Character.isDigit(s.charAt(idx))){
                        int tmp = s.charAt(idx++) - '0';
                        while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                            tmp = tmp * 10 + s.charAt(idx++) - '0';
                        }
                        stack.push(tmp);
                    }else {
                        //碰到了(
                        int[] ans = process(s,++idx);
                        stack.push(ans[0]);
                        idx = ans[1];
                    }
                }else if(c == '-'){
                    if(Character.isDigit(s.charAt(idx))){
                        int tmp = s.charAt(idx++) - '0';
                        while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                            tmp = tmp * 10 + s.charAt(idx++) - '0';
                        }
                        stack.push(-tmp);
                    }else {
                        //碰到了(
                        int[] ans = process(s,++idx);
                        stack.push(-ans[0]);
                        idx = ans[1];
                    }
                }else{
                    int[] ans = process(s,idx);
                    stack.push(ans[0]);
                    idx = ans[1];
                }
            }
            while(!stack.isEmpty()){
                res += stack.pop();
            }
            return res;
        }

        /**
         *碰到了(的处理
         */
        private static int[] process(String s,int idx){
            int[] ans = new int[2];
            Stack<Integer> stack = new Stack<>();
            while(idx < s.length() && s.charAt(idx) != ')'){
                char c = s.charAt(idx++);
                if(c == ' '){
                    continue;
                }
                if(Character.isDigit(c)){
                    int tmp = c - '0';
                    while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                        tmp = tmp * 10 + s.charAt(idx++) - '0';
                    }
                    stack.push(tmp);
                }else if(c == '+'){
                    if(Character.isDigit(s.charAt(idx))){
                        int tmp = s.charAt(idx++) - '0';
                        while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                            tmp = tmp * 10 + s.charAt(idx++) - '0';
                        }
                        stack.push(tmp);
                    }else {
                        //碰到了(
                        int[] help = process(s,++idx);
                        stack.push(help[0]);
                        idx = help[1];
                    }
                }else if(c == '-'){
                    if(Character.isDigit(s.charAt(idx))){
                        int tmp = s.charAt(idx++) - '0';
                        while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                            tmp = tmp * 10 + s.charAt(idx++) - '0';
                        }
                        stack.push(-tmp);
                    }else {
                        //碰到了(
                        int[] help = process(s,++idx);
                        stack.push(-help[0]);
                        idx = help[1];
                    }
                }else if(c == '('){
                    int[] help = process(s,idx);
                    stack.push(help[0]);
                    idx = help[1];
                }
            }

            while(!stack.isEmpty()){
                ans[0] += stack.pop();
            }
            ans[1] = ++idx;
            return ans;
        }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
