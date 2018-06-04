module Main
    where

import System.IO
import Control.Exception.Base

main = do hSetBuffering stdin LineBuffering
          doLoop []

doLoop:: [(String, Int)] -> IO()
doLoop book = do
    putStrLn "Введите команду для обращения к телефонному справочнику:"
    putStrLn "0 - выйти"
    putStrLn "1 - добавить запись (имя и телефон)"
    putStrLn "2 - найти телефон по имени"
    putStrLn "3 - найти имя по телефону"
    putStrLn "4 - сохранить текущие данные в файл"
    putStrLn "5 - считать данные из файла"
    command <- getLine
    case command of
        '0':_ -> return ()
        '1':_ -> do putStr ("Введите имя: ")
                    name <- getLine
                    putStr ("Введите телефон: ")
                    number <- getLine
                    doLoop $ doAdd book name (read number)
        '2':_ -> do putStr ("Введите имя: ")
                    name <- getLine
                    putStrLn $ show $ findNumber book name
                    doLoop book
        '3':_ -> do putStr ("Введите телефон: ")
                    number <- getLine
                    putStrLn $ show $ findName book (read number)
                    doLoop book 
        '4':_ -> do putStr ("Введите название файла: ")
                    fileName <- getLine
                    doSave book fileName
                    doLoop book
        '5':_ -> do putStr ("Введите название файла: ")
                    fileName <- getLine  
                    content <- readFile fileName
                    doLoop $ decode content
        '6':_->  do print book
                    doLoop book
        _ : _ -> do putStrLn ("Такой команды нет, извините")
                    doLoop book 

doAdd :: [(String, Int)] -> String -> Int -> [(String, Int)]
doAdd [] name number = [(name, number)]
doAdd (x:xs) name number | number <= snd x = (name, number):x:xs
                         | otherwise = x: doAdd xs name number

findNumber :: [(String, Int)] -> String -> Maybe Int
findNumber [] name = Nothing
findNumber (x:xs) name | name == fst x = Just (snd x)
                       | otherwise = findNumber xs name

findName :: [(String, Int)] -> Int -> Maybe String
findName [] number = Nothing
findName (x:xs) number | number == snd x = Just (fst x)
                       | otherwise = findName xs number

doSave :: [(String, Int)] -> String -> IO ()
doSave book fileName = bracket (openFile fileName WriteMode) hClose                                                       
                               (\h -> hPutStrLn h (concatMap (\(name, number) -> name ++ " " ++ show number ++ ['\n']) book)) 

decode:: String -> [(String, Int)]
decode content = map (\[f, s] -> (f, read s :: Int)) $ filter (\x -> x /= []) (map words (lines content))
