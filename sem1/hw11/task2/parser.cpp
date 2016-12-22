#include "parser.h"
#include "lexer.h"

//      grammar:
//      E -> TE1
//      E1 -> +E | -E | e
//      T -> NT1
//      T1 -> *T | /T | e

using namespace std;
#include <iostream>

bool E(char [], int &);
bool E1(char [], int &);
bool T(char [], int &);
bool T1(char [], int &);
void skipSpaces(char [], int &);

bool E(char string[], int &index)
{
    skipSpaces(string, index);
    if (T(string, index))
        return E1(string, index);
    return false;
}

bool E1(char string[], int &index)
{
    skipSpaces(string, index);
    if (string[index] == '+' || string[index] == '-')
    {
        index++;
        return E(string, index);
    }
    else
        return true;
}

bool T(char string[], int &index)
{
    skipSpaces(string, index);
    if (isCorrectDouble(string, index))
        return T1(string, index);
    else
        return false;
}

bool T1(char string[], int &index)
{
    skipSpaces(string, index);
    if (string[index] == '*' || string[index] == '/')
    {
        index++;
        return T(string, index);
    }
    else
        return true;

}

void skipSpaces(char string[], int &index)
{
    while (string[index] == ' ')
        index++;
}
