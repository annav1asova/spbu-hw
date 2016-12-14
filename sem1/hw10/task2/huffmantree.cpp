#include "huffmantree.h"
#include <iostream>
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

void add(TreeNode *&node, int value)
{
    if (node == nullptr)
    {
        node = createNewNode(value, nullptr, nullptr);
        return;
    }
    if (node->value == value)
        return;
    if (node->value > value)
        add(node->leftChild, value);
    if (node->value < value)
        add(node->rightChild, value);
}

void add(Tree *tree, int value)
{
    add(tree->root, value);
}

int parse(char string[], int i, TreeNode *&node)
{
    if (string[i] == '(')
    {
        i++;
        if (string[i] == '0')
        {
            node = createNewNode('\0', nullptr, nullptr);
            i = parse(string, i + 2, node->leftChild);
            i = parse(string, i + 2, node->rightChild);
            i++;
        }
        else
        {
            int currentNumber = string[i] - '0';
            i++;
            while (string[i] != ' ')
            {
                currentNumber = currentNumber * 10 + (string[i] - '0');
                i++;
            }
            node = createNewNode(currentNumber, nullptr, nullptr);
            i += 10;
        }
    }
    if (string[i] == ')')
    {
        return i;
    }
    return i;
}

void parseTree(char string[], int i, Tree *tree)
{
    parse(string, i, tree->root);
}

void decoding(Tree *tree, char encodedText[])
{
    ofstream fout;
    fout.open("output.txt");
    TreeNode *node = tree->root;
    int i = 0;
    while (encodedText[i] != '\n')
    {
        if (node->leftChild == nullptr && node->rightChild == nullptr)
        {
            fout << (char)node->value;
            node = tree->root;
        }
        if (encodedText[i] == '0')
            node = node->leftChild;

        else
            node = node->rightChild;
        i++;
    }
    fout << endl;
    fout.close();
}
