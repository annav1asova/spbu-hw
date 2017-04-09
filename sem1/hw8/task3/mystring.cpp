#include <iostream>
#include <string.h>
#include "mystring.h"
#include <cstring>

using namespace std;

struct String
{
    char *value;
    int length;
};

String *createString(const char *stringCharacters)
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
    delete [] string->value;
    string->value = nullptr;
    delete string;
}

String *clone(String *string)
{
    char *chars = getChar(string);
    String *clone = createString((chars));
    delete [] chars;
    return clone;
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

char *getChar(String *string)
{
    char *chars = new char[string->length + 1];
    strncpy(chars, string->value, string->length + 1);

    return chars;
}

void print(String *string)
{
    for (int i = 0; i < string->length; i++)
        cout << string->value[i];
    cout << endl;
}
