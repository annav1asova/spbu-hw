#include <iostream>
#include <fstream>
#include <cctype>
#include <cstring>

using namespace std;

int digit(int a)
{
    int result = 0;
    while (a > 0)
    {
        a = a / 10;
        result++;
    }
    return result;
}

int powTen(int a)
{
    int result = 1;
    for (int i = 0; i < a; i++)
    {
        result *= 10;
    }
    return result;
}

bool isNull(char str[], int i, int strLength)
{
    return (str[i] == '0' && (i == 0 || str[i - 1] == ' ') && (i == strLength - 2 || str[i + 1] == ' '));
}

bool lastNull(char str[], int i, int strLength)
{
    return (str[i] == '0' && (i == 0 || str[i - 1] == ' ') && i == strLength - 2);
}

bool isOne(char str[], int i)
{
    return (str[i] == '1' && (i == 0 || (str[i - 1] == ' ' || str[i - 1] == '-')) && str[i + 1] == ' ');
}

int main()
{
    cout << "Введите коэффициенты: ";
    char str[10000] = {""};
    fgets(str, 10000, stdin);
    int strLength = strlen(str);

    int spaces = 0;
    for (int i = 0; i < strLength; i++)
    {
        if (str[i] == ' ')
        {
            spaces++;
        }
    }

    char strFirst[10000] = {""};
    char strSecond[10000] = {""};
    int cur = 0;

    int currentPow = spaces;
    int i = 0;
    while (i < strLength)
    {
        if (str[i] == '-' && i > 0)
            strSecond[cur - 2] = '-';
        else if (str[i] != ' ')
        {
            if (isNull(str, i, strLength))
            {
                if (lastNull(str, i, strLength))
                    strSecond[cur - 2] = ' ';
                currentPow--;
                i++;
            }
            else if (!isOne(str, i))
            {
                strFirst[cur] = ' ';
                strSecond[cur] = str[i];
                cur++;
            }
        }
        else if (str[i] == ' ')
        {
            strFirst[cur] = ' ';
            strSecond[cur] = 'x';
            cur++;

            int tempPow = currentPow;

            if (currentPow != 1)
            {
                for (int j = 0; j < digit(currentPow); j++)
                {
                    strFirst[cur] = (tempPow / powTen((digit(currentPow) - j) - 1)) + '0';
                    strSecond[cur] = ' ';
                    tempPow = tempPow % powTen((digit(currentPow) - j) - 1);
                    cur++;
                }
            }
            else
            {
                strFirst[cur] = ' ';
                strSecond[cur] = ' ';
                cur++;
            }

            strFirst[cur] = ' ';
            strSecond[cur] = '+';
            cur++;
            strFirst[cur] = ' ';
            strSecond[cur] = ' ';
            cur++;

            currentPow--;
        }
        i++;
    }
    cout << strFirst;
    cout << endl;
    cout << strSecond << endl;
}
