Rakennekuvaus:

Ohjelman logiikan rungon muodostavat Fraktaalipiirturi, Varit, Kompleksiluku ja Iteraattorit. Fraktaalin piirt�minen
tapahtuu Fraktaalipiirturissa. Jokainen v�ritett�v� pikseli edustaa jotakin Kompleksilukua, jota Iteraattorit 
k�sittelev�t, ja ilmoittavat Fraktaalinpiirturille monennellako v�rill� pikseli v�ritet��n. Varit pit�v�t sis�ll��n
v�ritaulukon, josta v�rit poimitaan, ja jossa ne my�s alustetaan. FraktaalinPiirtoalusta ottaa piirretyn kuvan vastaan
Fraktaalinpiirturilta, josta se sitten esitet��n. Se my�s toimii siltana ohjelmalogiikkaan, jonka kautta muutokset
v�litet��n eteenp�in (esim. potenssin tai iteraatiorajan muuttaminen). FraktaalinPiirtoalustaan on yhteydess� Listenerit-
FraktaalinPiirtoalustalle, jota kautta tarkkaillaan zoomaamista ja klikkailua FraktaalinPiirtoalustassa (joka siis 
esitet��n k�ytt�j�lle JPanelina). FraktaalinPiirtoalusta ja Nappaimisto muodostavat yhdess� k�ytt�liittym�n, jonka osaset
kootaan GraafisessaKayttoliittymassa. Nappaimistoon on yhteydess� ListeneritNappaimistolle, niin ett� jokaisen
Nappaiston osasessa on oma Listeneri. Kun Nappaimistoa k�ytet��n, tieto v�littyy Listenerien kautta FraktaalinPiirto-
alustalle k�sitelt�v�ksi. Kun esimerkiksi k�ytt�j� haluaa tallentaa piirretyn kuvan, vastaava n�pp�imen painallus
v�litty Listenerist� FraktaalinPiirtoalustalle, joka luo Kuvantallentajan ja siirt�� vastuun kuvan tallentamisesta
sille. Kuvantallentaja pyyt�� tallennettavan kuvan Fraktaalinpiirturilta.	