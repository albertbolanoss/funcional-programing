{-# LANGUAGE NoImplicitPrelude #-}

import Prelude hiding (Maybe(..))

-- Definimos el tipo de datos Maybe
data Maybe a = Nothing | Just a deriving (Show)

-- Función que calcula la raíz cuadrada de un número si es no negativo
sqrtMaybe :: Float -> Maybe Float
sqrtMaybe x 
    | x < 0     = Nothing
    | otherwise = Just (sqrt x)

-- Función que calcula el recíproco de un número si no es cero
reciprocalMaybe :: Float -> Maybe Float
reciprocalMaybe y 
    | y == 0    = Nothing
    | otherwise = Just (1 / y)

-- Definimos la función bind (>>=) para el tipo Maybe
bind :: Maybe a -> (a -> Maybe b) -> Maybe b
bind Nothing _  = Nothing
bind (Just x) f = f x

-- Ejemplo de uso
main :: IO ()
main = do
    let x = 0.0
    let result = sqrtMaybe x `bind` reciprocalMaybe
    print result
