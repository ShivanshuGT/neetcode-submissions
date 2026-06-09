class Tweet{
    int id;
    int time;

    Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }

    int getTime(){
        return this.time;
    }

    int getId(){
        return this.id;
    }
}
class Twitter {

    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, Set<Integer>> followeeMap; // stores the followee of a user
    private static int clock = 0;

    public Twitter() {
        this.tweetMap = new HashMap<>();
        this.followeeMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> ls = this.tweetMap.get(userId);
        if(ls == null){
            ls = new ArrayList<>();
        }
        ls.add(new Tweet(tweetId, clock));
        clock += 1;
        this.tweetMap.put(userId, ls);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> ls = this.followeeMap.get(userId);
        if(ls == null){
            ls = new HashSet();
        }

        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> b.getTime() - a.getTime());

        for(Integer followee : ls){
            List<Tweet> tweets = this.tweetMap.get(followee);
            for(Tweet tweet : tweets){
                queue.add(tweet);
            }
        }

        List<Tweet> myTweets = this.tweetMap.get(userId);
        if(myTweets != null){
            for(Tweet tweet : myTweets){
                queue.add(tweet);
            }
        }
        

        Set<Integer> ans = new LinkedHashSet<>();
        int x = 1;
        while(x <= 10 && !queue.isEmpty()){
            ans.add(queue.poll().getId());
            x += 1;
        }
        return ans.stream().toList();
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> ls = this.followeeMap.get(followerId);
        if(ls == null){
            ls = new HashSet<>();
        }
        ls.add(followeeId);
        this.followeeMap.put(followerId, ls);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> ls = this.followeeMap.get(followerId);
        ls.remove((Object) followeeId);
        this.followeeMap.put(followerId, ls);
        
    }
}
