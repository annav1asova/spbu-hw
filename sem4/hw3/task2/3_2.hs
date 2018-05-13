seqAr = [[1], [7], [9]] ++ concatMap (\n -> [n ++ [1], n ++ [7], n ++ [9]]) seqAr
list179 = map (\n -> foldl (\x y -> x * 10 + y) 0 n) seqAr
