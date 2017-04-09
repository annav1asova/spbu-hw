#pragma once

#include "mystring.h"

struct List;

List* createList();
void add(List *list, String *value);
int size(List *list);
void deleteList(List *list);
bool isEmpty(List *list);
void printList(List *list);
int searchWord(List *list, String *string);
