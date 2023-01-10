/*
  File: sentence.cpp
  Created by: Gage Farmer
  Creation Date: 11/1/2022
  Synopsis: Reads some words and does some things
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* INSERT FUNCTION PROTOTYPES HERE */
string get_text(string prompt);
vector<string> extract_words(string sentence);
void output_words(string pre, vector<string> words);
void output_articles(vector<string> words);
void sort_words(vector<string>& words);


int main() {
  string sentence;
  vector<string> words;

  sentence = get_text("Enter your sentence: ");
  
  if (sentence.length() > 0) {
    words = extract_words(sentence);
    cout << endl;
    output_words("You entered the word(s)", words);
    cout << endl;
    output_articles(words);
    cout << endl;
    sort_words(words);
    output_words("The sorted list is", words);
  }
  else {
    cout << "You entered no words" << endl;
  }
  
  return 0;
}

/* INSERT FUNCTION DEFINITIONS HERE */
string get_text(string prompt) {
	string sentence;
	
	cout << prompt;
	getline(cin, sentence);
	
	return sentence;
}

vector<string> extract_words(string sentence) {
	vector<string> list;
	string word = "1";

	while (sentence.compare(word) != 0) {
		auto index = sentence.find_first_of(" ");
		word = sentence.substr(0,index);

		sentence = sentence.substr(index+1, sentence.length());

		if (word.length() != 0) {
			list.push_back(word);
		}
	}
	
	return list;
}

void output_words(string pre, vector<string> words) {
	cout << pre << " < ";
	
	for (int i(0); i < words.size(); i++) {
		if (i != 0) {
			cout << "', '";
		}
		else { cout << "'"; }
		
		cout << words.at(i);
	}
	
	cout << "' >" << endl;
	
	return;
}

void output_articles(vector<string> words) {
	int a(0), an(0), the(0);
	
	for (int i(0); i < words.size(); i++) {
		if      (words.at(i) == "a")   { a++;   }
		else if (words.at(i) == "an")  { an++;  }
		else if (words.at(i) == "the") { the++; }
	}
	
	cout << "Number of each article:" << endl;
	cout << a   << " 'a' word(s)."    << endl;
	cout << an  << " 'an' word(s)."   << endl;
	cout << the << " 'the' word(s)."  << endl;
	
	return;
}


void sort_words(vector<string>& words) {
	string single, temp;
	
	sort(words.begin(), words.end());
	
	
	return;
}