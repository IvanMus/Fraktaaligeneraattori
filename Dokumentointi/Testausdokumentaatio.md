Testausdokumentaatio:

Paketit jotka testattu ovat Kompleksiluku, Iteraattorit, Varit ja Fraktaalinpiirturi. Nämä muodostavat ohjelman ytimen,
jonka kautta frakaalin piirtäminen tapahtuu. Fraktaalipiirturin testaus jäi hieman puutteelliseksi, joko sen takia
että metodi on private tai että metodi muuttaa jollakin tavoin private oliomuuttujaa. Muiden pakettien toiminnallisuus
on käyttöliittymässä, joita olen yrittänyt testata käsin ohjelmaa käyttämällä (esimerkiksi syöttämällä JSpinneriin 
numeron sijaan String parametrin).

Mahdollinen bugi: Käyttäjän zoomatessa kuvaa, ohjelma alkaa laskemaan sitä. Mikäli lasku on vielä kesken ja käyttäjä
                  yrittää lisätä zoomia, saatta syntyä vaikutelma että ohjelma on jumittunut. Todellisuudessa ohjelma
                  vain laskee niin monta kuvaa kuin on tapahtunut zoomaamisia. Zoomaaminen välittyy MouseWheelEventin
                  kautta, ja ongelma näyttää johtuvan siitä, että jokaisen kuvan piirtämisen jälkeen tapahtuu seuraavan
                  Eventin käsittely. Olen yrittänyt ratkaista ongelman yrittämällä selvittää josko jokaisen laskennan
                  jälkeen "säiliö", missä näitä Eventejä säilytetään olisi mahdollista tyhjentää. Tämä ei ole tuottanut
                  tulosta, ja  muut raktaisuyritykset eivät ole joko toimineet tai ovat aiheuttaneet muita ongelmia.
                   