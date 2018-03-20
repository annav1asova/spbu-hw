up i n = replicate (n - i) ' ' ++ replicate (2 * i + 1) 'x' ++ ['\n']
down i n = replicate (i) ' ' ++ replicate (2 * (n - i) + 1) 'x' ++ ['\n']
rhomb n = concatMap (\x -> up x n) [0..n - 1] ++ concatMap (\x -> down x n) [0..n]

main = putStrLn (rhomb 4)

-- у меня немного другое видение ромба просто :)