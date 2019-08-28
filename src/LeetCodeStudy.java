import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by CHENT
 */
public class LeetCodeStudy {
    public static void main(String[] args) {
        System.out.println(convertx("LEETCODEISHIRING", 4));
        int[] ss = twoSum(new int[]{3, 2, 5,4,1}, 6);
    }

    // Z 字形变换

    /**
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 5
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     I
     * E   E S   G
     * E  D  H  N
     * T O   I I
     * C     R
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     */
    public static String convert(String s, int numRows) {
        int numRowsX = numRows - 1;
        if (numRows == 1) {
            return s;
        }
        StringBuilder alexVines = new StringBuilder();
        String[] particle = s.split("/*");
        for (int i = 0; i < particle.length; i++) {
            // 创建临时变量

            if (i % numRowsX == 0) {
                System.out.print(particle[i] + "  ");

            } else {
                int selectNumRows = numRows - 2;
                if (i % selectNumRows == 0) {
                    System.out.println(particle[i]);
                }

                int selectNumRowsx = numRows - 3;
                if (i % selectNumRowsx == 0) {
                    System.out.println(particle[i]);
                }
            }
        }
        return "";
    }


    public static String convertx(String s, int numRows) {
        if (numRows == 1) return s;
        int[] rowIdx = new int[numRows];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = numRows * 2 - 2;
        int burketNum = chars.length / burketSize;
        int rem = chars.length % burketSize;
        for (int i = 1; i < numRows; i++) {
            int flag = i == 1 ? 1 : 2;
            n = flag * burketNum + (rem >= i ? (1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
            rowIdx[i] = rowIdx[i - 1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            chars[rowIdx[curRow]] = c;
            rowIdx[curRow] = rowIdx[curRow] + 1;
            if (curRow == 0 || curRow == numRows - 1) flag = -flag;
            curRow += flag;
        }
        return new String(chars);
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        // 初始化返回值数组
        int[] select = new int[]{-1,-1};
        // 异常边界判断
        if (nums.length < 2 || nums == null){
            return select;
        }
        // 初始化存查<K,V>容器 (利用 containsKey 进行边存边查)
        HashMap map = new HashMap<Integer,Integer>();
        for ( int i = 0; i < nums.length ; i++ ) {
            // 假设 target = 6 ; nums[i] = 2; 那么如果map存储了两个相加为 6 的元素, 即可通过 减 nums[i] 获得匹配;
            if (map.containsKey(target-nums[i])){
                select[0] = (int) map.get(target-nums[i]);
                select[1] = i;
                break;
            }
            // 滞后避免等值边界异常
            // 输入：
            //  [3,2,4]
            //  6
            //  输出：
            //  [0,0]
            map.put(nums[i],i);
        }
        return select;
    }



 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

}
