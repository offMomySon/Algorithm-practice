#include <iostream>
#include <sstream>
#include <vector>
#include <utility>

using namespace std;

struct People
{
	int catchedCount;
	int position;
	char name;
};

void assginPlayer(int numOfAllPlayers, vector<People> &player) {
	
	for (int i = 0; i < numOfAllPlayers-1; i++) {
		player.push_back({ 0 , i, char('B' + i )}) ;
	}
}

void printRs( vector<People>& player, People&bumin) {
	for (int i = 0; i < player.size(); i++) {
		cout << player[i].name << " " << player[i].catchedCount << endl;
	}

	cout << bumin.name << " " << bumin.catchedCount << endl;
}
bool isNotFasterPalyer(int numOfQuickPlayers, char* namesOfQuickPlayers, char targetPlayer) {
	for (int i = 0; i < numOfQuickPlayers; i++) {
		if (namesOfQuickPlayers[i] == targetPlayer) {
			return false;
		}
	}
	return true;
}

void eachGame(vector<People>& player, People &bumin, int numOfQuickPlayers, char* namesOfQuickPlayers , int moveCount) {

	int moveIdx = (bumin.position + moveCount) % player.size();
	if (moveIdx < 0) {
		moveIdx = player.size() + moveIdx;
	}

	if (isNotFasterPalyer(numOfQuickPlayers, namesOfQuickPlayers, player[moveIdx].name)) {
		People temp;
		temp.catchedCount = bumin.catchedCount;
		temp.name = bumin.name;
		temp.position = moveIdx;

		bumin.catchedCount = player[moveIdx].catchedCount +1;
		bumin.name = player[moveIdx].name;
		bumin.position = moveIdx;

		player[moveIdx].catchedCount = temp.catchedCount;
		player[moveIdx].name = temp.name;
		player[moveIdx].position = temp.position;
	}
	else {
		bumin.catchedCount += 1;
	}
	
}

void solution(int numOfAllPlayers, int numOfQuickPlayers, char* namesOfQuickPlayers, int numOfGames, int* numOfMovesPerGame) {
	// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	vector<People> player;
	People bumin = { 1, 0, 'A' };


	assginPlayer(numOfAllPlayers, player);

	for (int i = 0; i < numOfGames; i++) {
		eachGame(player, bumin, numOfQuickPlayers, namesOfQuickPlayers, numOfMovesPerGame[i]);
	}

	printRs(player, bumin);
}

struct input_data {
	int numOfAllPlayers;
	int numOfQuickPlayers;
	char* namesOfQuickPlayers;
	int numOfGames;
	int* numOfMovesPerGame;
};

void process_stdin(struct input_data& inputData) {
	string line;
	istringstream iss;

	getline(cin, line);
	iss.str(line);
	iss >> inputData.numOfAllPlayers;

	getline(cin, line);
	iss.clear();
	iss.str(line);
	iss >> inputData.numOfQuickPlayers;

	getline(cin, line);
	iss.clear();
	iss.str(line);
	inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
	for (int i = 0; i < inputData.numOfQuickPlayers; i++) {
		iss >> inputData.namesOfQuickPlayers[i];
	}

	getline(cin, line);
	iss.clear();
	iss.str(line);
	iss >> inputData.numOfGames;

	getline(cin, line);
	iss.clear();
	iss.str(line);
	inputData.numOfMovesPerGame = new int[inputData.numOfGames];
	for (int i = 0; i < inputData.numOfGames; i++) {
		iss >> inputData.numOfMovesPerGame[i];
	}
}

int main() {
	struct input_data inputData;
	process_stdin(inputData);

	solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
	return 0;
}