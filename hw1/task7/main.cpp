#include <iostream>
#include<cmath>

using namespace std;
int main()
{
    int n = 0;
    cout << "Введите число n: ";
    cin >> n;
    for (int i = 1; i <= n; ++i)
    {
        bool isPrime = true;
        for (int j = 2; j <= sqrt(i); ++j)
        {
            if (i % j == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            cout << i << endl;
        }
    }
    return 0;
}
