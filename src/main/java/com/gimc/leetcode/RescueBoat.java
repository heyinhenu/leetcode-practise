package com.gimc.leetcode;

import java.util.Arrays;

/**
 * author: heyin
 * date: 2018-08-28
 * desc:
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 */
public class RescueBoat {


    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        numRescueBoats(people, 5);
    }

    /**
     * 方法：贪心（双指针）
     * 思路:
     * 如果最重的人可以与最轻的人共用一艘船，那么就这样安排。否则，最重的人无法与任何人配对，那么他们将自己独自乘一艘船。
     * 这么做的原因是，如果最轻的人可以与任何人配对，那么他们也可以与最重的人配对。
     * 算法:
     * 令 people[i] 指向当前最轻的人，而 people[j] 指向最重的那位。
     * 然后，如上所述，如果最重的人可以与最轻的人共用一条船（即 people[j] + people[i] <= limit），那么就这样做；否则，最重的人自己独自坐在船上。
     */
    public static void numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
    }
}


