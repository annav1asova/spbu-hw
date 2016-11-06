struct Tree;

Tree *createTree();
void deleteTree(Tree *tree);

void add(Tree *tree, int value);
void remove(Tree *tree, int value);
bool exists(Tree *tree, int value);

void printTree(Tree *tree);
void printAscendingTree(Tree *tree);
void printDescendingTree(Tree *tree);

