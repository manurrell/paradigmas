
module City ( City, newC, nameC, distanceC )
   where
import Point
data City = Cit String Point deriving (Eq, Show)
newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float
newC name location=  Cit name location
nameC (Cit name location)= name
distanceC (Cit name1 location1) (Cit name2 location2)= difP location1 location2
