#include "priorityqueue.h"
#include "tree.h"
#include "huffman.h"
#include <iostream>

using namespace std;

Tree *getTree(int frequencies[])
{
    PriorityQueue *queue = createQueue();
    for (int i = 0; i < 256; i++)
    {
        if (frequencies[i])
        {
            Tree *temp = createTree();
            add(temp, (char)i, frequencies[i]);
            add(queue, temp, frequencies[i]);
        }
    }

    while (size(queue) > 1)
    {
        Tree *first = extractMin(queue);
        Tree *second = extractMin(queue);
        Tree *newTree = createTreeWithKidsTrees(first, second);
        add(queue, newTree, key(newTree));
    }
    Tree *resultTree = extractMin(queue);
    deleteQueue(queue);
    return resultTree;
}

void output(Tree *tree, char **codes)
{
    FILE *fin = fopen("input.txt","r");
    ofstream fout;
    fout.open("output.txt", ios::out);

    printTree(tree, fout);
    fout << endl;
    char string[1000] = {""};
    while(!feof(fin))
    {
        if(fgets(string, 1000, fin))
        {
            int i = 0;
            while (string[i] != '\n')
            {
                fout << codes[(int)string[i]];
                i++;
            }
            fout << codes[(int)('\n')];
        }
    }
    fclose(fin);
    fout.close();
}
