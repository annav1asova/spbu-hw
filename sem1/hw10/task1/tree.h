#pragma once

#include <fstream>

using namespace std;

const int codeSize = 16;

struct Tree;

Tree *createTree();
Tree *createTreeWithKidsTrees(Tree *first, Tree *second);
void deleteTree(Tree *tree);

void add(Tree *tree, int value, int key);
void remove(Tree *tree, int value);
bool exists(Tree *tree, int value);

void printTree(Tree *tree, ofstream &f);
void printAscendingTree(Tree *tree);
void printDescendingTree(Tree *tree);

int key(Tree *tree);
void getCodes(Tree *tree, char codes[256][codeSize]);



