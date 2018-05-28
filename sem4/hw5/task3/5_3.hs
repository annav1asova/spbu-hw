findElement:: Ord a => [a] -> Maybe a
findElement (x:y:z:list) | y > x && y > z = Just y
                         | otherwise = findElement (y:z:list)                   
findElement _ = Nothing