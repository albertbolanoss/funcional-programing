import Control.Monad (guard)

-- Definimos la función que calcula la raíz cuadrada, retornando un Maybe
sqrtMaybe :: (Floating a, Ord a) => a -> Maybe a
sqrtMaybe x
    | x < 0     = Nothing
    | otherwise = Just (sqrt x)

-- Definimos la función que calcula el recíproco, retornando un Maybe
reciprocalMaybe :: (Eq a, Fractional a) => a -> Maybe a
reciprocalMaybe 0 = Nothing
reciprocalMaybe y = Just (1 / y)

-- Usamos el operador >>= (bind) para encadenar las computaciones
computation :: (Floating a, Ord a, Eq a) => a -> Maybe a
computation x = do
    y <- sqrtMaybe x
    z <- reciprocalMaybe y
    return z

-- Ejemplo de uso
main :: IO ()
main = do
    print $ computation 4    -- Just 0.5
    print $ computation (-4) -- Nothing
    print $ computation 0    -- Nothing