data Point = Poi Int Int deriving (Eq, Show)
data City = Cit String Point deriving (Eq, Show)
data Quality = Qua String Int Float deriving (Eq, Show)

sqr x = x*x
newP :: Int -> Int -> Point
newP x y=Poi x y
distP :: Point -> Point -> Float
distP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2))+sqr(fromIntegral(y1-y2)))

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float
newC name location=  Cit name location
nameC (Cit name location)= name
distanceC (Cit name location) (Cit name2 location2)= distP location location2

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int
delayQ :: Quality -> Float 
newQ tipo cap delay= Qua tipo cap delay
capacityQ (Qua tipo cap delay)= cap
delayQ (Qua tipo cap delay)= delay

a= newP 0 0
b= newP 1 1
lara= newC "neuquen" a
manu= newC "miau" b 
hQ= newQ "alta calidad" 10 0.2