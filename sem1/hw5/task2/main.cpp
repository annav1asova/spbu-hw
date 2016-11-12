#include <iostream>
#include "circularlist.h"

using namespace std;

int lastOne(CircularList *list, int m)
{
    int value = valueOfFirst(list);
    while(size(list) != 1)
    {
        int i = 1;
        while (i < m - 1)
        {
            value = nextValue(list, value);
            i++;
        }
        remove(list, nextValue(list, value));
        value = nextValue(list, value);
        showList(list);
    }
    return valueOfFirst(list);
}

int main()
{
    CircularList *list = createList();
    cout << "Введите число n: ";
    int n = 0;
    cin >> n;
    cout << "Введите число m: ";
    int m = 0;
    cin >> m;

    for (int i = 1; i <= n; i++)
    {
        add(list, i);
    }

    int result = lastOne(list, m);
    cout << "Последним останется : " << result << endl;
    deleteList(list);
}


