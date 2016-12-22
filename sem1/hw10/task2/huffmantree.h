#pragma once

#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct Tree;

Tree *createTree();
void deleteTree(Tree *tree);
void printTree(Tree *tree);
void add(Tree *tree, int value);
void parseTree(char string[], int i, Tree *tree);
void decoding(Tree *tree, char encodedText[]);
