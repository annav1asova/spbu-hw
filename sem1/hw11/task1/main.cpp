#include <iostream>

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
    int sost = 0;
    for (int i = 0; i < strlen(string); i++)
    {
        char symb = string[i];
        switch (sost)
        {
            case 0:
                if (isSign(symb))
                    sost = 1;
                else if (isDigit(symb))
                    sost = 2;
                else
                    return false;
                break;
            case 1:
                if (isDigit(symb))
                    sost = 2;
                else
                    return false;
                break;
            case 2:
                if (isDigit(symb))
                    sost = 2;
                else if (isDot(symb))
                    sost = 3;
                else if (isE(symb))
                    sost = 5;
                else
                    return false;
                break;
            case 3:
                if (isDigit(symb))
                    sost = 4;
                else
                    return false;
                break;
            case 4:
                if (isDigit(symb))
                    sost = 4;
                else if (isE(symb))
                    sost = 5;
                else
                    return false;
                break;
            case 5:
                if (isSign(symb))
                    sost = 6;
                else if (isDigit(symb))
                    sost = 7;
                else
                    return false;
                break;
            case 6:
                if (isDigit(symb))
                    sost = 7;
                else
                    return false;
                break;
            case 7:
                if (isDigit(symb))
                    sost = 7;
                else
                    return false;
                break;
        }
    }
    if (sost == 2 || sost == 4 || sost == 7)
        return true;
    else
        return false;
}

int main()
{
    for (int i = 0; i < 25; i++)
    {
    char string[100] = {""};
    cin >> string;
    if (isCorrectDouble(string))
        cout << "Your string is correct real number" << endl;
    else
        cout << "Your string isn't correct real number" << endl;
    }
}
