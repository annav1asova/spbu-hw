import Control.Monad

findElement:: Ord a => [a] -> Maybe a
findElement (x:y:z:list) = mplus (if y > x && y > z then Just y else Nothing) $ findElement (y:z:list)                   
findElement _ = Nothing