# Last updated: 8/6/2026, 11:41:34 AM
1class Twitter:
2
3    def __init__(self):
4        self.following_matrix = [[False] * 501 for _ in range(501)]
5        self.tweets = [None] * 10001
6        self.tweets_order = [None] * 10001
7        self.tweet_count = 0
8
9    def postTweet(self, userId: int, tweetId: int) -> None:
10        self.tweets[tweetId] = userId
11        self.tweets_order[tweetId] = self.tweet_count
12        self.tweet_count += 1
13
14    def getNewsFeed(self, userId: int) -> List[int]:
15        following_list = {userId}
16
17        for i in range(1, 501):
18            if self.following_matrix[userId][i]:
19                following_list.add(i)
20
21        posts = []
22
23        for tweetId in range(10001):
24            if (
25                self.tweets[tweetId] is not None
26                and self.tweets[tweetId] in following_list
27            ):
28                posts.append((self.tweets_order[tweetId], tweetId))
29
30        posts.sort(reverse=True)
31
32        return [tweetId for _, tweetId in posts[:10]]
33
34    def follow(self, followerId: int, followeeId: int) -> None:
35        self.following_matrix[followerId][followeeId] = True
36
37    def unfollow(self, followerId: int, followeeId: int) -> None:
38        self.following_matrix[followerId][followeeId] = False