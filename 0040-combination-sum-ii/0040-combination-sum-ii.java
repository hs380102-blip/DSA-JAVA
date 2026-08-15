class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(0, candidates, target, current, ans);

        return ans;
    }

    public void helper(int index, int[] candidates, int target,
                       List<Integer> current,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicates at the same level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since sorted, nothing after this can fit
            if (candidates[i] > target) {
                break;
            }

            // Take
            current.add(candidates[i]);

            helper(i + 1,
                   candidates,
                   target - candidates[i],
                   current,
                   ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}