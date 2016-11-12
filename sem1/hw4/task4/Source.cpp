#include <iostream>
#include "Stack.h"
#include "PostfixCalculation.h"
#include <fstream>

using namespace std;

int main()
{
    ifstream fin("input.txt");

    char myString[1000000] = {""};
    int index = 0;
    if (fin)
    {
        while (!fin.eof())
        {
            fin.get(myString[index]);
            index++;
        }
        int result = postfixCalculation(index, myString);
        cout << result << endl;
    }
    fin.close();
}
