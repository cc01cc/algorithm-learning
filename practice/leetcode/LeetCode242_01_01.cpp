#include <iostream>
using namespace std;
class Solution {
public:
    bool isAnagram(string s, string t) {
		int alphabetArray[26] = {0};
		for (int i = 0; i < s.size(); i++) {
			alphabetArray[s[i] - 'a'] ++;
		}
		for (int i = 0; i < t.size(); i++) {
			alphabetArray[t[i] - 'a'] --;
		}

		for (int i = 0; i < sizeof(alphabetArray)/sizeof(alphabetArray[0]); i++){
			if (alphabetArray[i] != 0) return false;
		}
		return true;
    }
};

int main() {
	Solution solution;
	bool res = solution.isAnagram("anagram", "nagaram");
	cout << res <<endl;
}

