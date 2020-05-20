package com.example.algorithm.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/2 11:32
 * @description: 三数之和
 */
public class Code15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{2597,
                -9243,
                62390,
                83030,
                -97960,
                -26521,
                -61011,
                83390,
                -38677,
                12333,
                75987,
                46091,
                83794,
                19355,
                -71037,
                -6242,
                -28801,
                324,
                1202,
                -90885,
                -2989,
                -95597,
                -34333,
                35528,
                5680,
                89093,
                -90606,
                50360,
                -29393,
                -27012,
                53313,
                65213,
                99818,
                -82405,
                -41661,
                -3333,
                -51952,
                72135,
                -1523,
                26377,
                74685,
                96992,
                92263,
                15929,
                5467,
                -99555,
                -43348,
                -41689,
                -60383,
                -3990,
                32165,
                65265,
                -72973,
                -58372,
                12741,
                -48568,
                -46596,
                72419,
                -1859,
                34153,
                62937,
                81310,
                -61823,
                -96770,
                -54944,
                8845,
                -91184,
                24208,
                -29078,
                31495,
                65258,
                14198,
                85395,
                70506,
                -40908,
                56740,
                -12228,
                -40072,
                32429,
                93001,
                68445,
                -73927,
                25731,
                -91859,
                -24150,
                10093,
                -60271,
                -81683,
                -18126,
                51055,
                48189,
                -6468,
                25057,
                81194,
                -58628,
                74042,
                66158,
                -14452,
                -49851,
                -43667,
                11092,
                39189,
                -17025,
                -79173,
                13606,
                83172,
                92647,
                -59741,
                19343,
                -26644,
                -57607,
                82908,
                -20655,
                1637,
                80060,
                98994,
                39331,
                -31274,
                -61523,
                91225,
                -72953,
                13211,
                -75116,
                -98421,
                -41571,
                -69074,
                99587,
                39345,
                42151,
                -2460,
                98236,
                15690,
                -52507,
                -95803,
                -48935,
                -46492,
                -45606,
                -79254,
                -99851,
                52533,
                73486,
                39948,
                -7240,
                71815,
                -585,
                -96252,
                90990,
                -93815,
                93340,
                -71848,
                58733,
                -14859,
                -83082,
                -75794,
                -82082,
                -24871,
                -15206,
                91207,
                -56469,
                -93618,
                67131,
                -8682,
                75719,
                87429,
                -98757,
                -7535,
                -24890,
                -94160,
                85003,
                33928};
        long start1 = System.currentTimeMillis();
        System.out.println("三数之和结果:" + threeSum(nums));
        System.out.println("耗时：" + (System.currentTimeMillis() - start1) + "ms");
        long start2 = System.currentTimeMillis();
        System.out.println("三数之和——暴力求解结果:" + threeSum1(nums));
        System.out.println("耗时：" + (System.currentTimeMillis() - start2) + "ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        //从小到大排序，如果首位的数大于0，则肯定不存在三数和为0的
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            int left = i + 1, right = len - 1;
            //去重数据
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
            }
        }
        return ans;
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int k = i + 1; k < len - 1; k++) {
                for (int j = k + 1; j < len; j++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                    }
                }
            }
        }
        Set set = new HashSet(ans);
        ans.clear();
        ans.addAll(set);
        return ans;
    }
}
