package LeetCode.HeapReal;

import java.util.*;

/**
 * 实现比较的方式是实现Comparable接口
 * 或者实现Comparator比较器
 */
public class HeapSortRelization {
    static List<Contest> contests = new ArrayList<Contest>();
    static List<Contest.Contest2> contests2 = new ArrayList<Contest.Contest2>();
    static class Contest {
        static int weight;
        static int length;
        public Contest(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    static class Contest2 implements Comparable {
        static int weight;
        static int length;

        public Contest2(int weight, int length) {

            this.weight = weight;
            this.length = length;
        }

        @Override
        public int compareTo(Object o) {
            Contest2 s = (Contest2) o;
            if (this.weight == s.weight) {
                return this.length - s.length;
            } else {
                return this.weight - s.weight;
            }
        }
    }
}
    public static void main(String[] args) {

        Collections.sort(contests, new Comparator<Contest>() {
            @Override
            public int compare(Contest o1, Contest o2) {
                if (o1.weight == o2.weight) {
                    return o1.length - o2.length;
                } else {
                    return o1.weight-o2.weight;
                }
            }
        });

        contests.sort(new Comparator<Contest>() {
            @Override
            public int compare(Contest o1, Contest o2) {
                if (o1.weight == o2.weight) {
                    return o1.length - o2.length;
                } else {
                    return o1.weight-o2.weight;
                }
            }
        });
        Contest.Contest2 t1 = new Contest.Contest2(10, 10);
        Contest.Contest2 t2 = new Contest.Contest2(9, 11);
        contests2.add(t1);
        contests2.add(t2);
        Collections.sort(contests2);

    }
}
