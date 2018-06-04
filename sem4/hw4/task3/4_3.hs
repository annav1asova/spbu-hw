import System.IO
import Data.Foldable

data Tree a = Empty | Leaf a | Node (Tree a) a (Tree a)

instance Foldable Tree where
   foldMap f Empty = mempty
   foldMap f (Leaf x) = f x
   foldMap f (Node l k r) = foldMap f l `mappend` f k `mappend` foldMap f r

printTree:: Tree t -> [t]
printTree = foldMap (\x -> [x])

test = do print (printTree (Node (Node (Leaf 4) 5 (Leaf 3)) 9 (Node (Leaf 1) 7 Empty)))

