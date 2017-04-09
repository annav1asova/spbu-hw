#include <iostream>
#include <fstream>
#include "mystring.h"
#include "list.h"
#include "hashtable.h"
#include <cstring>

using namespace std;

bool isLetter(char ch)
{
    return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
}

void clean(char array[])
{
    for (int i = 0; i < 100; i++)
    {
        array[i] ='\0';
    }
}

bool equalsExit(char array[])
{
    char testWord[100] = "exit.";
    int length = strlen(testWord);
    bool isExit = true;
    for (int i = 0; i < length; i++)
    {
        if (array[i] != testWord[i])
            isExit = false;
    }
    return isExit;
}

int main()
{
    ifstream fin("input.txt");
    if (fin)
    {
        HashTable *hash = createHashTable();
        char word[100] = {'\0'};
        char ch = '\0';
        int currentIndex = 0;
        fin.get(ch);

        while (!fin.eof())
        {
            if (ch == ' ' || ch == '\n')
            {
                if (currentIndex != 0)
                {
                    String *newWord = createString(word);
                    addToHash(hash, newWord);
                    deleteString(newWord);
                    currentIndex = 0;
                    clean(word);
                }
            }
            else
            {
                if (isLetter(ch) || ch == 39) //кавычку не поставить в кавычки..
                {
                    word[currentIndex] = ch;
                    currentIndex++;
                }
            }
            fin.get(ch);
        }


        cout << "words added: " << amountOfWords(hash) << endl;
        cout << "load factor: " << loadFactor(hash) << endl;
        cout << "averageNotEmptyChainLength: " << averageNotEmptyChain(hash) << endl;
        cout << "maxChainLength: " << maxChainLength(hash) << endl;
        cout << "maxChain: " << endl;
        maxChain(hash);
        cout << "emptyCell: " << emptyCell(hash) << endl << endl;

        cout << "Вы можете вводить слова, чтобы узнать частоту их встречаемости в тексте. Для выхода наберите exit. " << endl;
        char testWord[100] = "exit.";
        cin >> testWord;
        while (!equalsExit(testWord))
        {
            String *testString = createString(testWord);
            cout << "Количество вхождений данного слова: " << count(hash, testString) << endl;
            clean(testWord);
            cin >> testWord;
        }
        deleteHashTable(hash);
    }
    fin.close();
}
