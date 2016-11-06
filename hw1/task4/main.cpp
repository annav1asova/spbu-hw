#include <iostream>

using namespace std;
int main()
{
    int arr[28] = {0,};
    int result = 0;
    for (int i = 0; i < 10; ++i)
    {
        for (int j = 0; j < 10; ++j)
        {
            for (int k = 0; k < 10; ++k)
            {
                arr[i + j + k]++;
            }
        }
    }
    for (int i = 0; i < 28; ++i)
    {
        result = result + arr[i] * arr[i];
    }
    cout << "Количество счастливых билетиков:" << result << endl;
    return 0;
}
