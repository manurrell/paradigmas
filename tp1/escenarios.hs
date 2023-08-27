import City
import Tunel
import Quality
import Point
import Link
import Region
import Control.Exception
import System.IO.Unsafe
-- variables para testear los escenarios
p1= newP 0 0
p2= newP 1 1
p3= newP 2 2
ciudad1= newC "Neuquén" p1
ciudad2= newC "Vaduz" p2
ciudad3= newC "raul" p3
ciudad4=newC "San Martín de los Andes" p3
lowQuality= newQ "baja calidad" 1 1
midQuality= newQ "media calidad" 2 0.7
highQuality= newQ "alta calidad" 5 0.2
link12= newL ciudad1 ciudad2 highQuality
link13= newL ciudad1 ciudad3 highQuality
link23= newL ciudad2 ciudad3 highQuality
link21= newL ciudad2 ciudad1 highQuality
link41=newL ciudad4 ciudad1 highQuality
tunel12= newT [link12]
tunel13= newT [link13]
tunel21= newT [link21]
tunel123= newT  [link12,link23]
a=newR
b= foundR a ciudad2
c= foundR b ciudad1
d=linkR c ciudad1 ciudad2 highQuality
e= foundR d ciudad3
f= linkR e ciudad2 ciudad3 lowQuality
g= tunelR f [ciudad2, ciudad3]
i= foundR g ciudad4

verification_list=[linksL ciudad1 ciudad2 link12,
                    linksL ciudad1 ciudad2 link21,
                    distanceC ciudad1 ciudad2 == difP p1 p2, linkedR d ciudad1 ciudad2,
                    link12/=link21, tunel13/=tunel123,
                    connectsT ciudad1 ciudad2 tunel12 && connectsT ciudad1 ciudad2 tunel21]

---------------------- Error Verifications
testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()
---------------- Error List
regionErrorList=[linkR d ciudad1 ciudad2 highQuality,
                        tunelR d [ciudad1],
                        tunelR g [ciudad1, ciudad3],
                        linkR d ciudad1 ciudad2 midQuality,
                        linkR d ciudad1 ciudad3 highQuality
                        ]
e1 = testF (newT [])
e2 = testF (delayR d ciudad1 ciudad4)
e3 = testF (availableCapacityForR i ciudad3 ciudad4)
listError = (map testF regionErrorList) ++ [e1] ++ [e2] ++ [e3]  -- ejecutar esta variable en consola para ver la lista  de errores
