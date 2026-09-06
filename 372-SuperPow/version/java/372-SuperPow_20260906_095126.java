// Last updated: 9/6/2026, 9:51:26 AM
1    public class Solution {
2	public int wiggleMaxLength(int[] nums) {
3		if (nums.length == 0 || nums.length == 1) {
4			return nums.length;
5		}
6		int k = 0;
7		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
8			k++;
9		}
10		if (k == nums.length - 1) {
11			return 1;
12		}
13		int result = 2;     // This will track the result of result array
14		boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
15		for (int i = k + 1; i < nums.length - 1; i++) {
16			if (smallReq && nums[i + 1] < nums[i]) {
17				nums[result] = nums[i + 1];
18				result++;
19				smallReq = !smallReq;    //Toggle the requirement from small to big number
20			} else {
21				if (!smallReq && nums[i + 1] > nums[i]) {
22					nums[result] = nums[i + 1];
23					result++;
24					smallReq = !smallReq;    //Toggle the requirement from big to small number
25				}
26			}
27		}
28		return result;
29	}
30}