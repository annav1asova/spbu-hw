#include <iostream>
#include <cmath>

using namespace std;

bool correct(int thinked[], int index)
{
    bool isCorrect = true;
    for (int i = 0; i < index; i++)
    {
        if (thinked[i] == thinked[index])
        {
            isCorrect = false;
        }
    }
    return isCorrect;
}

void generation(int size, int thinked[]){
    srand(time(0));
    thinked[0] = rand() % 9 + 1;
    for (int i = 0; i < size; i++)
    {
        thinked[i] = rand() % 10;
    }
    for (int i = 1; i < size; i++)
    {
        while (!correct(thinked, i))
        {
            thinked[i] = rand() % 10;
        }
    }
}

int bull(int first[], int second[], int size)
{
    int bulls = 0;
    for (int i = 0; i < size; i++)
    {
        if (first[i] == second[i]) bulls++;
    }
    return bulls;
}
int cow(int first[], int second[], int size)
{
    int cows = 0;
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            if (first[i] == second[j] && i != j)
            {
                cows++;
            }
        }
    }
    return cows;
}
int pow(int a, int b)
{
    int res = 1;
    for (int i = 0; i < b; i++)
    {
        res = res * a;
    }
    return res;
}

void input(int size, int yourTry[])
{
    int x = 0;
    cin >> x;
    for (int i = size - 1; i >= 0; i--)
    {
        yourTry[i] = (x / pow(10, size - i - 1)) % 10;
    }
}

int main()
{
    const int size = 4;
    int thinked[size] = {0};
    int yourTry[size] = {0};
    generation(size, thinked);
    //cout << thinked[0] << thinked[1] << thinked[2] << thinked[3] << endl;
    bool isGuessed = false;
    while (!isGuessed)
    {
        input(size, yourTry);
        int bulls = bull(yourTry, thinked, size);
        int cows = cow(yourTry, thinked, size);
        if (bulls == size)
        {
            isGuessed = true;
            cout << "Вы угадали!" << endl;
        }
        else
        {
            cout << bulls << " bull(s), " << cows << " cow(s)" << endl;
        }
    }
}
