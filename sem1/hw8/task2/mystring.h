struct String;

String *createString(char *stringCharacters);
void deleteString(String *string);

String *clone(String *string);
String *concatenation(String *string, String *arg);

bool equals(String *first, String *second);
int length(String *string);
bool isEmpty(String *string);
String *substring(String *string, int from, int to);
char *getChar(String *string);

void print(String *string);
