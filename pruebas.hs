data Hola = Chau String Int deriving Show
newH a b = Chau a b
m=Chau "hoho" 2                         --por que

strongH (Chau a b) = a

sqr x = x*x

data Punto = Poi Int Int deriving Show

distP :: Punto -> Punto -> Float
distP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2))+sqr(fromIntegral(y1-y2)))

