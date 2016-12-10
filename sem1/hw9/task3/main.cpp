#include <iostream>
#include <string.h>
#include "rabinkarp.h"

using namespace std;

int main()
{
    cout << "Введите строку: ";
    char string[10000] = {};
    cin.getline(string, 10000);

    cout << "Введите строку-образец: ";
    char substring[10000] = {};
    cin.getline(substring, 10000);

    rabinKarp(string, substring);
}


