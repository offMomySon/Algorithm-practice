#include<iostream>
#include<vector>

using namespace std;

//날짜 - 2021/03/01
//시작 - 08:23
//종료 - 08:30
//실수 - 
//참조 - 

class Solution {
public:
    int balancedStringSplit(string s) {
        int maximum_Amount = 0;
        int cnt = 0;

        for (const auto &ch : s) {
            cnt += ch == 'R' ? 1 : -1;

            if (cnt == 0)
                maximum_Amount++;
        }

        return maximum_Amount;
    }
};

int main() {
    Solution* s = new Solution();

    cout << s->balancedStringSplit("RLRRLLRLRL");
}