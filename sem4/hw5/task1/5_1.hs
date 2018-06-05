decomposition :: Int -> [[Int]]
decomposition s = helper s 1 where 
          helper 0 _ = [[]]
          helper s curMax = [x : rest | x <- [curMax..s], rest <- helper (s - x) x]