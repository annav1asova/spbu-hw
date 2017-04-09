#pragma once

#include "mystring.h"
#include "list.h"

struct HashTable;

HashTable *createHashTable();

void deleteHashTable(HashTable *hash);

int hash(String *string);

void addToHash(HashTable *hash, String *string);

double amountOfWords(HashTable *hash);

double loadFactor(HashTable *hash);

int maxChainLength(HashTable *hash);

void maxChain(HashTable *hash);

double averageNotEmptyChain(HashTable *hash);

int emptyCell(HashTable *hash);

int count(HashTable *hash, String *string);


