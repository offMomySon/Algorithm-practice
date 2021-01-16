#include <iostream>
#include <sstream>
#include <vector>
#include<algorithm>

using namespace std;

void buildBloacks(vector<int> & counstruture, int *dayBloacks) {

	for (int i = 0; i < counstruture.size(); i++) {
		counstruture[i] += dayBloacks[i];
	}
}

void fill(vector<int>& counstruture, int &siment) {
	int leftMax = 0;
	int rightMax = 0;

	for (int left = 0, right = counstruture.size() - 1; left < right;) {
		leftMax = max(leftMax, counstruture[left]);
		rightMax = max(rightMax, counstruture[right]);

		if (leftMax <= rightMax) {
			
			siment += leftMax - counstruture[left];
			counstruture[left] = leftMax;
			left++;
		}
		else {
			siment += rightMax - counstruture[right];
			counstruture[right] = rightMax;
			right--;
		}
	}
}


void solution(int day, int width, int** blocks) {
	// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	vector<int> counstruture(width, 0);
	int amount = 0;

	for (int i = 0; i < day; i++) {
		buildBloacks(counstruture, blocks[i]);
		fill(counstruture, amount);
	}

	
	cout << amount << endl;
}

struct input_data {
	int day;
	int width;
	int** blocks;
};

void process_stdin(struct input_data& inputData) {
	string line;
	istringstream iss;

	getline(cin, line);
	iss.str(line);
	iss >> inputData.day;

	getline(cin, line);
	iss.clear();
	iss.str(line);
	iss >> inputData.width;

	inputData.blocks = new int* [inputData.day];
	for (int i = 0; i < inputData.day; i++) {
		getline(cin, line);
		iss.clear();
		iss.str(line);
		inputData.blocks[i] = new int[inputData.width];
		for (int j = 0; j < inputData.width; j++) {
			iss >> inputData.blocks[i][j];
		}
	}
}

int main() {
	struct input_data inputData;
	process_stdin(inputData);

	solution(inputData.day, inputData.width, inputData.blocks);
	return 0;
}