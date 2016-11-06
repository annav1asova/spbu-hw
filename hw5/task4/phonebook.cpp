#include "phonebook.h"
#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct ListElement
{
    char name[100];
    long long value;
    ListElement *next;
};

struct List
{
    ListElement *first;
    int size;

};

List* createList()
{
    List *list = new List;
    list->first = nullptr;
    list->size = 0;
    return list;
}

void deleteList(List *list)
{
    if (isEmpty(list))
    {
        delete list;
        return;
    }

    while (list->first->next != nullptr)
    {
        ListElement *toDelete = list->first;
        list->first = list->first->next;
        delete toDelete;
    }
    delete list->first;
    delete list;
}

ListElement *createNewElement(long long value, char name[], ListElement *next)
{
    ListElement *newElement = new ListElement;
    newElement->next = next;
    newElement->value = value;
    fillName(newElement->name, name);
    return newElement;
}

void add(List *list, long long value, char name[])
{
    if (isEmpty(list))
    {
        list->first = createNewElement(value, name, nullptr);
        list->size = 1;
        return;
    }
    list->first = createNewElement(value, name, list->first);
    list->size++;
}

long long findValue(List *list, char name[])
{
    if (isEmpty(list))
        return -1;

    ListElement *temp = list->first;
    if (temp->next == nullptr && areNamesEqual(temp->name, name))
    {
        return temp->value;
    }
    while (temp->next != nullptr && !areNamesEqual(temp->name, name))
    {
        temp = temp->next;
    }
    if (!areNamesEqual(temp->name, name))
        return -1;

    return temp->value;
}

char *findName(List *list, long long value)
{
    if (isEmpty(list))
        return " ";

    ListElement *temp = list->first;
    if (temp->next == nullptr && temp->value == value)
    {
        return temp->name;
    }

    while (temp->next != nullptr && temp->value != value)
    {
        temp = temp->next;
    }
    if (temp->value != value)
        return " ";

    return temp->name;
}

bool isEmpty(List *list)
{
    return !size(list);
}

int size(List *list)
{
    return list->size;
}

void showList(List *list)
{
    ListElement *temp = list->first;
    while (temp != nullptr)
    {
        cout << temp->name << " ";
        cout << temp->value << endl;
        temp = temp->next;
    }
}

void saveList(List *list)
{
    ofstream fout;
    fout.open("phonebook.txt", ios::out);
    ListElement *temp = list->first;
    while (temp != nullptr)
    {
        fout << temp->name << " " << temp->value << endl;
        temp = temp->next;
    }
    fout.close();
}

bool areNamesEqual(char firstArray[], char secondArray[])
{
    bool isEqual = true;
    if (strlen(firstArray) != strlen(secondArray))
        return false;
    int firstLength = strlen(firstArray);
    for (int i = 0; i < firstLength; i++)
    {
        if (firstArray[i] != secondArray[i])
            isEqual = false;
    }
    return isEqual;
}

void fillName(char firstArray[], char secondArray[])
{
    int secondLength = strlen(secondArray);
    for (int i = 0; i < secondLength; i++)
    {
        firstArray[i] = secondArray[i];
    }
}
