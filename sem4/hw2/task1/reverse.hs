reverse' list = let
    helper acc [] = acc
    helper acc (x:xs) = helper (x:acc) xs
    in helper [] list