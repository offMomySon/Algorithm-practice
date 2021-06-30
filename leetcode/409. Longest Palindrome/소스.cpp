#include<iostream>
#include<vector>
#include<unordered_map>
#include<string>

using namespace std;

class Solution {
public:
	int longestPalindrome(string str) {
		unordered_map<char,int> m;
		int count = 0;
		bool check = false;
		for (auto s : str)
			m[s]++;
		
		for (auto it = m.begin(); it != m.end(); it++) {
			if (it->second % 2 == 0)
				count += it->second;
			else {
				check = true;
				count += (it->second - 1);
			}

		}
		if(check == true)
			count += 1;

		return count;
	}
};


int main() {

}

