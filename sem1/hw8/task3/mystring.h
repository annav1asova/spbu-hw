#pragma once

struct String;

String *createString(const char *stringCharacters);
void deleteString(String *string);

String *clone(String *string);

bool equals(String *first, String *second);
int length(String *string);
bool isEmpty(String *string);
char *getChar(String *string);

void print(String *string);
