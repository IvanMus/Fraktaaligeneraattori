Käyttöohje:

Ohjelmaikkuna koostuu kahdesta osasta, jossa vasemmalla on kuva fraktaalista ja oikealla näppäimistö, jolla sitä
manipuloidaan. Kuvaa voi zoomata sisään tai ulos pyörittämällä hiirenrullaa kuvan päällä. Kuvaa voi zoomata sisään tai
ulos vain rajallisen määrän, joten kun zoomaaminen ei näytä toimivan, kyse vain siitä että se on estetty. Kuitenkin
zoomaaminen vastakkaiseen suuntaan onnistuu tällaisessa tapauksessa. Kuvaa voi myös klikata vasemmalla hiirennäppäimellä,
jolloin kuvan keskipiste siirretään klikattuun kohtaan. 

Kuvan manipulointi onnistuu ikkunan oikean puolen näppäimistön kautta. Power-rullasta säädetään kuvan piirtämiseen 
käytettävän iteratiivisen funktion potenssi-parametria. Iteration count taas kertoo kuinka monta funktion iteraatiota
enintään tehdään, millä on vaikutusta kuvan tarkkuuteen (isompi numero tarkoittaa tarkempaa kuvaa). Valikosta, jossa 
ohjelman käynnistyessä lukee Mandelbrot, valitaan iteratiivinen funktio johon perustuen kuva piirretään. Random Colour 
valikosta taas valitaan millä tavalla kuva piirretään. Random Colour valitsemalla värit valitaan sattumanvaraisesti, kun
taas Linear Colour vaihtoehdolla puolestaan käytetään käyttäjän määrittelemää väriskaalaa. Käytettävää väriskaalaa
voi  säätää kuudesta sliderista, jotka sijaitsevat näppäimistön keskivaiheilla. Otsikko ilmoittaa mitä väriparametria 
ollaan säätämässä RGB-värimallista. Kun tarvittavat säädöt on tehty, niin käyttäjä voi klikata Update-napista, jolloin
ohjelma piirtää uuden kuvan käyttäen näppäimistön sen hetkisiä asetuksia. Käyttäjällä on myös mahdollisuus tallentaa 
piirretty kuva (png muodossa) Save Image - napista. Tällöin ohjelma vielä kysyy millä resoluutiolla tallentaminen 
tapahtuu, minkä jälkeen tallennettu kuva ilmestyy työpöydälle.  

Lisähuomio: Iteraatiorajan tai potenssin muuttaminen voi lisätä laskenta-aikaa. Nyrkkisääntönä on että mitä suurempi
potenssi on itseisarvoltaan, niin sitä kauemmin kuvan piirto kestää. Iteraatiorajan laskeminen on varma tapa korjata 
ongelma, tosin kuvatkaan eivät ole tällöin yhtä yksityiskohtaisia. Iteraatiorajalla 100 ohjelma toimii kuitenkin 
huomattavasti nopeammin kuin iteraatiorajalla 1000.