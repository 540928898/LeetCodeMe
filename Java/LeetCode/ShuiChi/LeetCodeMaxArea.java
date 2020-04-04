package LeetCode.ShuiChi;

public class LeetCodeMaxArea {
    /**
     * 两边按照较短的边进行缩小就可以，一定可以覆盖最大值。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int N = height.length;
        int left = 0;
        int right =N-1;
        int res = Math.min(height[left],height[right])*(right-left);
        while(left < right){
            if(height[left]< height[right]){
                left += 1;
                res = Math.max(res,Math.min(height[left],height[right])*(right-left));
            }else{
                right -= 1;
                res = Math.max(res,Math.min(height[left],height[right])*(right-left));

            }
        }
        return res;
    }
}
