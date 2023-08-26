module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import Link
import City
data Tunel = Tun [Link] deriving (Eq, Show)
orA :: [Bool] -> Bool
orA a= foldr (||) False a
verifyLinkEntry :: City -> [Link] -> Bool
verifyLinkEntry ciudad (x1:x2:xs) | connectsL ciudad x1 && not(connectsL ciudad x2) = True | otherwise = False
verifyLinkExit :: City -> [Link] -> Bool
verifyLinkExit ciudad links | connectsL ciudad ((!!) links (length(links)-1)) && not(connectsL ciudad ((!!) links (length(links)-2))) = True | otherwise = False
newT :: [Link] -> Tunel
newT links= Tun links
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT ciudad1 ciudad2 (Tun links) | (verifyLinkEntry ciudad1 links && verifyLinkExit ciudad2 links ) || (verifyLinkEntry ciudad2 links && verifyLinkExit ciudad1  links) = True
                                      | otherwise = False
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links)= elem link links 
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) =  sum(map delayL links)