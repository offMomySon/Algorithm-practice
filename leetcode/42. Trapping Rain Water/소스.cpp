#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

//class Solution {
//public:
//	int trap(vector<int>& height) {
//		
//		int maxHeightIdx = 0;
//		int maxHeight = 0;
//		for (int i = 0; i < height.size(); i++) {
//			if (height[i] > maxHeight) {
//				maxHeightIdx = i;
//				maxHeight = height[i];
//			}
//		}
//
//		int maxNum = 0;
//		int sum = 0;
//		for (int i = 0; i < maxHeightIdx; i++) {
//			if (maxNum <= height[i]) {
//				maxNum = height[i];
//				continue;
//			}
//
//			sum += maxNum - height[i];
//		}
//
//		maxNum = 0;
//		for (int i = height.size() - 1; i > maxHeightIdx; i--) {
//			if (maxNum <= height[i]) {
//				maxNum = height[i];
//				continue;
//			}
//			sum += maxNum - height[i];
//		}
//
//		return sum;
//	}
//
//};


class Solution {
public:
	int trap(vector<int>& height) {
		
		int leftMax = 0;
		int rightMax = 0;
		int sum = 0;

		for (int left = 0, right = height.size()-1; left < right;) {
			leftMax = max(leftMax, height[left]);
			rightMax = max(rightMax, height[right]);

			if (leftMax <= rightMax) {
				sum += leftMax - height[left];
				left++;
			}
			else {
				sum += rightMax - height[right];
				right--;
			}
		}
		return sum;
	}

};

int main() {

	Solution* s = new Solution();
	vector<int> vec({ 0,1,0,2,1,0,1,3,2,1,2,1 });
	cout << s->trap(vec);



}


