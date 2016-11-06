#include <iostream>

using namespace std;

void input(int array[])
{
    long x = 0;
    cin >> x;
    while (x >= 1)
    {
        int a = x % 10;
        array[a]++;
        x = x / 10;
    }
}
int main()
{
    cout << "Введите число: ";
    int array[10] = {0};
    input(array);
    cout << "Минимальное число, записанное этими же цифрами: ";
    for (int i = 1; i <= 9; i++)
    {
        if (array[i] > 0)
        {
            cout << i;
            array[i]--;
            break;
        }
    }
    for (int i = 0; i <= 9; i++)
    {
        for (int j = 0; j < array[i]; j++)
        {
            cout << i;
        }
    }
    cout << endl;
    return 0;
}
