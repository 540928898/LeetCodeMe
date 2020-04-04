package LeetCode.zhaohang;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ErCiSorted {
    protected static Integer t1 = 10;
    public static Integer t2 = 10;
    public static class Node1{
        public int l;
        public int w;
        public Node1(int l, int w) {//节点
            this.l = l;
            this.w = w;
        }
    }
    protected static Node1 getNode(int l){
        return new Node1(l,l+1);
    }

    public static void main(String[] args) {
        List<Node1> nodes = IntStream.range(0, 2)
                .mapToObj(ErCiSorted::getNode)
                .collect(Collectors.toList());
        nodes.sort(new Comparator<Node1>() {
            @Override
            public int compare(Node1 o1, Node1 o2) {
                return 0;
            }
        });
    }
}
