data Point = Poi Int Int deriving (Eq, Show) ---------------------------------------------------
sqr x = x*x
newP :: Int -> Int -> Point
newP x y=Poi x y
distP :: Point -> Point -> Float
distP (Poi x1 y1) (Poi x2 y2) = sqrt(sqr(fromIntegral(x1-x2))+sqr(fromIntegral(y1-y2)))

data City = Cit String Point deriving (Eq, Show) ---------------------------------------------------
newC :: String -> Point -> City
nameC :: City -> String
distC :: City -> City -> Float
newC name location=  Cit name location
nameC (Cit name location)= name
distC (Cit name1 location1) (Cit name2 location2)= distP location1 location2

data Quality = Qua String Int Float deriving (Eq, Show) ----------------------------------------------------
newQ :: String -> Int -> Float -> Quality
newQ tipo cap delay= Qua tipo cap delay
capacityQ :: Quality -> Int
capacityQ (Qua tipo cap delay)= cap                 --obtener int capacidad
delayQ :: Quality -> Float
delayQ (Qua tipo cap delay)= delay                  --obtener float delay

data Link = Lin City City Quality deriving (Eq, Show) ---------------------------------------------------
newL :: City -> City -> Quality -> Link
newL ciudad1 ciudad2 calidad= Lin ciudad1 ciudad2 calidad
connectsL :: City -> Link -> Bool                               --chequear si una ciudad forma parte de un link
connectsL c (Lin c1 c2 q) | c==c1 = True
                                        | c==c2 = True
                                        | otherwise = False
linksL :: City -> City -> Link -> Bool                          --chequear si dos ciudades estan linkeadas por 1 link
linksL c1 c2 (Lin c3 c4 q) | c1 == c2 = False 
                        | ((c1==c3) || (c1==c4)) && ((c2==c3) || (c2==c4)) = True
                        | otherwise = False
capacityL :: Link -> Int   
capacityL(Lin ciudad1 ciudad2 calidad)=capacityQ calidad        --obtener int capacidad de la calidad asignada al link
delayL :: Link -> Float
delayL(Lin ciudad1 ciudad2 calidad)= (distC ciudad1 ciudad2)/(delayQ calidad)           --obtener float delay de la calidad asignada al link

data Tunel = Tun [Link] deriving (Eq, Show) ---------------------------------------------------
orA :: [Bool] -> Bool
orA a= foldr (||) False a
verifyLinkEntry :: City -> Link -> Bool
verifyLinkEntry ciudad (Lin ciudad1 ciudad2 q) | ciudad1==ciudad = True
                                                                           | otherwise = False 
verifyLinkExit :: City -> Link -> Bool
verifyLinkExit ciudad (Lin ciudad1 ciudad2 q) | ciudad2==ciudad = True | otherwise = False 
newT :: [Link] -> Tunel
newT links= Tun links
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT ciudad1 ciudad2 (Tun links) | (verifyLinkEntry ciudad1 (head links) && verifyLinkExit ciudad2 (last links)) || (verifyLinkEntry ciudad2 (head links) && verifyLinkExit ciudad1 (last links)) = True
                                      | otherwise = False
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese 
usesT link (Tun links)= elem link links 
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) =  sum(map delayL links)


data Region = Reg [City] [Link] [Tunel] deriving (Eq,Show) ---------------------------------------------------
newR= Reg [] [] []
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg ciudades links tuneles)  ciudad = Reg ( ciudad : ciudades) links tuneles
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad 
linkR (Reg ciudades links tuneles) ciudad1 ciudad2 calidad=Reg ciudades ((newL ciudad1 ciudad2 calidad):links) tuneles

andA :: [Bool] -> Bool
andA a= foldr (&&) True a
verifyL :: Region -> [City] -> Bool     --chequear que en una region haya links desde una primera ciudad hasta una ultima con todas sus intermediarias
verifyL (Reg c l t) (x1:(x2:xs)) | xs==[] = orA(map(linksL x1 x2) l) | otherwise = andA(orA(map(linksL x1 x2) l):(verifyL (Reg c l t) (x2:xs)):[])

iflinkreturnlink :: City -> City -> Link -> Maybe a
iflinkreturnlink c1 c2 l | (linksL c1 c2 l) = Just l | otherwise = Nothing
obtenerlinksordenados :: [Link] -> [City] -> [Link]
obtenerlinksordenados l (x1:(x2:xs)) |xs==[]= map(iflinkreturnlink x1 x2) l | otherwise = ((map(iflinkreturnlink x1 x2) l):(obtenerlinksordenados l (x2:xs)):[])

--tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
--tunelR (Reg c l t) ciudades | length ciudades==0 = error"ingrese al menos dos ciudades para construir tunel"
--                            |verifyL (Reg c l t) ciudades = Reg c l ((newT )
-- connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
--linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas directamente
--linkedR (Reg ciudades
-- delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
-- availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades


newLinks :: [City] -> Quality -> [Link]
newLinks (x1:[]) q= []
newLinks (x1:(x2:xs)) q= (newL x1 x2 q):(newLinks (x2:xs) q)

-------------------------------------------------

aa= newP 0 0
bb= newP 1 1
cc= newP 2 2
lara= newC "neuquen" aa
manu= newC "miau" bb
esteban= newC "raul" cc
hQ= newQ "alta calidad" 10 0.2
linkLM= newL lara manu hQ
linkME= newL manu esteban hQ
tunelLM= newT [linkLM]
tunelLME= newT  [linkLM,linkME]
a=newR
b= foundR a manu
c= foundR b lara
d=linkR c lara manu hQ
cities=[]
