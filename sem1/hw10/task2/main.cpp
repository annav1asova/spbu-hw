#include <iostream>
#include "huffmantree.h"
#include "decode.h"

using namespace std;

int main()
{
    FILE *fp = fopen("input.txt","r");
    char treeString[10000] = {""};
    char encodedText[100000] = {""};
    if(!fp)
    {
        cout << "File doesn't exist :(";
    }
    else{
        fgets(treeString, 10000, fp);
        fgets(encodedText, 100000, fp);

        Tree *tree = createTree();
        parseTree(treeString, 0, tree);
        decoding(tree, encodedText);
        deleteTree(tree);
        fclose(fp);
    }
}
