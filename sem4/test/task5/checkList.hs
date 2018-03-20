check fun list | list == [] = True
               | otherwise = helper fun list

helper fun (x:xs) | fun x == True = check fun xs 
                | otherwise = False