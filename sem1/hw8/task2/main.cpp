#include <iostream>
#include "mystring.h"

using namespace std;

int main()
{
    String *first = createString("abacabadab");
    print(first);
    String *second = createString("abacaba");
    print(second);

    String *sum = concatenation(first, second);
    print(sum);

    String *third = clone(sum);
    print(third);

    if (equals(first, second))
        cout << "Строки равны" << endl;
    else
        cout << "Строки не равны" << endl;

    cout << "Длина первой строки " << length(first) << endl;

    String *substr = substring(sum, 5, 11);
    print(substr);

    deleteString(first);
    deleteString(second);
    deleteString(sum);
    deleteString(third);
    deleteString(substr);
}

