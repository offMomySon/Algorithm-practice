#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;


class Solution {
public:

	vector<int> prvCal;

	int numberOfArithmeticSlices(vector<int>& A) {
		if (A.size() < 3)
			return 0;

		unordered_map<int, int> m;
		prvCal = vector<int>(A.size()+1, 0);
		int cal = 2;
		prvCal[3] = 1;
		for (int i = 4; i < prvCal.size(); i++) {
			prvCal[i] = prvCal[i - 1] + cal;
			cal += 1;
		}

		int prev_interval = A[1]-A[0];
		int count = 1;
		for (int i = 1; i < A.size(); i++) {
			if ((A[i] - A[i-1]) != prev_interval) {
				if (count >= 3)
					m[count]++;
				prev_interval = A[i] - A[i - 1];
				count = 1;
			}
			count++;
		}

		if (count >= 3)
			m[count]++;
		
		int res = 0;

		for (auto it : m) {
			res += it.second* prvCal[it.first];
		}

		return res;

	}
};

int main() {

	Solution* s = new Solution();
	vector<int> vec({ 1, 2, 3, 4 });
	cout << s->numberOfArithmeticSlices(vec);

}









