class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> zeroLoss = new HashSet();
        Set<Integer> oneLoss = new HashSet();
        Set<Integer> moreLoss = new HashSet();
        
        for(int[] match: matches) {
            int winner = match[0];
            int loser = match[1];
            if(!oneLoss.contains(winner) && !moreLoss.contains(winner)) {
                zeroLoss.add(winner);
            }
    
            if(zeroLoss.contains(loser)) {
                zeroLoss.remove(loser);
                oneLoss.add(loser);
            }
            else if(oneLoss.contains(loser)) {
                oneLoss.remove(loser);
                moreLoss.add(loser);
            }
            else {
                if(!moreLoss.contains(loser)) {
                    oneLoss.add(loser);
                }
            }
        }
        
        List<Integer> winners = new ArrayList();
        List<Integer> losers = new ArrayList();
        
        for(int winner: zeroLoss) {
            winners.add(winner);
        }
        for(int loser: oneLoss) {
            losers.add(loser);
        }
        
        List<List<Integer>> answer = new ArrayList();
        Collections.sort(winners);
        Collections.sort(losers);
        
        answer.add(winners);
        answer.add(losers);
        
        return answer;
    }
}

/*
1 -> 3
2 -> 3
3 -> 6
5 -> 6
5 -> 7
4 -> 5
4 -> 8
4 -> 9
10 -> 4
10 -> 9

[1,2,10],[4,5,7,8]

[[2,3],[1,3],[5,4],[6,4]]
[1,2,5,6],[]
*/