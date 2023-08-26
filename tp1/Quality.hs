module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)
newQ :: String -> Int -> Float -> Quality
newQ tipo cap delay= Qua tipo cap delay
capacityQ :: Quality -> Int         -- cuantos tuneles puede soportar esta conexion
capacityQ (Qua tipo cap delay)= cap                 
delayQ :: Quality -> Float          -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua tipo cap delay)= delay                  