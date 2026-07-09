# Last updated: 7/9/2026, 3:09:55 PM
from collections import Counter

class Solution:
    def findSubstring(self, s, words):
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = len(words)
        word_freq = Counter(words)
        result = []

        for i in range(word_len):
            left = i
            count = 0
            curr_freq = {}

            for right in range(i, len(s) - word_len + 1, word_len):
                word = s[right:right + word_len]

                if word in word_freq:
                    curr_freq[word] = curr_freq.get(word, 0) + 1
                    count += 1

                    while curr_freq[word] > word_freq[word]:
                        left_word = s[left:left + word_len]
                        curr_freq[left_word] -= 1
                        count -= 1
                        left += word_len

                    if count == word_count:
                        result.append(left)

                        left_word = s[left:left + word_len]
                        curr_freq[left_word] -= 1
                        count -= 1
                        left += word_len

                else:
                    curr_freq.clear()
                    count = 0
                    left = right + word_len

        return result