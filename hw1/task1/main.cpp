#include <iostream>

using namespace std;
int main()
{
    int x = 0;
    cout << "Введите число x: ";
    cin >> x;
    int square  = x * x;
    int result = (square + 1) * (square + x) + 1;
    cout << "Искомое выражение:" << result << endl;
    return 0;
}
