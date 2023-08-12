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
