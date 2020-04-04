package LeetCode.zhaohang;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class mugun{
    static class Node{
        int l;
        int w;
        public Node(int l, int w) {//节点
            this.l = l;
            this.w = w;
        }
    }
    public static void sorted(Node[] nodes){
        Arrays.sort(nodes,new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.l == o2.l){
                    return o1.w-o2.w;
                }
                return o1.l-o2.l;
            }
        });
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while((t--)>0){
            int n=in.nextInt();
            Node[] nodes=new Node[n];
            Node[] res=new Node[n];
            int[] ll = new int[n];
            int[] ww = new int[n];
            for (int i = 0; i < n; i++) {
                ll[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                ww[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nodes[i]=new Node(ll[i],ww[i]);
            }

            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.l==o2.l){
                        return o1.w-o2.w;
                    }
                    return o1.l-o2.l;
                }
            });
            int ans=0;
            boolean flag=true;
            for (int i = 0; i < n; i++) {
                flag=true;
                for (int j = 0; j < n; j++) {
                    if(nodes[i].l>=res[j].l && nodes[i].w>=res[j].w){
                        res[j].l=nodes[i].l;
                        res[j].w=nodes[i].w;
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    res[ans++]=new Node(nodes[i].l,nodes[i].w);
                }
            }
            System.out.println(ans);
        }
    }
}