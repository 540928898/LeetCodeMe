package LeetCode.ShuiChi;

/**
 * 分别记录左边和右边的最大值。
 */
public class XuShuiChi {
    public int trap(int[] height) {
        int N = height.length;
        if(N <= 2) return 0;
        int min1 = 0;
        int max1 = 0;
        int left = 0;
        int right = N-1;
        int res = 0;
        while(left < right){
            if(height[left] < height[right]){
                if (height[left] >= min1){
                    min1 = height[left];
                }
                else{
                    res += min1-height[left];
                }
                left += 1;
            }else{
                if (height[right] >= max1){
                    max1 = height[right];
                }else{
                    res +=  max1 - height[right];
                }
                right -= 1;
            }
        }
        return res;
    }
}
