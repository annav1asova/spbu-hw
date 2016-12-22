#include <iostream>
#include <fstream>
#include <string.h>
#include "parser.h"

using namespace std;

int main()
{
    ifstream fin("input.txt");
    if (!fin)
        cout << "File can't be opened" << endl;
    else
    {
        char string[1000] = {'\0'};
        fin.getline(string, 1000);
        int index = 0;
        if (E(string, index) && index == strlen(string))
            cout << "Строка является арифметическим выражением" << endl;
        else
            cout << "Строка не является арифметическим выражением" << endl;
    }
   fin.close();
}
