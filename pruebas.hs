data Hola = Chau String Int deriving Show
newH a b = Chau a b
m=Chau "hoho" 2

strongH (Chau a b) = a