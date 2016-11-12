#include <iostream>
#include <fstream>

using namespace std;

int setToZero(int size, bool array[])
{
    for (int i = 0; i < size; i++)
    {
        array[i] = false;
    }
}

int main()
{
    ifstream fin("/Users/annavlasova/TextFile/input.txt");
    
    char text[100000];
    int index = 0;
    while (!fin.eof())
    {
        fin.get(text[index]);
        index++;
    }
    cout << "Полученный текст: ";
    
    const int alphabetLength = 26;
    bool wasLetterUsed[alphabetLength] = {false};
    for (int i = 0; i < index; i++)
    {
        char temp = text[i];
        if (int(temp) == int(' ') || int(temp) == int('\n'))
        {
            cout << temp;
            setToZero(alphabetLength, wasLetterUsed);
        }
        else if (int(temp) <= int('z') && int(temp) >= 'a' )
        {
            if (!wasLetterUsed[int(text[i]) - int('a')])
            {
                cout << text[i];
                wasLetterUsed[int(text[i]) - int('a')] = true;
            }
        }
        else
        {
            cout << temp;
        }
    }
    cout << endl;
    fin.close();
}
