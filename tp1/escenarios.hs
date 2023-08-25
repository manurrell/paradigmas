import City
import Tunel
import Quality
import Point
import Link
import Region

-- variables para testear los escenarios
punto1= newP 0 0
punto2= newP 1 1
punto3= newP 2 2
ciudad1= newC "neuquen" punto1
ciudad2= newC "miau" punto2
ciudad3= newC "raul" punto3
sanma=newC "sanma" punto3
lowQuality= newQ "baja calidad" 1 1
midQuality= newQ "media calidad" 2 0.7
highQuality= newQ "alta calidad" 5 0.2
link12= newL ciudad1 ciudad2 highQuality
link23= newL ciudad2 ciudad3 highQuality
link21= newL ciudad2 ciudad1 highQuality
link41=newL sanma ciudad1 highQuality
tunel12= newT [link12]
tunel21= newT [link21]
tunel123= newT  [link12,link23]
a=newR
b= foundR a ciudad2
c= foundR b ciudad1
d=linkR c ciudad1 ciudad2 highQuality

verification_list=[linksL ciudad1 ciudad2 link12, linksL ciudad1 ciudad2 link21, distanceC ciudad1 ciudad2 == difP punto1 punto2]