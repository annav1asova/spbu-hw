#include <string.h>
#include <iostream>
#include "rabinkarp.h"

long long hash(char substring[], int m, long int *power, long int module)
{
    long long hashCode = 0;
    for (int i = 0; i < m; i++)
    {
        hashCode += ((substring[i] - 'a') * power[m - i - 1]) % module;
    }
    hashCode = hashCode % module;
    return hashCode;
}

bool equals(char string[], char substring[], int i, int m)
{
    bool areEqual = true;
    for (int j = 0; j < m; j++)
    {
        if (string[i + j] != substring[j])
            areEqual = false;
    }
    return areEqual;
}

void rabinKarp(char *string, char *substring)
{
    int m = strlen(substring);
    const int n = strlen(string);
    long int *power = new long int[m];
    power[0] = 1;
    int p = 139;
    long int module = 1073676287;
    for (int i = 1; i < m; i++)
    {
        power[i] = (power[i - 1] * p) % module;
    }
    long int substringHash = hash(substring, m, power, module);
    long int stringHash = hash(string, m, power, module);
    
    bool found = false;
    
    for (int i = 0; i < n - m + 1; i++)
    {
        if (stringHash == substringHash)
        {
            if (equals(string, substring, i, m))
            {
                std::cout << "Найдено вхождение подстроки с " << (i + 1) << " символа" << std::endl;
                found = true;
            }
        }
        stringHash -= ((string[i] - 'a') * power[m - 1]) % module;
        stringHash = (stringHash * p + (string[i + m] - 'a')) % module;
        while (stringHash < 0)
        {
            stringHash += module;
        }
    }
    if (!found)
        std::cout << "Не найдено вхождений" << std::endl;
    
    delete [] power;
}
