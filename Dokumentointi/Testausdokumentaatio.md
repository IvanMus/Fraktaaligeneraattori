Testausdokumentaatio:

Paketit jotka testattu ovat Kompleksiluku, Iteraattorit, Varit ja Fraktaalinpiirturi. N�m� muodostavat ohjelman ytimen,
jonka kautta frakaalin piirt�minen tapahtuu. Fraktaalipiirturin testaus j�i hieman puutteelliseksi, joko sen takia
ett� metodi on private tai ett� metodi muuttaa jollakin tavoin private oliomuuttujaa. Muiden pakettien toiminnallisuus
on k�ytt�liittym�ss�, joita olen yritt�nyt testata k�sin ohjelmaa k�ytt�m�ll� (esimerkiksi sy�tt�m�ll� JSpinneriin 
numeron sijaan String parametrin).

Mahdollinen bugi: K�ytt�j�n zoomatessa kuvaa, ohjelma alkaa laskemaan sit�. Mik�li lasku on viel� kesken ja k�ytt�j�
                  yritt�� lis�t� zoomia, saatta synty� vaikutelma ett� ohjelma on jumittunut. Todellisuudessa ohjelma
                  vain laskee niin monta kuvaa kuin on tapahtunut zoomaamisia. Zoomaaminen v�littyy MouseWheelEventin
                  kautta, ja ongelma n�ytt�� johtuvan siit�, ett� jokaisen kuvan piirt�misen j�lkeen tapahtuu seuraavan
                  Eventin k�sittely. Olen yritt�nyt ratkaista ongelman yritt�m�ll� selvitt�� josko jokaisen laskennan
                  j�lkeen "s�ili�", miss� n�it� Eventej� s�ilytet��n olisi mahdollista tyhjent��. T�m� ei ole tuottanut
                  tulosta, ja  muut raktaisuyritykset eiv�t ole joko toimineet tai ovat aiheuttaneet muita ongelmia.
                   