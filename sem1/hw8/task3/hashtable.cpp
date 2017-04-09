#include "mystring.h"
#include "list.h"
#include "hashtable.h"
#include <iostream>

//using namespace std;

const int hashSize = 2000;

struct HashTable{
    List *table[hashSize];
};

HashTable *createHashTable()
{
    HashTable *hash = new HashTable;
    for (int i = 0; i < hashSize; i++)
    {
        hash->table[i] = createList();
    }
    return hash;
}

void deleteHashTable(HashTable *hash)
{
    for (int i = 0; i < hashSize; i++)
    {
        deleteList(hash->table[i]);
    }
    delete hash;
}

int hash(String *string)
{
    long long hash = 2139062143;

    char *sameString = getChar(string);
    int strlen = length(string);

    for (int i = 0; i < strlen; i++)
    {
        hash = (37 * hash + sameString[i]) % hashSize;
    }

    delete [] sameString;
    hash = hash % hashSize;
    return hash;
}

void addToHash(HashTable *table, String *string)
{
    int hashNumber = hash(string);
    add(table->table[hashNumber], string);
}

double amountOfWords(HashTable *hash)
{
    double numberOfWords = 0;
    for (int i = 0; i < hashSize; i++)
    {
        numberOfWords += size(hash->table[i]);
    }
    return numberOfWords;
}

double loadFactor(HashTable *hash)
{
    return (double)(amountOfWords(hash) / hashSize);
}

int maxChainLength(HashTable *hash)
{
    int max = 0;
    for (int i = 0; i < hashSize; i++)
    {
        if (size(hash->table[i]) > max)
            max = size(hash->table[i]);
    }
    return max;
}

void maxChain(HashTable *hash)
{
    int max = 0;
    for (int i = 0; i < hashSize; i++)
    {
        if (size(hash->table[i]) > size(hash->table[max]))
            max = i;
    }
    printList(hash->table[max]);
}

double averageNotEmptyChain(HashTable *hash)
{
    double averageLength = 0;
    int notEmptyChains = 0;
    for (int i = 0; i < hashSize; i++)
    {
        int tempSize = size(hash->table[i]);
        if (tempSize)
        {
            averageLength += size(hash->table[i]);
            notEmptyChains++;
        }
    }
    return (double)(averageLength / notEmptyChains);
}

int emptyCell(HashTable *hash)
{
    int number = 0;
    for (int i = 0; i < hashSize; i++)
    {
        if (size(hash->table[i]) == 0)
            number++;
    }
    return number;
}

int count(HashTable *table, String *string)
{
    int hashNumber = hash(string);
    int result = searchWord(table->table[hashNumber], string);
    return result;
}
