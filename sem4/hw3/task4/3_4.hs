correctBracketSeq seq = correctBracketSeq' seq []

correctBracketSeq' (x:xs) brackets | isOpenBracket x = correctBracketSeq' xs (x:brackets)
                                   | isCloseBracket x && brackets == [] = False
                                   | isCloseBracket x && (arePair (head brackets) x) = correctBracketSeq' xs (tail brackets)
                                   | isCloseBracket x = False
                                   | otherwise = correctBracketSeq' xs brackets where 
                                    isOpenBracket s = s == '(' || s == '{' || s == '[' 
                                    isCloseBracket s = s == ')' || s == '}' || s == ']' 
                                    arePair '(' ')' = True
                                    arePair '{' '}' = True
                                    arePair '[' ']' = True
                                    arePair _ _ = False
correctBracketSeq' "" [] = True
correctBracketSeq' "" _ = False
