# Last updated: 8/2/2026, 8:43:20 AM
1class Solution:
2    def countTasks(self, tasks: List[int], shifts: List[int]) -> List[int]:
3        n = len(tasks)
4        pref =[0] * (n+1)
5        for i in range(n):
6            pref[i+1] = pref[i] + tasks[i]
7        ans = []
8        current_task_idx = 0
9        current_task_rem_time = tasks[0]
10        for shift_time in shifts:
11            if shift_time < current_task_rem_time:
12                current_task_rem_time -= shift_time
13                ans.append(n - current_task_idx)
14            else:
15                time_left =shift_time - current_task_rem_time
16                target = time_left + pref[current_task_idx +1]
17                idx_after = bisect.bisect_right(pref,target)-1
18                if idx_after == n:
19                    ans.append(0)
20                    current_task_idx = 0
21                    current_task_rem_time =tasks[0]
22                else:
23                    rem_shift_for_task = time_left - (pref[idx_after]-pref[current_task_idx + 1])
24                    current_task_idx = idx_after
25                    current_task_rem_time = tasks[idx_after] - rem_shift_for_task
26                    ans.append(n - current_task_idx)
27        return ans
28        