#include "avltree.h"
#include <iostream>

using namespace std;

struct TreeNode
{
   int value;
   int height;
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

TreeNode *createNewNode(int value, int height, TreeNode *left, TreeNode *right)
{
    TreeNode *node = new TreeNode;
    node->value = value;
    node->height = height;
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

int height(TreeNode *node)
{
    return node ? node->height : 0;
}

int balanceFactor(TreeNode *node)
{
    return height(node->rightChild) - height(node->leftChild);
}

void updateHeight(TreeNode *node)
{
   int heightLeft = height(node->leftChild);
   int heightRight = height(node->rightChild);
   node->height = max(heightLeft, heightRight) + 1;
}
void rotateRight(TreeNode *&root)
{
   TreeNode* pivot = root->leftChild;
   root->leftChild = pivot->rightChild;
   pivot->rightChild = root;
   updateHeight(root);
   updateHeight(pivot);
   root = pivot;
}

void rotateLeft(TreeNode *&root)
{
   TreeNode* pivot = root->rightChild;
   root->rightChild = pivot->leftChild;
   pivot->leftChild = root;
   updateHeight(root);
   updateHeight(pivot);
   root = pivot;
}

void balance(TreeNode *&node)
{
    updateHeight(node);
    if (balanceFactor(node) == 2)
    {
        if (balanceFactor(node->rightChild) < 0)
             rotateRight(node->rightChild);
        rotateLeft(node);
        return;
    }
    if (balanceFactor(node) == -2)
    {
        if (balanceFactor(node->leftChild) > 0)
            rotateLeft(node->leftChild);
        rotateRight(node);
        return;
    }
}

void add(TreeNode *&node, int value)
{
    if (node == nullptr)
    {
        node = createNewNode(value, 1, nullptr, nullptr);
        return;
    }
    if (node->value == value)
        return;
    if (node->value > value)
        add(node->leftChild, value);
    if (node->value < value)
        add(node->rightChild, value);
    balance(node);
}

void add(Tree *tree, int value)
{
    add(tree->root, value);
}

bool hasNoChildren(TreeNode *node)
{
    if (node->leftChild == nullptr && node->rightChild == nullptr)
        return true;
    else
        return false;
}

bool hasOnlyLeftChild(TreeNode *node)
{
    if (node->leftChild != nullptr && node->rightChild == nullptr)
        return true;
    else
        return false;
}

bool hasOnlyRightChild(TreeNode *node)
{
    if (node->leftChild == nullptr && node->rightChild != nullptr)
        return true;
    else
        return false;
}

bool hasTwoChildren(TreeNode *node)
{
    if (node->leftChild != nullptr && node->rightChild != nullptr)
        return true;
    else
        return false;
}

void remove(TreeNode *&node, int value)
{
    if (node == nullptr)
        return;
    if (value == node->value)
    {
        if (hasNoChildren(node))
        {
            delete node;
            node = nullptr;
            return;
        }
        else if (hasOnlyLeftChild(node))
        {
            TreeNode *toDelete = node;
            node = node->leftChild;
            delete toDelete;
            balance(node);
        }
        else if (hasOnlyRightChild(node))
        {
            TreeNode *toDelete = node;
            node = node->rightChild;
            delete toDelete;
            balance(node);
        }
        else if (hasTwoChildren(node))
        {
            TreeNode *temp = node->rightChild;
            while (temp->leftChild != nullptr)
                temp = temp->leftChild;
            int a = temp->value;
            remove(node, a);
            node->value = a;
            balance(node);
        }
        return;
    }
    if (value > node->value)
    {
        remove(node->rightChild, value);
        balance(node);
    }
    else if (value < node->value)
    {
        remove(node->leftChild, value);
        balance(node);
    }
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


