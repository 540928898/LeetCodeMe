package LeetCode.Meituan;

import java.util.ArrayList;
import java.util.Stack;

public class dierti {
    public void LIS(String s){
        ArrayList<Long> a1 = new ArrayList();
        for (int i = 1; i < s.length(); i++) {
            a1.add(Long.parseLong(String.valueOf(s.charAt(i))));
        }
        ArrayList a2 = new ArrayList();
        Stack<Long> t1 = new Stack();
        for (int i = 0; i < a1.size(); i++) {
            if (t1.size() == 0 || a1.get(i) - a1.get(i - 1) > 0){
                t1.push(a1.get(i));
            }else {
                int count = 0;
                while (t1.size() >0){
                    count += 1;
                    t1.pop();
                }
            }
        }

    }
}
