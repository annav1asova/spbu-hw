#pragma once

#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct TreeNode
{
   int value;
   TreeNode *leftChild;
   TreeNode *rightChild;
};

struct Tree
{
    TreeNode *root;
};

Tree *createTree();
void deleteTree(Tree *tree);
void printTree(Tree *tree);
void add(Tree *tree, int value);
void parseTree(char string[], int i, Tree *tree);
