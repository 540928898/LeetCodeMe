package LeetCode.ShuiChi;

import LeetCode.zhaohang.ErCiSorted;

/**
 * 单调栈
 *
 */
public class zuidamianji extends ErCiSorted {
    public void getNode(){
        Node1 t1 = super.getNode(1);
        System.out.println(t1.l);
    }
    public static void main(String[] args) {
        zuidamianji t1 = new zuidamianji();
        t1.getNode();
    }
}
