maxSumInd list = maxSumInd' list 1 0 0

maxSumInd' [x] _ _ indexOfMax = indexOfMax
maxSumInd' (x:y:xs) curIndex curMax indexOfMax | (x + y > curMax) = maxSumInd' (y : xs) (curIndex + 1) (x + y) curIndex
                                               | otherwise = maxSumInd' (y : xs) (curIndex + 1) curMax indexOfMax