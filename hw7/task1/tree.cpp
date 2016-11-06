#include "tree.h"
#include <iostream>

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

void printAscendingTree(TreeNode *node)
{
    if (node == nullptr)
        return;

    printAscendingTree(node->leftChild);
    cout << node->value << " ";
    printAscendingTree(node->rightChild);
}

void printAscendingTree(Tree *tree)
{
    printAscendingTree(tree->root);
}

void printDescendingTree(TreeNode *node)
{
    if (node == nullptr)
        return;

    printDescendingTree(node->rightChild);
    cout << node->value << " ";
    printDescendingTree(node->leftChild);
}

void printDescendingTree(Tree *tree)
{
    printDescendingTree(tree->root);
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

bool hasNoChildren(TreeNode *node)
{
    return (node->leftChild == nullptr && node->rightChild == nullptr);
}

bool hasOnlyLeftChild(TreeNode *node)
{
    return (node->leftChild != nullptr && node->rightChild == nullptr);
}

bool hasOnlyRightChild(TreeNode *node)
{
    return (node->leftChild == nullptr && node->rightChild != nullptr);
}

bool hasTwoChildren(TreeNode *node)
{
    return (node->leftChild != nullptr && node->rightChild != nullptr);
}

bool remove(TreeNode *&node, int value)
{
    if (node == nullptr)
        return false;
    if (value == node->value)
    {
        if (hasNoChildren(node))
        {
            delete node;
            node = nullptr;
        }
        else if (hasOnlyLeftChild(node))
        {
            TreeNode *toDelete = node;
            node = node->leftChild;
            delete toDelete;
        }
        else if (hasOnlyRightChild(node))
        {
            TreeNode *toDelete = node;
            node = node->rightChild;
            delete toDelete;
        }
        else if (hasTwoChildren(node))
        {
            TreeNode *temp = node->rightChild;
            while (temp->leftChild != nullptr)
                temp = temp->leftChild;
            int a = temp->value;
            remove(node, a);
            node->value = a;
           // delete temp;
        }
        return true;
    }
    if (value > node->value)
        return remove(node->rightChild, value);
    if (value < node->value)
        return remove(node->leftChild, value);
}

void remove(Tree *tree, int value)
{
    remove(tree->root, value);
}

bool exists(TreeNode *node, int value)
{
    if (node == nullptr)
        return false;
    if (value == node->value)
        return true;
    if (value > node->value)
        return exists(node->rightChild, value);
    if (value < node->value)
        return exists(node->leftChild, value);
}

bool exists(Tree *tree, int value)
{
    return exists(tree->root, value);
}


