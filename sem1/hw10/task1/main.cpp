#include <iostream>
#include <fstream>
#include "priorityqueue.h"
#include "tree.h"
#include "huffman.h"

using namespace std;

int main()
{
    int frequencies[256] = {0};
    FILE *fp = fopen("input.txt","r");
    char string[1000] = {""};
    if(!fp)
    {
        cout << "File doesn't exist :(";
    }
    else{
        while(!feof(fp))
        {
            if(fgets(string, 1000, fp))
            {
                int i = 0;
                while (string[i] != '\n')
                {
                    frequencies[(unsigned char)string[i]]++;
                    i++;
                }
                frequencies[(int)'\n']++;
            }
        }

        cout << string;
        Tree *tree = getTree(frequencies);
        char **codes = getCodes(tree);
        output(tree, codes);

        deleteTree(tree);
        fclose(fp);
    }
}
