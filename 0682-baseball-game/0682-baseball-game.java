class Solution {
	public int calPoints(String[] operations) {
		if(operations == null || operations.length == 0) {
			return 0;
        }
		
        int points = 0;
		Stack<Integer> record = new Stack<>();
		for(String operation: operations) {
			if(operation.equals("+")) {
				int first = record.pop();
				int second = record.pop();
				int sum = first + second;
				record.push(second);
				record.push(first);
				record.push(sum);
            }
            else if(operation.equals("D")) {
                int top = record.peek();
                record.push(top * 2);
            }
            else if(operation.equals("C")) {
                record.pop();
            }
            else {
                record.push(Integer.parseInt(operation));
            }
		}
		while(!record.isEmpty()) {
			points += record.pop();
        }

        return points;
    }
}
