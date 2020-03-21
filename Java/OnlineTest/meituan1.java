package OnlineTest;

import java.util.Scanner;

/**
 * topn问题
 */

public class meituan1 {
    public static void partitionSort(int[] nums,int low,int high,int k){
        if (low < high){
            int pointKey = partitionSortCore(nums,low,high);
            if(k-1 == pointKey){
                return;
            }
            partitionSort(nums,low,pointKey-1,k);
            partitionSort(nums,pointKey+1,high,k);
        }
    }

    public static int partitionSortCore(int[] nums,int low,int high){
        int pivokey = nums[low];
        while(low<high){
            while (low < high && pivokey <= nums[high]){
                --high;
            }
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            while(low<high && pivokey >= nums[low]){
                ++low;
            }
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return  low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nums2[i] = sc.nextInt();
            }
            partitionSort(nums1,0,nums1.length-1,3);
            partitionSort(nums2,0,nums2.length-1,3);
            int res1 = 0,res2 = 0;
            int m = n-1;
            for(int i = 0;i<3;i++){
                res1 += nums1[m--];
            }
            m = n-1;
            for(int i = 0;i < 3;i++)
                res2 += nums2[m--];
            if(res1 < res2) System.out.println(res2);
            else System.out.println(res1);
        }
    }
}
