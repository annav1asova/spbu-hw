#include "tree.h"
#include <iostream>

using namespace std;

struct TreeNode
{
   char value;
   TreeNode *leftChild;
   TreeNode *rightChild;
};

struct Tree
{
    TreeNode *root;
};

Tree *createTree()
{
    Tree *tree = new Tree;
    tree->root = nullptr;
    return tree;
}

TreeNode *createNewNode(int value, TreeNode *left, TreeNode *right)
{
    TreeNode *node = new TreeNode;
    node->value = value;
    node->leftChild = left;
    node->rightChild = right;
    return node;
}

void deleteTree(TreeNode *node)
{
    if (node == nullptr)
        return;

     deleteTree(node->leftChild);
     deleteTree(node->rightChild);
     delete node;
}

void deleteTree(Tree *tree)
{
    deleteTree(tree->root);
    delete tree;
}

void printAscendingTree(TreeNode *node)
{
    if (node == nullptr)
        return;

    if (node->leftChild && node->rightChild)
    {
        cout << '(';
        printAscendingTree(node->leftChild);
        cout << " " << node->value << " ";
        printAscendingTree(node->rightChild);
        cout << ')';
    }
    else
        cout << node->value;
}

void printAscendingTree(Tree *tree)
{
    printAscendingTree(tree->root);
}

void printTree(TreeNode *node)
{
    if (node == nullptr)
    {
        cout << " null";
        return;
    }

    cout << " (";
    cout << node->value;
    printTree(node->leftChild);
    printTree(node->rightChild);
    cout << ")";
}

void printTree(Tree *tree)
{
    printTree(tree->root);
}


int parse(char string[], int i, TreeNode *&node)
{
    if (string[i] == '(')
    {
        i++;
        node = createNewNode(string[i], nullptr, nullptr);
        i = parse(string, i + 2, node->leftChild);
        i = parse(string, i + 2, node->rightChild);
        i++;
    }
    if (string[i] == ')')
    {
        return i;
    }
    if (string[i] >= '0' && string[i] <= '9')
    {
       node = createNewNode(string[i], nullptr, nullptr);
    }
    return i;
}

int parse(char string[], int i, Tree *tree)
{
    parse(string, i, tree->root);
}

double calculate(TreeNode *node)
{
    if (node->value == '+')
        return calculate(node->leftChild) + calculate(node->rightChild);
    if (node->value == '-')
        return calculate(node->leftChild) - calculate(node->rightChild);
    if (node->value == '*')
        return calculate(node->leftChild) * calculate(node->rightChild);
    if (node->value == '/')
        return calculate(node->leftChild) / calculate(node->rightChild);
    else
        return node->value - '0';
}

double calculate(Tree *tree)
{
    return calculate(tree->root);
}

