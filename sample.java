//The code didn't run on github. The output shown for the input list [2,3,6,7] and target 7 was [[2,2,2,3],[2,2,2,3,3,3,3,6,7]]. However the expected output was [[2,2,3],[7]]. Kindly let me know where the code is running worng or if I missed any condition check.

class Solution {
    public List<List<Integer>> combinationSum(int[] clist, int t) {
        List<List<Integer>> res = new ArrayList<>();
        if(clist.length == 0){
            return res;
        }
        Arrays.sort(clist);
        List<Integer> subset = new ArrayList<>();
        helper(clist, subset, 0, t, res);
        return res;
    }
    
    private void helper(int[]clist, 
                        List<Integer> subset, 
                        int startIndex, 
                        int resSum, 
                        List<List<Integer>>res){
        if(resSum == 0){
            res.add(new ArrayList<Integer>(subset));
        }
        
        for(int i = startIndex; i < clist.length; i++){
            if(clist[i] > resSum ){
                break;
            }
           subset.add(clist[i]);
            helper(clist, subset, i, resSum-clist[i], res);
        }
    }
}