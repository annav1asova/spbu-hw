supermap [] f= []
supermap (x:xs) f = f x ++ supermap xs f