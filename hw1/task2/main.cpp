
#include <iostream>

using namespace std;
int main()
{
    int x = 0;
    int y = 1;
    int result = 0;
    cout << "Введите число x: ";
    cin >> x;
    cout << "Введите число y (y не может быть равно 0): ";
    cin >> y;
    while (x >= y)
    {
        x = x - y;
        result++;
    }
    cout << "Неполное частное от деления x на y:" << result << endl;
    return 0;
}
