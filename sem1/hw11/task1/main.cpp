#include <iostream>
#include <string.h>

using namespace std;

bool isDigit(char s)
{
    return (s >= '0' && s <= '9');
}

bool isSign(char s)
{
    return (s == '-' || s == '+');
}

bool isDot(char s)
{
    return (s == '.');
}

bool isE(char s)
{
    return (s == 'E');
}

bool isCorrectDouble (char string[])
{
    int state = 0;
    int length = strlen(string);
    for (int i = 0; i < length; i++)
    {
        char symb = string[i];
        switch (state)
        {
            case 0:
                if (isSign(symb))
                    state = 1;
                else if (isDigit(symb))
                    state = 2;
                else
                    return false;
                break;
            case 1:
                if (isDigit(symb))
                    state = 2;
                else
                    return false;
                break;
            case 2:
                if (isDigit(symb))
                    state = 2;
                else if (isDot(symb))
                    state = 3;
                else if (isE(symb))
                    state = 5;
                else
                    return false;
                break;
            case 3:
                if (isDigit(symb))
                    state = 4;
                else
                    return false;
                break;
            case 4:
                if (isDigit(symb))
                    state = 4;
                else if (isE(symb))
                    state = 5;
                else
                    return false;
                break;
            case 5:
                if (isSign(symb))
                    state = 6;
                else if (isDigit(symb))
                    state = 7;
                else
                    return false;
                break;
            case 6:
                if (isDigit(symb))
                    state = 7;
                else
                    return false;
                break;
            case 7:
                if (isDigit(symb))
                    state = 7;
                else
                    return false;
                break;
        }
    }
    if (state == 2 || state == 4 || state == 7)
        return true;
    else
        return false;
}

int main()
{
    cout << "Введите строку: " << endl;
    char string[100] = {""};
    cin >> string;
    if (isCorrectDouble(string))
        cout << "Ваша строка является вещественным числом" << endl;
    else
        cout << "Ваша строка не является вещественным числом" << endl;
}
