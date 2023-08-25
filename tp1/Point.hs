module Point ( Point, newP, difP)
   where
data Point = Poi Int Int deriving (Eq, Show) ---------------------------------------------------
sqr x = x*x
newP :: Int -> Int -> Point
newP x y=Poi x y
difP :: Point -> Point -> Float
difP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2))+sqr(fromIntegral(y1-y2)))
