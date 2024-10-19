package com.leetcode;

import com.leetcode.CommonObject.ListNode;
import com.leetcode.CommonObject.TreeNode;

import java.util.Arrays;

/**
 * ClassName: Outper
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 2:52
 */
public class Outper {
    public void output(Object res) {
        if (res instanceof int[]) {
            System.out.println(Arrays.toString((int[]) res));
        }else if (res instanceof String[]) {
            System.out.println(Arrays.toString((String[]) res));
        }else if (res instanceof TreeNode) {
            ((TreeNode) res).print();
        }else if (res instanceof ListNode) {
            ((ListNode) res).print();
        }
        else {
            System.out.println(res);
        }
    }
}
