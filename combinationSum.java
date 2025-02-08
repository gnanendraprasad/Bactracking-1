// Time complexity: O(2^N)
// Space complexity: O(N) // Recursion stack space
// Leetcode: Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //base
        if(candidates.length == 0){
            return new ArrayList<>();
        }

        //logic - recursion and backtrack using for loop
        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=index; i<candidates.length; i++){
            path.add(candidates[i]);
            recurse(candidates, target-candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
