#include <iostream>

using namespace std;
void initialization(char array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}
int main()
{
    int needleLength = 0;
    cout << "Введите длину строки needle: ";
    cin >> needleLength;
    char needle[needleLength];
    initialization(needle,needleLength);
    cout << "Введите строку needle: ";
    for (int i = 0; i < needleLength; i++)
    {
        cin >> needle[i];
    }
    
    int haystackLength = 0;
    cout << "Введите длину строки haystack: ";
    cin >> haystackLength;
    char haystack[haystackLength];
    initialization(haystack,haystackLength);
    cout << "Введите строку haystack: ";
    for (int i = 0; i < haystackLength; i++)
    {
        cin >> haystack[i];
    }
    
    int occurrences = 0;
    for (int i = 0; i < haystackLength - needleLength + 1; i++)
    {
        bool isSubstring = true;
        for (int j = 0; j < needleLength; j++)
        {
            if (needle[j] != haystack[i + j])
            {
                isSubstring = false;
            }
        }
        if (isSubstring)
        {
            occurrences++;
        }
    }
    cout << "Количество вхождений needle в haystack: " << occurrences << endl;
    return 0;
}
