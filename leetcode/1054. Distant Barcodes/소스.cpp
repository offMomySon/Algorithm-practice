#include<iostream>
#include<vector>
#include<set>
#include <unordered_map>
#include<algorithm>

using namespace std;



class Solution {
	

public:
	vector<int> rearrangeBarcodes(vector<int>& barcodes) {
		unordered_map<int, int> m;
		for (auto it = barcodes.begin(); it != barcodes.end(); it++) {
			m[(*it)]++;
		}

		set<pair<int, int>> s;
		for (auto it = m.begin(); it != m.end(); it++) {
			s.insert({ it->second, it->first });
		}

		int idx = 0;
		for (auto it = s.rbegin(); it != s.rend(); ++it) {
			for (int mCount = 0; mCount < it->first; ++mCount) {
				barcodes[idx] = it->second;

				idx += 2;
				if (idx >= barcodes.size()) {
					idx = 1;
				}
			}
		}

		return barcodes;
	}
};

int main() {
	Solution* s = new Solution();

	vector<int> v({ 1,2 });
	vector<int> result = s->rearrangeBarcodes(v);


	for (auto it = result.begin(); it != result.end(); it++) {
		cout << (*it) << endl;
	}


}