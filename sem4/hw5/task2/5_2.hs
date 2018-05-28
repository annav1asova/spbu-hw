products n =  [1..n] >>= \i -> [1..n] >>= \j -> return (i * j)
