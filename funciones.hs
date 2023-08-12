import Point
import City
newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float
newC a b=  Cit a b
nameC (Cit a b)= a
distanceC (Cit a b) (Cit c d)= fncionsupremadelara b d 
newP :: Int -> Int -> Point
newP a b=Poi a b
distP :: Punto -> Punto -> Float
distP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2)+sqr(fromIntegral(y1-y2))))