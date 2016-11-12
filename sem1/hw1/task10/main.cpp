#include <iostream>

using namespace std;
void initialization(char array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}

int main()
{
    int strLength = 0;
    cout << "Введите длину строки: ";
    cin >> strLength;
    char *str = new char[strLength];
    initialization(str, strLength);
    cout << "Введите строку: ";
    for (int i = 0; i < strLength; i++)
    {
        cin >> str[i];
    }
    
    bool isPalindrome = true;
    for (int i = 0; i < strLength / 2; i++)
    {
        if (str[i] != str[strLength - i - 1])
        {
            isPalindrome = false;
        }
    }
    if (isPalindrome)
    {
        cout << "Данная строка является палиндромом" << endl;
    }
    else
    {
        cout << "Данная строка не является палиндромом" << endl;
    }
    delete [] str;
    return 0;
}
