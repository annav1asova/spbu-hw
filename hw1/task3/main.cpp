#include <iostream>
#include<cmath>

using namespace std;
void reverse(int arr[], int start, int finish)
{
    int length = finish - start + 1;
    for (int i = start; i < start + length / 2; ++i){
        int temp = arr[i];
        arr[i] = arr[finish - i + start];
        arr[finish - i + start] = temp;
    }
}

int main()
{
    int n = 0;
    cout << "Введите число n: ";
    cin >> n;
    int m = 0;
    cout << "Введите число m: ";
    cin >> m;
    const int a = n + m;
    int array[a];
    cout << "Введите массив: ";
    for (int i = 0; i < n + m; ++i)
    {
        cin >> array[i];
    }
    reverse(array, 0, n - 1);
    reverse(array, n, n + m - 1);
    reverse(array, 0, n + m - 1);
    for (int i = 0; i < n + m; ++i)
    {
        cout << array[i] << " ";
    }
    return 0;
}
