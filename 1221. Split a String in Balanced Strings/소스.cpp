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

        int judge = 0;
        if (s.at(0) == 'R')
            judge++;
        else
            judge--;

        for (int i = 1; i < s.length(); i++) {
            if (s[i] == 'R')
                judge++;
            else
                judge--;

            if (judge == 0)
                maximum_Amount++;
        }

        return maximum_Amount;
    }
};

int main() {
    Solution* s = new Solution();

    cout << s->balancedStringSplit("RLRRLLRLRL");
}