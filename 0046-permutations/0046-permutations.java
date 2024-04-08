import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int position) {
        if (position == nums.length) {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < nums.length; i++) list.add(nums[i]);
            res.add(list);
            return;
        }


        for (int i = position; i < nums.length; i++) {
            swap(nums, position, i);
            dfs(res, nums, position + 1);
            swap(nums, position, i);
        }
    }


    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}