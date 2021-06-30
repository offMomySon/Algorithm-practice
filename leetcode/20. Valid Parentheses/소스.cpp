#include<iostream>
#include<stack>

using namespace std;

class Solution {
public:
	bool isValid(string s) {
		stack<char> st;

		for (auto str : s) {
			if (str == '(' || str == '{' || str == '[')
				st.push(str);
			else {
				if (st.empty())
					return false;
				
				char topChar = st.top();

				if ((topChar == '(' && str == ')') ||
					(topChar == '{' && str == '}') ||
					(topChar == '[' && str == ']')
					)
					st.pop();
				else
					return false;
			}
		}

		if (!st.empty())
			return false;

		return true;
	}
};

int main() {

}



