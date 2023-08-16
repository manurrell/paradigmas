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
distanceC (Cit name1 location1) (Cit name2 location2)= distP location1 location2

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
connectsL c (Lin c1 c2 q) | c==c1 = True | c==c2 = True | otherwise = False
linksL :: City -> City -> Link -> Bool                          --chequear si dos ciudades estan linkeadas por 1 link
linksL c1 c2 (Lin c3 c4 q) | c1 == c2 = False | ((c1==c3) || (c1==c4)) && ((c2==c3) || (c2==c4)) = True
capacityL :: Link -> Int   
capacityL(Lin ciudad1 ciudad2 calidad)=capacityQ calidad        --obtener int capacidad de la calidad asignada al link
delayL :: Link -> Float
delayL(Lin ciudad1 ciudad2 calidad)= delayQ calidad             --obtener float delay de la calidad asignada al link

data Tunel = Tun [Link] deriving (Eq, Show) ---------------------------------------------------
orA :: [Bool] -> Bool
orA a= foldr (||) False a
newT :: [Link] -> Tunel
newT links= Tun links
--connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
--connectsT ciudad1 ciudad2 (Tun links) = if (orA (map (connectsL ciudad1) links)) && (orA (map (connectsL ciudad2) links)) then True else False
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese 
usesT link (Tun links)= elem link links 
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) =  sum(map delayL links)


data Region = Reg [City] [Link] [Tunel] deriving (Show) ---------------------------------------------------
newR= Reg [] [] []
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg ciudades links tuneles)  ciudad = Reg ( ciudad : ciudades) links tuneles
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad 
linkR (Reg ciudades links tuneles) ciudad1 ciudad2 calidad=Reg ciudades ((newL ciudad1 ciudad2 calidad):links) tuneles
-- tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
-- connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg ciudades links tuneles) ciudad1 ciudad2=orA(map (linksL ciudad1 ciudad2) links)
-- delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
-- availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

-------------------------------------------------

a= newP 0 0
b= newP 1 1
c= newP 2 2
lara= newC "neuquen" a
manu= newC "miau" b
esteban= newC "raul" c
hQ= newQ "alta calidad" 10 0.2
linkLM= newL lara manu hQ
a=newR
b= foundR a manu
a= foundR b lara
b=linkR a lara manu