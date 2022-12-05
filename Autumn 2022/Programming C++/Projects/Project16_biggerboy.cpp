/*
  File: orders.cpp
  Created by: Gage Farmer
  Creation Date: 12/2/2022
  Synopsis: reads, stores, and displays orders
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <vector>

using namespace std;

class Time
{
   private:
     int hours;
	  int minutes;
	  int seconds;
	  string twoDigits(const int num) const;

   public:
	  void setHours(const int hrs);
	  void setMinutes(const int mins);
	  void setSeconds(const int secs);
	  int getHours() const;
	  int getMinutes() const;
	  int getSeconds() const;
	  string toString() const;
};

class Order
{
   private:
     double price;
    int quantity;
    string id;
    Time time;
  
  public:
    void setPrice(const double cost);
    void setQuantity(const int quant);
    void setID(const string ident);
    void setTime(const Time t);
    double getPrice() const;
    int getQuantity() const;
    string getID() const;
    Time getTime() const;
    void display() const;
};

// FUNCTION PROTOTYPES GO HERE:
void readOrders(vector<Order> & orders, int max_price);
void displayOrders(vector<Order> & orders);
void createGraph(vector<Order> & orders, int max_price);
bool isLowNum(char x);
bool existingID(vector<Order> & orders, string id);
string readID(vector<Order> & orders);
double readPrice(double max_price);
int readQuantity();
Time readTime();



int main()
{
	// Declare constant
	double max_price = 100.0;

	vector<Order> orders;

	// Call the function in TASK 6
	readOrders(orders, max_price);
	
	// Write code to call the functions in TASK 13 and TASK 14
	if (orders.size() > 0) {
		displayOrders(orders);
		createGraph(orders, max_price);
	}
	
  return 0;
}
			 
// CLASS MEMBER FUNCTION DEFINITIONS GO HERE:

void Time::setHours(const int hrs)
{
	hours = hrs;
}

void Time::setMinutes(const int mins)
{
	minutes = mins;
}

void Time::setSeconds(const int secs)
{
	seconds = secs;
}

int Time::getHours() const 
{
	return hours;
}

int Time::getMinutes() const 
{
	return minutes;
}

int Time::getSeconds() const 
{
	return seconds;
}

string Time::twoDigits(const int num) const
{
	if (num < 10) {
		return "0" + to_string(num);
	}
	else {
		return to_string(num);
	}
}

string Time::toString() const
{
	return twoDigits(hours) + ":" + twoDigits(minutes)
	+ ":" + twoDigits(seconds);
}
  
void Order::setPrice(const double cost) 
{
  price = cost;
}

double Order::getPrice() const
{
  return price;
}
  
void Order::setQuantity(const int quant) 
{
  quantity = quant;
}

int Order::getQuantity() const
{
  return quantity;
}
  
void Order::setID(const string ident)
{
  id = ident;
}

string Order::getID() const
{
  return id;
}
  
void Order::setTime(const Time t)
{
  time = t;
}

Time Order::getTime() const
{
  return time;
}
  
void Order::display() const
{
  cout << "Order " << getID() << ", $" << fixed << setprecision(2) << getPrice() << ", " 
  << setprecision(0) << getQuantity() << " units, costs $" << setprecision(2) << 
  getPrice() * getQuantity() << ", taken @ " << getTime().toString() << endl;
}


// FUNCTION DEFINITIONS GO HERE:

// gets orders from user
void readOrders(vector<Order> & orders, int max_price) {
    int i(0);
	string temp;
    
    cout << "Enter today's orders:" << endl;
    
    while (true) {
        temp = "";
		cout << "Order #" << i + 1 << " -" << endl;
        temp = readID(orders);
        
        if (temp == "null") { break; }
        
        Order newOrder;
        orders.push_back(newOrder);
        
        orders.at(i).setID(temp);
        orders.at(i).setPrice(readPrice(max_price));
        orders.at(i).setQuantity(readQuantity());
		orders.at(i).setTime(readTime());
        
        orders.at(i).display();
        cin.ignore();
        i++;
		cout << endl;
    }
}

// gets order ID from user
string readID(vector<Order> & orders) {
    string id;
    bool valid(false);
    
    while (!valid) {
        
        cout << "ID: ";
        getline(cin, id);
		
		if (id.empty()) {
			return "null";
		}
        
        // validity check
		if (id.size() != 2) {
			cout << "Invalid id, try again." << endl;
		}
        else if (isLowNum(id.at(0)) && isLowNum(id.at(1)) && !existingID(orders, id)) {
			valid = true;
        }
        else {
            cout << "Invalid id, try again." << endl;
        }
    }
    return id;
}

// determines if character is lowercase OR number
bool isLowNum(char x) {
    if (islower(x) || isdigit(x)) {
        return true;
    }
    return false;
}

// determines if ID exists in order list
bool existingID(vector<Order> & orders, string id) {
    
    for (int i(0); i < orders.size(); i++) {
        if (id == orders.at(i).getID()) {
            return true;
        }
    }
    
    return false;
}

// gets price from user
double readPrice(double max_price) {
    double price;
    
    while (true) {
        cout << "Price: ";
        cin >> price;
        if (price > max_price || price <= 0) {
            cout << "Invalid price, try again." << endl;
        }
        else { break; }
    }
    
    return price;
}

// gets quantity from user
int readQuantity() {
    int quantity;
    
    while (true) {
        cout << "Quantity: ";
        cin >> quantity;
        
        if (quantity <= 0) {
            cout << "Invalid quantity, try again." << endl;
        }
        else { break; }
    }
    
    return quantity;
}

// gets time from user
Time readTime() {
   	int hours, mins, secs;
	Time time;
	
	while (true) {
		cout << "Time (hrs, min, sec): ";
		cin >> hours >> mins >> secs;
		
		if (hours > 23 || hours < 0) {
			cout << "Invalid time, try again." << endl;
		}
		else if (mins > 59 || mins < 0) {
			cout << "Invalid time, try again." << endl;
		}
		else if (secs > 59 || secs < 0) {
			cout << "Invalid time, try again." << endl;
		}
		else {
			break;
		}
	}
	
	time.setHours(hours);
	time.setMinutes(mins);
	time.setSeconds(secs);
	
	return time;
}

// prints out orders
void displayOrders(vector<Order> & orders) {
    cout << endl << "Orders:" << endl;
	
	for (int i(0); i < orders.size(); i++) {
		orders.at(i).display();
	}
	cout << endl;
}

// prints out bar graph
void createGraph(vector<Order> & orders, int max_price) {
	int curRange, lastRange;
	
	cout << "Price Histogram: " << endl;
	
	for (int i(0); i < max_price / 20; i++) {
		curRange = (i + 1) * 20;
		lastRange = curRange - 20;
		cout << setw(3) << curRange << ": ";
		
		for (int j(0); j < orders.size(); j++) {
			if (orders.at(j).getPrice() <= curRange && orders.at(j).getPrice() > lastRange) {
				cout << "$";
			}
		}
		
		cout << endl;
	}
	
}
