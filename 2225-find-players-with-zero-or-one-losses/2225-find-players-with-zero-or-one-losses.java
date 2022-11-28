class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> allPlayers = new HashSet();
        Map<Integer, Integer> lossCountByPlayers = new HashMap();
        Set<Integer> moreLoss = new HashSet();
        
        for(int[] match: matches) {
            int winner = match[0];
            int loser = match[1];
            
            allPlayers.add(winner);
            allPlayers.add(loser);
            
            if(!lossCountByPlayers.containsKey(loser)) {
                lossCountByPlayers.put(loser, 0);
            }
            int count = lossCountByPlayers.get(loser);
            lossCountByPlayers.put(loser, count + 1);
        }
        
        List<Integer> winners = new ArrayList();
        List<Integer> losers = new ArrayList();
        
        for(int player: allPlayers) {
            if(!lossCountByPlayers.containsKey(player)) {
                winners.add(player);
            }
            else if(lossCountByPlayers.get(player) == 1) {
                losers.add(player);
            }
        }
        
        List<List<Integer>> answer = new ArrayList();
        Collections.sort(winners);
        Collections.sort(losers);
        
        answer.add(winners);
        answer.add(losers);
        
        return answer;
    }
}
