// 287. Find the Duplicate Number.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(int a, int b) {
	return a < b;
}

class Solution {
public:
	int findDuplicate(vector<int>& nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];

		while (fast != slow) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;

		while (fast != slow) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return fast;
	}
};

int main()
{
	Solution* s = new Solution();
	//vector<int> vec({ 1,3,4,2,2 });
	vector<int> vec({ 1,1});
	//vector<int> vec({ 1,1,2 });
	//vector<int> vec({ 1,3,4,2,2 });

	cout << s->findDuplicate(vec);
}

