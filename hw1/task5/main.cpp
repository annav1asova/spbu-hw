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
    int n = 0;
    cout << "Введите длину скобочной последовательности: ";
    cin >> n;
    char str[n];
    initialization(str, n);
    cout << "Введите скобочную последовательность: ";
    for (int i = 0; i < n; i++)
    {
        cin >> str[i];
    }
    int balance = 0;
    bool flag = true;
    for (int i = 0; i < n; i++)
    {
        if (str[i] == '(')
        {
            balance++;
        }
        else
        {
            balance--;
        }
        if (balance < 0)
        {
            flag = false;
        }
    }
    if (balance == 0 && flag)
    {
        cout << "Вы ввели правильную скобочную последовательность" << endl;
    }
    else
    {
        cout << "Вы ввели неправильную скобочную последовательность" << endl;
    }
    return 0;
}
