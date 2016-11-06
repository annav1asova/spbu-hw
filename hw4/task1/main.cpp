#include <iostream>

using namespace std;
void input(int n, int arr[][1000])
{
    cout << "Введите массив:";
    for (int i = 0; i < n; i++)
    {
        for ( int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }
}

void outputSpiral(int n, int arr[][1000])
{
    int curI = n / 2;
    int curJ = n / 2;
    cout << "Массив по спирали: " << arr[curI][curJ] << " ";
    int curMax = 1;
    int cur = 0;
    while (curMax <= n)
    {
        cur = 0;
        while (cur < curMax && curI > 0)
        {
            curI--;
            cur++;
            cout << arr[curI][curJ] << " ";
        }
        cur = 0;
        while (cur < curMax && curMax < n)
        {
            curJ++;
            cur++;
            cout << arr[curI][curJ] << " ";
        }
        cur = 0;
        curMax++;
        while (cur < curMax && curMax < n)
        {
            curI++;
            cur++;
            cout << arr[curI][curJ] << " ";
        }
        cur = 0;
        while (cur < curMax && curMax < n)
        {
            curJ--;
            cur++;
            cout << arr[curI][curJ] << " ";
        }
        curMax++;
    }
    cout << endl;
}

int main()
{
    int n = 0;
    cout << "Введите число n:";
    cin >> n;
    int arr[1000][1000] = {0};
    input(n, arr);
    outputSpiral(n, arr);
}
