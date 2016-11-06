#include <iostream>

using namespace std;

void decomposition(int leftSum, int max, int i, int sum[])
{
    if (leftSum < 0)
    {
        return;
    }
    if (leftSum == 0)
    {
        for (int j = 0; j < i - 1; j++)
        {
            cout << sum[j] << '+';
        }
        cout << sum[i - 1] << endl;
    }
    else
    {
        if (leftSum - max >= 0)
        {
            sum[i] = max;
            decomposition(leftSum - max, max, i + 1, sum);
        }
        if (max - 1 > 0)
        {
            decomposition(leftSum, max - 1, i, sum);
        }
    }
}

int main()
{
    cout << "Введите число n: ";
    int n = 0;
    cin >> n;
    const int a = 500;
    int sum[a] = {0};
    cout << "Разложения n: " << endl;
    decomposition(n, n, 0, sum);
}
