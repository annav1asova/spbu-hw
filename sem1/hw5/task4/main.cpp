#include <iostream>
#include <fstream>
#include "phonebook.h"
#include <string.h>

using namespace std;

void addContact(List *list)
{
    cout << "..идет добавление контакта.." << endl;
    cout << "Введите имя: ";
    char name[100] ={""};
    cin >> name;
    cout << "Введите телефон: ";
    long long value = 0;
    cin >> value;
    add(list, value, name);
    cout << "Контакт добавлен" << endl;
}

void findValue(List *list)
{
    cout << "Введите имя: ";
    char name[100] ={""};
    cin >> name;
    long long value = findValue(list, name);
    if (value == -1)
        cout << "Контакт не найден" << endl;
    else
        cout << "Искомый телефон: " << value << endl;
}

void findName(List *list)
{
    cout << "Введите номер: ";
    long long value = 0;
    cin >> value;
    char name[100] = {""};
    fillName(name, findName(list, value));
    if (name[0] == ' ' && strlen(name) == 1)
        cout << "Контакт не найден" << endl;
    else
        cout << "Искомое имя: " << name << endl;
}

void show(List *list)
{
    cout << "Полученный список: ";
    showList(list);
}

void printToFile(List *list)
{
    saveList(list);
    cout << "Ваш список контактов сохранен в файл";
}

int main()
{
    ifstream fin;
    fin.open("phonebook.txt", ios::in);

    List *list = createList();
    cout << "Вы можете вводить команды:" << endl;
    cout << "0 - выйти;" << endl;
    cout << "1 - добавить запись (имя и телефон);" << endl;
    cout << "2 - найти телефон по имени;" << endl;
    cout << "3 - найти имя по телефону;" << endl;
    cout << "4 - сохранить текущие данные в файл." << endl;

    while(!fin.eof())
    {
        char name[100] = {""};
        long  value = 0;
        fin >> name >> value;
        if (value)
            add(list, value, name);
        else
            break;
    }

    enum  Command {exit, add, searchValue, searchName, print};
    int inputCommand = 0;
    cin >> inputCommand;

    while (inputCommand){
        switch (inputCommand)
        {
        case exit:
            break;
        case add:
            addContact(list);
            break;
        case searchValue:
            findValue(list);
            break;
        case searchName:
            findName(list);
            break;
        case print:
            printToFile(list);
            break;
        }
        cin >> inputCommand;
    }
    deleteList(list);
}
