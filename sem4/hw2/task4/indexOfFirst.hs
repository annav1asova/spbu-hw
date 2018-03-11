firstIndex (x:xs) a | x == a = 0
                    | xs == [] = -1
                    | otherwise = if index >= 0 then (1 + index) else -1 where 
                        index = firstIndex xs a