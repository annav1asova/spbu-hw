#include "huffmantree.h"
#include "decode.h"

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
