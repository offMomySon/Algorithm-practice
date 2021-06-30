#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
	int numPairsDivisibleBy60(vector<int>& time) {
		unordered_map<int,int> m;

		for (auto t : time) {
			m[t]++;
		}

		vector<int> vec;
		for (int i = 1; i < 17; i++) {
			vec.push_back(i * 60);
		}

		int count = 0;
		
		for (int i = 0; i < time.size();i++) {
			m[time[i]]--;
			for (int j = 0; j < vec.size(); j++) {
				if (m[vec[j] - time[i]] > 0) {
					count += m[vec[j] - time[i]];
				}
			}

		}
		return count;
	}
};


int main() {
	Solution* s = new Solution();
	//vector<int> v({ 30,20,150,100,40 });
	vector<int> v({ 60,60,60 });
	cout <<s->numPairsDivisibleBy60(v);
}

