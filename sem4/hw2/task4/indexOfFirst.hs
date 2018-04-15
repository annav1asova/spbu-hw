firstIndex list a | list' == [] = -1 
                  | otherwise = snd (head list') where 
                    list' = filter (\(x, y) -> x == a) (zip list [0..])
