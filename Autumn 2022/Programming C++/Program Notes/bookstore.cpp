#include <iostream>

using namespace std;

class Bookstore {
	
	public:
		// Bookstore();
		void AddBook(Book newBook);
		void SellBook(Book byeBook);
		bool BookInStock(Book bookCheck);
		void DispInventory();
	
	private:
		vector<Book> inv;
		int FindIsbn(Book bookCheck);
}	
	
class Book {
	
	public:
	
		Book(string title("NoTitle"), string author("NoAuthor"), string isbn("NoIsbn"), double cost(-1.0), int quantity(-1)) {
			this->title = title;
			this->author = author;
			this->isbn = isbn;
			this->cost = cost;
			this->quantity = quantity;
		}
		string GetTitle() {
			return this->title;
		}
		string GetAuthor() {
			return this->author;
		}
		string GetIsbn() {
			return this->isbn;
		}
		double GetCost() {
			return this->cost;
		}
		int GetQuantity() {
			return this->quantity;
		}
		
		
	private:
		string title, author, isbn;
		double cost;
		int quantity;
		
}


int main() {
	
	
}


void menu() {
	
	
}


void Bookstore::AddBook(Book newBook) {
	
	if (this->inv.BookInStock(newBook)) {
		this->inv.
	}
	
	return;
}

		
// removes book from inventory	
void Bookstore::SellBook(Book byeBook) {
	
	
}


// returns true if book in stock
bool Bookstore::BookInStock(Book bookCheck) {
	
	for (int i(0); i < this->inv.size(); i++) {
		if (this->inv.at(i).GetIsbn == bookCheck.GetIsbn) {
			return true;
		}
	}
	
	return false;
}


// Returns location of isbn in vector
// ASSUMES BOOK IS IN INVENTORY
int Bookstore::FindIsbn(Book bookCheck) {
	
	
}


// display each book - isbn, title, author, cost, num in stock
void Bookstore::DispInventory() {
	
	
}