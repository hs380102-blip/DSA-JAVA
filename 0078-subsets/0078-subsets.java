class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        helper(0, nums, current, ans);

        return ans;
    }

    static void helper(int index, int[] nums,
                       ArrayList<Integer> current,
                       List<List<Integer>> ans) {

        // Base Case
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));   // Store a copy
            return;
        }

        // Take
        current.add(nums[index]);
        helper(index + 1, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Don't Take
        helper(index + 1, nums, current, ans);
    }
}