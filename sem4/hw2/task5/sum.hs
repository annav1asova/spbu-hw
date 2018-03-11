sumThreeLists :: [Integer] -> [Integer] -> [Integer] -> [Integer]
sumThreeLists a b c | a == [] && b == [] && c == [] = []
                    |otherwise = (head' a + head' b + head' c) : sumThreeLists (tail' a) (tail' b) (tail' c) where
                        head' [] = 0
                        head' (x:xs) = x
                        tail' [] = []
                        tail' (x:xs) = xs
