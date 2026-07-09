# Last updated: 7/9/2026, 3:08:50 PM
class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res = []
        i = 0
        n = len(words)

        while i < n:
            # Find words that fit in the current line
            j = i
            line_len = 0

            while j < n and line_len + len(words[j]) + (j - i) <= maxWidth:
                line_len += len(words[j])
                j += 1

            line_words = words[i:j]
            num_words = j - i

            # Last line or single word -> left justify
            if j == n or num_words == 1:
                line = " ".join(line_words)
                line += " " * (maxWidth - len(line))
            else:
                total_spaces = maxWidth - line_len
                gaps = num_words - 1

                base_spaces = total_spaces // gaps
                extra_spaces = total_spaces % gaps

                line = ""

                for k in range(gaps):
                    line += line_words[k]
                    line += " " * (
                        base_spaces + (1 if k < extra_spaces else 0)
                    )

                line += line_words[-1]

            res.append(line)
            i = j

        return res