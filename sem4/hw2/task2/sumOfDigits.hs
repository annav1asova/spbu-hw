digitSum :: Integer -> Integer
digitSum n = let
    helper sum 0 = sum
    helper sum n = helper (sum + mod n 10) (div n 10)
    in helper 0 (abs n)