#include "List.h"
#include <iostream>

using namespace std;

struct ListElement
{
    int value;
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

ListElement *createNewElement(int value, ListElement *next)
{
    ListElement *newElement = new ListElement;
    newElement->next = next;
    newElement->value = value;
    return newElement;
}

List *addToEmptyList(List *list, int value)
{
    ListElement *toAdd = createNewElement(value, nullptr);
    list->first = toAdd;
    list->size = 1;
    return list;
}
List *addToHead(List *list, int value)
{
    ListElement *toAdd = createNewElement(value, list->first);
    list->first = toAdd;
    list->size++;
    return list;
}

void add(List *list, int value)
{
    if (isEmpty(list))
    {
        addToEmptyList(list, value);
        return;
    }

    if (value < list->first->value)
    {
        addToHead(list, value);
        return;
    }
    ListElement *temp = list->first;
    while (temp->next != nullptr && value > temp->next->value)
    {
        temp = temp->next;
    }
    temp->next = createNewElement(value, temp->next);
    list->size++;
}

void remove(List *list, int value)
{
    if (isEmpty(list))
        return;

    ListElement *temp = list->first;
    if (temp->next == nullptr && temp->value == value)
    {
        delete temp;
        list->first = nullptr;
        list->size = 0;
        return;
    }

    if (temp->value == value)
    {
        list->first = temp->next;
        list->size--;
        delete temp;
        return;
    }

    while (temp->next != nullptr && temp->next->value != value)
    {
        temp = temp->next;
    }
    if (temp->next == nullptr)
        return;

    ListElement *toDelete = temp->next;
    temp->next = temp->next->next;
    delete toDelete;
    list->size--;
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
        cout << temp->value << " ";
        temp = temp->next;
    }
    cout << endl;
}
