module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
import City
import Quality
data Link = Lin City City Quality deriving (Eq, Show)
newL :: City -> City -> Quality -> Link                        -- genera un link entre dos ciudades distintas
newL ciudad1 ciudad2 calidad = Lin ciudad1 ciudad2 calidad
connectsL :: City -> Link -> Bool                              -- indica si esta ciudad es parte de este link
connectsL c (Lin c1 c2 q) | c==c1 = True
                                        | c==c2 = True
                                        | otherwise = False
linksL :: City -> City -> Link -> Bool                          -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL c1 c2 (Lin c3 c4 q) | c1 == c2 = False 
                        | ((c1==c3) || (c1==c4)) && ((c2==c3) || (c2==c4)) = True
                        | otherwise = False
capacityL :: Link -> Int   
capacityL(Lin ciudad1 ciudad2 calidad)=capacityQ calidad        
delayL :: Link -> Float                                           -- la demora que sufre una conexion en este canal
delayL(Lin ciudad1 ciudad2 calidad)= (distanceC ciudad1 ciudad2)*(delayQ calidad)           