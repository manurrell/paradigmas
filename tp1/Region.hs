

module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where
import City
import Tunel
import Quality
import Point
import Link
data Region = Reg [City] [Link] [Tunel] deriving (Eq,Show) ---------------------------------------------------
newR= Reg [] [] []
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg ciudades links tuneles)  ciudad = Reg ( ciudad : ciudades) links tuneles
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad especificada
linkR (Reg ciudades links tuneles) ciudad1 ciudad2 calidad | orA (map (linksL ciudad1 ciudad2) links) = error "ya existe un link establecido entre las dos ciudades"
                                                            |otherwise= Reg ciudades ((newL ciudad1 ciudad2 calidad):links) tuneles

orA :: [Bool] -> Bool
orA a= foldr (||) False a
andA :: [Bool] -> Bool
andA a= foldr (&&) True a
verifyL :: Region -> [City] -> Bool     --chequear que en una region haya links desde una primera ciudad hasta una ultima con todas sus intermediarias
verifyL (Reg c l t) (x1:(x2:xs)) | xs==[] = orA(map(linksL x1 x2) l) | otherwise = andA(orA(map(linksL x1 x2) l):(verifyL (Reg c l t) (x2:xs)):[])

iflinkreturnlink :: City -> City -> Link -> Link
iflinkreturnlink c1 c2 l | (linksL c1 c2 l) = l | otherwise = error"no linkea"
obtenerlinksordenados :: [Link] -> [City] -> [Link]
obtenerlinksordenados l (x1:(x2:xs)) | xs==[] = [li | li <- l, linksL x1 x2 li]
                                    | otherwise = [li | li <- l, linksL x1 x2 li] ++ (obtenerlinksordenados l (x2:xs))
obtenerlinksordenados _ _ = error "una o mas listas estan vacias"


verifyC:: Region -> City -> Bool
verifyC (Reg c l t) ciudad = elem ciudad c
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas DIRECTAMENTE
linkedR (Reg ciudades links tuneles) ciudad1 ciudad2 = orA(map (linksL ciudad1 ciudad2) links)
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region ciudad1 ciudad2 | (verifyC region ciudad1) && (verifyC region ciudad2) = distanceC ciudad1 ciudad2 | otherwise = error" Las ciudades no pertenecn a esta region"
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg c l t) ciudades | length ciudades==0 = error"ingrese al menos dos ciudades para construir tunel"
                            |not(verifyL (Reg c l t) ciudades) = error "no existe uno o mas de los links necesarios"
                            |not(capCheck (obtenerlinksordenados l ciudades) t) = error "la capacidad disponible de alguno de los links no es suficiente para la construccion"              -- alguno de los links esta capeado
                            |otherwise = Reg c l ((newT (obtenerlinksordenados l ciudades)):t)


countA target = foldr (\each fold -> if target == each then fold + 1 else fold) 0

capCheck :: [Link] -> [Tunel] -> Bool       --chequear si todos los links de la lista tienen capacidad disponible contando sus apariciones en los tuneles provistos
capCheck (x1:[]) t = (countA True (map (usesT x1) t)) < capacityL x1
capCheck (x1:xs) t = andA ((countA True (map (usesT x1) t) < capacityL x1):(capCheck xs t):[])

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel en una region
connectedR (Reg ciudades links tuneles) ciudad1 ciudad2= orA(map(connectsT ciudad1 ciudad2)tuneles)


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades enlazadas DIRECTAMENTE (dijo emilio)
availableCapacityForR (Reg c l t) c1 c2 | verifyL (Reg c l t) [c1, c2] = capacityL(head(obtenerlinksordenados l [c1, c2]))
                                        |otherwise= error "no existe un link entre las dos ciudades"

newLinks :: [City] -> Quality -> [Link]         --crea multiples links que enlacen a las ciudades provistas, desde la primera hasta la ultima, y los devuelve en una lista
newLinks (x1:[]) q= []
newLinks (x1:(x2:xs)) q= (newL x1 x2 q):(newLinks (x2:xs) q)