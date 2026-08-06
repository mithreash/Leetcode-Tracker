# Last updated: 8/6/2026, 11:09:45 AM
1class Solution:
2    def getHint(self, secret: str, guess: str) -> str:
3        bulls = 0
4        secretCount = [0] * 10
5        guessCount = [0] * 10
6
7        for i in range(len(secret)):
8            if secret[i] == guess[i]:
9                bulls += 1
10            else:
11                secretCount[int(secret[i])] += 1
12                guessCount[int(guess[i])] += 1
13
14        cows = 0
15        for digit in range(10):
16            cows += min(secretCount[digit], guessCount[digit])
17
18        return str(bulls) + "A" + str(cows) + "B"