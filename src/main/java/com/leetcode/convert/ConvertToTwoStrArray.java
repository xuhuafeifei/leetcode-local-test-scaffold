package com.leetcode.convert;

public class ConvertToTwoStrArray extends ConvertFunc {
    @Override
    protected Class initType() {
        return String[][].class;
    }

    @Override
    public Object invoke(String arg) {
        String[][] twoDimArray = getTwoDimArray(arg);
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = extractString(twoDimArray[i][j], 1);
            }
        }
        return twoDimArray;
    }
}
