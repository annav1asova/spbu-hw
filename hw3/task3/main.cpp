#include <iostream>

using namespace std;

void input(int n, char array[])
{
    cout << "Введите строку: ";
    for (int i = 0; i < n; i++)
    {
        cin >> array[i];
    }
}

void swap(char *a, char *b)
{
    int t = (int)*a;
    *a = (int)*b;
    *b = t;
}

void qsort(char array[], int left, int right)
{
    int i = left;
    int j = right;
    int x = (int)array[left];
    while (i <= j)
    {
        while (i <= right && (int)array[i] < x)
        {
            i++;
        }
        while ((int)array[j] > x)
        {
            j--;
        }
        if (i <= j)
        {
            swap(array[i], array[j]);
            i++;
            j--;
        }
    }
    if (i < right)
    {
        qsort(array, i, right);
    }
    if (j > left)
    {
        qsort(array, left, j);
    }
}

int main()
{
    cout << "Введите длину первой строки: ";
    int n = 0;
    cin >> n;
    char *firstArray = new char[n];
    input(n, firstArray);
    qsort(firstArray, 0, n - 1);
    
    cout << "Введите длину второй строки: ";
    int m = 0;
    cin >> m;
    char *secondArray = new char[m];
    input(m, secondArray);
    qsort(secondArray, 0, m - 1);
    
    bool isRearrangeable = true;
    if (m == n)
    {
        for (int i = 0; i < m; i++)
        {
            if (firstArray[i] != secondArray[i])
            {
                isRearrangeable = false;
            }
        }
        
    }
    else
    {
        isRearrangeable = false;
    }
    
    if (isRearrangeable)
    {
        cout << "Из первой можно получить вторую" << endl;
    }
    else
    {
        cout << "Из первой нельзя получить вторую" << endl;
    }
    delete [] firstArray;
    delete [] secondArray;
    return 0;
}
