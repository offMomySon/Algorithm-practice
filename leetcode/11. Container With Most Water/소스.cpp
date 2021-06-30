#include <iostream>
#include <vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maxArea(vector<int>& height) {
		int maxVolume = 0;
		int left = 0;
		int right = height.size()-1;

		while (left != right) {
			maxVolume = max(maxVolume, (right - left) * min(height[right], height[left]) );

			if (height[left] < height[right]) {
				left++;
			}
			else {
				right--;
			}
		}

		return maxVolume;
	}
};

int main() {

	vector<int> vec({ 1,8,6,2,5,4,8,3,7 });
	Solution* s = new Solution();

	cout << s->maxArea(vec);

}