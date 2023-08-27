module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import Link
import City
data Tunel = Tun [Link] deriving (Eq, Show)
orA :: [Bool] -> Bool
orA a= foldr (||) False a
verifyLinkEntry :: City -> [Link] -> Bool
verifyLinkEntry ciudad (x1:x2:xs) |  connectsL ciudad x1 && not(connectsL ciudad x2) = True | otherwise = False
verifyLinkExit :: City -> [Link] -> Bool
verifyLinkExit ciudad links | connectsL ciudad ((!!) links (length(links)-1)) && not(connectsL ciudad ((!!) links (length(links)-2))) = True | otherwise = False
newT :: [Link] -> Tunel
newT links | length links /= 0 = Tun links
           | otherwise = error "Se requiere un link como mínimo para construir un tunel"
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) | length links == 1 = orA(map (linksL c1 c2) links)
                            | (verifyLinkEntry c1 links && verifyLinkExit c2 links ) || (verifyLinkEntry c2 links && verifyLinkExit c1  links) = True
                            | otherwise = False
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links)= elem link links 
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) =  sum(map delayL links)