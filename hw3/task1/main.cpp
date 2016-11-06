#include <iostream>

using namespace std;
int pow(int a, int n)
{
    if (n == 1)
    {
        return a;
    }
    else
    {
        if (n % 2 == 0)
        {
            return pow(a * a, n / 2);
        }
        else
        {
            return a * pow(a, n - 1);
        }
    }
}

int main()
{
    cout << "Введите число: ";
    int a = 0;
    cin >> a;
    cout << "Введите степень: ";
    int n = 0;
    cin >> n;
    cout << "Данное число в данной степени: " << pow(a, n) << endl;
    return 0;
}
