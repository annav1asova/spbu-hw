#include <iostream>
#include "Stack.h"
#include "InfixToPostfix.h"
#include <fstream>

using namespace std;

int main()
{
    ifstream fin("input.txt");

    char myString[1000000] = {""};
    char resultString[100000] = {""};
    int index = 0;
    if(fin)
    {
        while (!fin.eof())
        {
            fin.get(myString[index]);
            index++;
        }
        infixToPostfix(index, myString, 0, resultString);
    }
    fin.close();
}
