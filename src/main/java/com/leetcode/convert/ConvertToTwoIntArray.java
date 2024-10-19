package com.leetcode.convert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ClassName: ConvertToTwoIntArray
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:38
 */
public class ConvertToTwoIntArray extends ConvertFunc {

    @Override
    protected Class initType() {
        return int[][].class;
    }

    @Override
    public Object invoke(String arg) {
        String[][] twoDimArray = getTwoDimArray(arg);
        int m = twoDimArray.length, n = twoDimArray[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = Integer.parseInt(twoDimArray[i][j]);
            }
        }
        return ans;
    }
}
