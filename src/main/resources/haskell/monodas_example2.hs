import Control.Monad (liftM, ap)

-- Definimos la función sqrtMaybe que calcula la raíz cuadrada y maneja posibles errores.
sqrtMaybe :: (Floating a, Ord a) => a -> Maybe a
sqrtMaybe x
  | x < 0     = Nothing
  | otherwise = Just (sqrt x)

-- Definimos la función minus4Maybe que resta 4 y maneja posibles errores.
minus4Maybe :: (Num a, Ord a) => a -> Maybe a
minus4Maybe x
  | x < 4     = Nothing
  | otherwise = Just (x - 4)

-- Definimos la función reciprocalMaybe que calcula el recíproco y maneja posibles errores.
reciprocalMaybe :: (Fractional a, Eq a) => a -> Maybe a
reciprocalMaybe 0 = Nothing
reciprocalMaybe x = Just (1 / x)

-- Definimos la función plus13Maybe que suma 13.
plus13Maybe :: (Num a) => a -> Maybe a
plus13Maybe x = Just (x + 13)


-- Función que aplica la secuencia de operaciones usando la monada Maybe.
compute :: (Floating a, Ord a, Fractional a, Eq a) => a -> Maybe a
compute x = do
  sqrtResult <- sqrtMaybe (x - 7)
  minusResult <- minus4Maybe sqrtResult
  reciprocalResult <- reciprocalMaybe minusResult
  plus13Result <- plus13Maybe reciprocalResult
  return plus13Result

-- Ejemplo de uso:
main :: IO ()
main = do
  print $ compute 20  -- Ejemplo con x = 20
  print $ compute 5   -- Ejemplo con x = 5 (debería fallar en sqrtMaybe)