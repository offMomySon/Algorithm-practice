#include<iostream>
#include<vector>

using namespace std;
//날짜 - 2021/02/26
//시작 - 01:00
//종료 - 01:30
//실수 - arr 의 edge case 를 고려하지 않아 배열 범위 벗어남.
//참조 - None.

class Solution {
public:
	int peakIndexInMountainArray(vector<int>& arr) {
		

		return binary_search(arr, 0, arr.size() - 1);
	}

	int binary_search(vector<int>& arr, int start, int end) {
		if (start > end)
			return start;

		int mid = (start + end) / 2;

		if (mid == 0)
			mid++;
		else if (mid == arr.size() - 1)
			mid--;

		if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
			return mid;
		}

		if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
			return binary_search(arr, mid+1,end);
		}

			return binary_search(arr, start, mid - 1);
		
	}
};


int main() {
	Solution* s = new Solution();
	
	//vector<int> vec({ 0,10,5,2 });
	//vector<int> vec({ 0,10,5,2 });
	//vector<int> vec({ 0,10,5,2 });
	//vector<int> vec({ 24,69,100,99,79,78,67,36,26,19 });
	vector<int> vec({ 3,5,3,2,0 });


	cout <<s->peakIndexInMountainArray(vec);
}

