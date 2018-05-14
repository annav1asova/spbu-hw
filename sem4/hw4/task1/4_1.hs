countEvenNumbers1 = sum . map (\x -> 1 - mod x 2)

countEvenNumbers2  = length . filter even 

countEvenNumbers3 = foldr (\x s -> s + 1 - mod x 2) 0