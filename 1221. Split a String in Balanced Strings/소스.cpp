#include<iostream>
#include<vector>

using namespace std;

//��¥ - 2021/03/01
//���� - 08:23
//���� - 08:30
//�Ǽ� - 
//���� - 

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