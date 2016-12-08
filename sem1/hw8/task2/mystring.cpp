#include <iostream>
#include <string.h>
#include "mystring.h"

using namespace std;

struct String
{
    char *value;
    int length;
};

String *createString(char *stringCharacters)
{
    String *str = new String;
    str->length = strlen(stringCharacters);
    str->value = new char[str->length + 1];
    strncpy(str->value, stringCharacters, str->length);
    str->value[str->length] = '\0';
    return str;
}

void deleteString(String *string)
{
    delete[] string->value;
    string->value = nullptr;
    delete string;
}

String *clone(String *string)
{
    String *newString = createString(string->value);
    return newString;
}

String *concatenation(String *string, String *arg)
{
    char *resultString = new char[string->length + arg->length + 1];
    for (int i = 0; i < string->length; i++)
    {
        resultString[i] = string->value[i];
    }
    for (int i = 0; i < arg->length; i++)
    {
        resultString[i + string->length] = arg->value[i];
    }
    resultString[arg->length + string->length] = '\0';
    String *result = createString(resultString);
    delete[] resultString;
    return result;
}

bool equals(String *first, String *second)
{
    bool isEqual = true;
    if (first->length != second->length)
        return false;
    for (int i = 0; i < first->length; i++)
    {
        if (first->value[i] != second->value[i])
            isEqual = false;
    }
    return isEqual;
}

int length(String *string)
{
    return string->length;
}

bool isEmpty(String *string)
{
    return (string->length == 0);
}

String *substring(String *string, int from, int to)
{
    char *resultString = new char[to - from + 1];
    for (int i = from; i < to; i++)
    {
        resultString[i - from] = string->value[i];
    }
    resultString[to - from] = '\0';
    String *result = createString(resultString);
    delete[] resultString;
    return result;
}

char *getChar(String *string)
{
    return string->value;
}

void print(String *string)
{
    for (int i = 0; i < string->length; i++)
        cout << string->value[i];
    cout << endl;
}

