#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	void initVec(vector<vector<string>>& numMap) {

		numMap[2].push_back("a");
		numMap[2].push_back("b");
		numMap[2].push_back("c");

		numMap[3].push_back("d");
		numMap[3].push_back("e");
		numMap[3].push_back("f");

		numMap[4].push_back("g");
		numMap[4].push_back("h");
		numMap[4].push_back("i");

		numMap[5].push_back("j");
		numMap[5].push_back("k");
		numMap[5].push_back("l");

		numMap[6].push_back("m");
		numMap[6].push_back("n");
		numMap[6].push_back("o");

		numMap[7].push_back("p");
		numMap[7].push_back("q");
		numMap[7].push_back("r");
		numMap[7].push_back("s");


		numMap[8].push_back("t");
		numMap[8].push_back("u");
		numMap[8].push_back("v");

		numMap[9].push_back("w");
		numMap[9].push_back("x");
		numMap[9].push_back("y");
		numMap[9].push_back("z");

	}

	vector<string> res;

	vector<string> letterCombinations(string digits) {
		if (digits.length() <= 0) {
			return res;
		}
		vector<vector<string>> numMap(10, vector<string>(0));
		initVec(numMap);
		vector<int> strIdx(digits.length(), 0);
		
		helper(numMap, strIdx, 0, digits);

		return res;
	}

	void helper(vector<vector<string>>& numMap, vector<int>& strIdx, int thDigit, string& digits) {
		if (thDigit >= digits.length()) {
			string str;
			for (int i = 0; i < digits.length(); i++) {
				str.append(numMap[digits.at(i) - '0'][strIdx[i]]);
			}
			res.push_back(str);

			return;
		}

		int num = digits.at(thDigit) - '0';
		
		for (int i = 0; i < numMap[num].size(); i++) {
			strIdx[thDigit] = i;
			helper(numMap, strIdx, thDigit + 1, digits);
		}
	}

};

int main() {
	Solution* s = new Solution();

	vector<string> re = s->letterCombinations("23");
	for (int i = 0; i < re.size(); i++) {
		cout << re[i] << endl;
	}

}







