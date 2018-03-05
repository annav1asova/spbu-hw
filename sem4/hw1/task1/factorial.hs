factorial :: Integer -> Integer
factorial x | x == 0 = 1
            | x > 0 = factorial (x - 1) * x