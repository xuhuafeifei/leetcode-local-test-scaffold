package com.leetcode.convert;

import com.leetcode.CommonObject.ListNode;
import com.leetcode.CommonObject.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * ClassName: ConvertToInt
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:24
 */
public class ConvertToListNode extends ConvertFunc {

    @Override
    protected Class initType() {
        return ListNode.class;
    }

    @Override
    public Object invoke(String arg) {
        String[] nums = super.getArrayFromString(arg);
        if (nums.length == 0) return null;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for (String num : nums) {
            cur.next = new ListNode(Integer.parseInt(num));
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
