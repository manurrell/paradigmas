data Hola = Chau String Int deriving Show
newH a b = Chau a b
m=Chau "hoho" 2                         --por que

strongH (Chau a b) = a

sqr x = x*x

data Punto = Poi Int Int deriving Show

