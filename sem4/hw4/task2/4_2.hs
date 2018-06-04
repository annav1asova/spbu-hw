module Main
    where

import System.IO
import Control.Exception.Base

main = do hSetBuffering stdin LineBuffering
          doLoop []
doLoop list = do
    putStrLn "Enter a command 1 to add element, 2 to remove, 3 to print list or 0 to quit:"
    command <- getLine
    case command of
        '0':_ -> return ()
        '1':_ -> do putStr ("Элемент для добавления: ")
                    element <- getLine
                    doLoop (doAdd list $ read element)
        '2':_ -> do putStr ("Элемент для удаления: ")
                    element <- getLine
                    doLoop (doRemove list $ read element)
        '3':_  -> do putStr ("Список: ")
                     print list    
                     doLoop list       
        _: _  -> do  putStrLn ("Такой команды нет, извините")
                     doLoop list   

doAdd:: [Int] -> Int -> [Int]
doAdd [] element = [element]
doAdd (x:xs) element | element <= x = element:x:xs
                     | otherwise = x: doAdd xs element

doRemove:: [Int] -> Int -> [Int]
doRemove [] element = []
doRemove (x:xs) element | element == x = xs
                        | otherwise = x: doRemove xs element