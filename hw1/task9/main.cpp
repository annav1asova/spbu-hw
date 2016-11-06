#include <iostream>

using namespace std;
int main()
{
    int a = 0;
    int n = 1;
    cout << "Введите число a: ";
    cin >> a;
    int result = a;
    cout << "Введите число n: ";
    cin >> n;
    for (int i = 1; i < n; i++)
    {
        result = result * a;
    }
    cout << "Значение a в степени n:" << result << endl;
    return 0;
}
