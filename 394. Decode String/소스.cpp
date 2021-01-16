#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
	string decodeString(string s) {
		int i = 0;
		return decodeString(s, i);
	}

	string decodeString(string& s, int &i) {
		string res;

		//while(!isdigit(s.at(i)) && s.at(i) != ']' ){
		while ( i < s.length() && s.at(i) != ']') {
			if (!isdigit(s.at(i))){
				res += s.at(i++);
				continue;
			}

			int n = 0;
			while (isdigit(s.at(i))) {
				n = n * 10 + s.at(i++) - '0';
			}

			i++;
			string temp = decodeString(s, i);
			for (int i = 0; i < n; i++) {
				res += temp;
			}
			i++;
		}

		return res;
	}
};

int main() {
	Solution* s = new Solution();

	cout << s->decodeString("3[a]2[bc]");
	//cout << s->decodeString("3[a2[c]]");
}