module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)
newQ :: String -> Int -> Float -> Quality
newQ tipo cap delay= Qua tipo cap delay
capacityQ :: Quality -> Int
capacityQ (Qua tipo cap delay)= cap                 --obtener int capacidad
delayQ :: Quality -> Float
delayQ (Qua tipo cap delay)= delay                  --obtener float delay