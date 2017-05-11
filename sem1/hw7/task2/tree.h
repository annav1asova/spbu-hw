struct Tree;

Tree *createTree();
void deleteTree(Tree *tree);

void printTree(Tree *tree);
void printAscendingTree(Tree *tree);
int parse(char string[], int i, Tree *tree);
double calculate(Tree *tree);
