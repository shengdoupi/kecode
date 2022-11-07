package twopointer.lc75;

/**
 * @author zhouke <zhouke1998301@sjtu.edu.cn>
 * Created on 2022-11-07
 * 时间：O(n)，n为数组大小
 * 空间：O(1)，两个辅助指针，置换均为原地
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }

    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
