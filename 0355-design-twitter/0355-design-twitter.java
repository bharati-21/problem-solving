class Twitter {
    private static int time = 0;
    Map<Integer, User> users;
    List<Tweet> tweets;
    
    private class Tweet {
        int tweetId, userId, timestamp;
        
        Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timestamp = time++;
        }
    }
    
    private class User {
        int userId;
        Set<Integer> followers, following;
        List<Tweet> userTweets;
        
        User(int userId) {
            following = new HashSet();
            followers = new HashSet();
            userTweets = new ArrayList();
            
            this.userId = userId;
        }
    }

    public Twitter() {
        users = new HashMap();
        tweets = new ArrayList();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, userId);
        if(!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        user.userTweets.add(tweet);
        tweets.add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)) return new ArrayList();
        User user = users.get(userId);
        Set<Integer> following = user.following;
        
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b) -> a.timestamp - b.timestamp);
        for(Tweet tweet: tweets) {
            int tweetUserId = tweet.userId;
            if(pq.size() < 10) {
                if(following.contains(tweetUserId) || userId == tweetUserId)
                    pq.add(tweet);
            }
            else {
                if(following.contains(tweetUserId) || userId == tweetUserId) {
                    if(pq.peek().timestamp >= tweet.timestamp) {
                        break;
                    }
                    else {
                        pq.add(tweet);
                        pq.poll();
                    }
                }
            }
        }
        
        List<Integer> feed = new ArrayList();
        while(!pq.isEmpty() && feed.size() < 10) {
            Tweet t = pq.poll();
            feed.add(0, t.tweetId);
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if(!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        
        follower.following.add(followeeId);
        followee.followers.add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || !users.containsKey(followeeId)) return;
        
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        
        follower.following.remove(followeeId);
        followee.followers.remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */