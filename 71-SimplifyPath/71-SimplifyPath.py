# Last updated: 7/9/2026, 3:08:45 PM
class Solution:
    def simplifyPath(self, path):
        stack = []

        for part in path.split('/'):
            if part == '' or part == '.':
                continue
            elif part == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(part)

        return '/' + '/'.join(stack)