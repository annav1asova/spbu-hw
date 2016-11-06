struct ListElement;

struct List;

List* createList();
void deleteList(List *list);

ListElement *createNewElement(long long value, char name[], ListElement *next);

void add(List *list, long long value, char name[]);

long long findValue(List *list, char name[]);
char *findName(List *list, long long value);

bool isEmpty(List *list);
int size(List *list);
void showList(List *list);
void saveList(List *list);

bool areNamesEqual(char firstArray[], char secondArray[]);
void fillName(char firstArray[], char secondArray[]);

