class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        helper(0, target, candidates, current, ans);

        return ans;
    }

    public void helper(int index, int target, int[] candidates,
                       ArrayList<Integer> current,
                       List<List<Integer>> ans) {

        // We found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // No candidates left
        if (index == candidates.length) {
            return;
        }

        // TAKE — only if candidate fits
        if (candidates[index] <= target) {

            current.add(candidates[index]);

            // Same index because reuse is allowed
            helper(index,
                   target - candidates[index],
                   candidates,
                   current,
                   ans);

            // Backtrack
            current.remove(current.size() - 1);
        }

        // DON'T TAKE
        helper(index + 1,
               target,
               candidates,
               current,
               ans);
    }
}