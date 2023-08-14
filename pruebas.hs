data Hola = Chau String Int deriving Show
newH a b = Chau a b
m=Chau "hoho" 2                         --por que

strongH (Chau a b) = a


----------------

data Point = Poi Int Int deriving (Eq, Show)
data City = Cit String Point deriving (Eq, Show)
data Quality = Qua String Int Float deriving (Eq, Show)

sqr x = x*x
newP :: Int -> Int -> Point
newP a b=Poi a b
distP :: Point -> Point -> Float
distP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2))+sqr(fromIntegral(y1-y2)))

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float
newC a b=  Cit a b
nameC (Cit a b)= a
distanceC (Cit a b) (Cit c d)= distP b d

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int
delayQ :: Quality -> Float 
newQ a b c= Qua a b c
capacityQ (Qua a b c)= b
delayQ (Qua a b c)= c

a= newP 0 0
b= newP 1 1
lara= newC "neuquen" a
manu= newC "miau" b 
hQ= newQ "alta calidad" 10 0.2

--------------------

data Link = Lin City City Quality deriving (Eq, Show)

connectsL :: City -> Link -> Bool
connectsL c (Lin c1 c2 q) | c==c1 = True | c==c2 = True | otherwise = False

linksL :: City -> City -> Link -> Bool
linksL c1 c2 (Lin c3 c4 q) | c1 == c2 = False 
                           | ((c1==c3) || (c1==c4)) && ((c2==c3) || (c2==c4)) = True
