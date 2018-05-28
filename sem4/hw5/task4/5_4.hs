data Expr = Variable | Number Int | Multiply Expr Expr | Divide Expr Expr | Add Expr Expr | Subtract Expr Expr | UnaryMinus Expr

derivative:: Expr -> Expr
derivative (Number a) = Number 0
derivative Variable = Number 1
derivative (Multiply f g) = Add (Multiply (derivative f) g) (Multiply f (derivative g))
derivative (Divide f g) = Subtract (Divide (derivative f) g) (Divide (Multiply f (derivative g)) (Multiply g g))
derivative (Add f g) = Add (derivative f) (derivative g)
derivative (Subtract f g) = Subtract (derivative f) (derivative g)
derivative (UnaryMinus f) = UnaryMinus (derivative f)

makeSimple:: Expr -> Expr
--свойства сложения
makeSimple (Add (Number 0) f) = makeSimple f
makeSimple (Add f (Number 0)) = makeSimple f
makeSimple (Subtract (Number 0) f) = UnaryMinus (makeSimple f)
makeSimple (Subtract f (Number 0)) = makeSimple f
--свойства умножения
makeSimple (Multiply (Number 0) f) = Number 0 
makeSimple (Multiply f (Number 0)) = Number 0 
makeSimple (Divide (Number 0) f) = Number 0 
makeSimple (Multiply (Number 1) f) = makeSimple f
makeSimple (Multiply f (Number 1)) = makeSimple f
makeSimple (Divide f (Number 1)) = makeSimple f  
--операции с двумя числами
makeSimple (Multiply (Number x) (Number y)) = Number (x * y)
makeSimple (Divide (Number x) (Number y)) = Number (x `div` y)
makeSimple (Add (Number x) (Number y)) = Number (x + y)
makeSimple (Subtract (Number x) (Number y)) = Number (x - y)

makeSimple (UnaryMinus (UnaryMinus f)) = makeSimple f
makeSimple f = f

makeSimpleE (UnaryMinus f) = makeSimple $ UnaryMinus (makeSimpleE f)
makeSimpleE (Multiply f g) = makeSimple $ Multiply (makeSimpleE f) (makeSimpleE g)
makeSimpleE (Divide f g) = makeSimple $ Divide (makeSimpleE f) (makeSimpleE g) 
makeSimpleE (Add f g) = makeSimple $ Add (makeSimpleE f) (makeSimpleE g) 
makeSimpleE (Subtract f g) = makeSimple $ Subtract (makeSimpleE f) (makeSimpleE g) 
makeSimpleE f = f

instance Show Expr where
    show Variable = "x"
    show (Number a) = show a
    show (Multiply f g) = "(" ++ (show f) ++ " * " ++ (show g) ++ ")"
    show (Divide f g) = "(" ++ (show f) ++ " / " ++ (show g) ++ ")"
    show (Add f g) = "(" ++ (show f) ++ " + " ++ (show g) ++ ")"
    show (Subtract f g) = "(" ++ (show f) ++ " - " ++ (show g) ++ ")"
    show (UnaryMinus f) = "(-" ++ (show f) ++ ")"

test = makeSimpleE $ derivative $ Add (Multiply (Number 3) (Multiply Variable Variable)) (Multiply (Number 5) Variable)