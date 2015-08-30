Rakennekuvaus:

Ohjelman logiikan rungon muodostavat Fraktaalipiirturi, Varit, Kompleksiluku ja Iteraattorit. Fraktaalin piirtäminen
tapahtuu Fraktaalipiirturissa. Jokainen väritettävä pikseli edustaa jotakin Kompleksilukua, jota Iteraattorit 
käsittelevät, ja ilmoittavat Fraktaalinpiirturille monennellako värillä pikseli väritetään. Varit pitävät sisällään
väritaulukon, josta värit poimitaan, ja jossa ne myös alustetaan. FraktaalinPiirtoalusta ottaa piirretyn kuvan vastaan
Fraktaalinpiirturilta, josta se sitten esitetään. Se myös toimii siltana ohjelmalogiikkaan, jonka kautta muutokset
välitetään eteenpäin (esim. potenssin tai iteraatiorajan muuttaminen). FraktaalinPiirtoalustaan on yhteydessä Listenerit-
FraktaalinPiirtoalustalle, jota kautta tarkkaillaan zoomaamista ja klikkailua FraktaalinPiirtoalustassa (joka siis 
esitetään käyttäjälle JPanelina). FraktaalinPiirtoalusta ja Nappaimisto muodostavat yhdessä käyttöliittymän, jonka osaset
kootaan GraafisessaKayttoliittymassa. Nappaimistoon on yhteydessä ListeneritNappaimistolle, niin että jokaisen
Nappaiston osasessa on oma Listeneri. Kun Nappaimistoa käytetään, tieto välittyy Listenerien kautta FraktaalinPiirto-
alustalle käsiteltäväksi. Kun esimerkiksi käyttäjä haluaa tallentaa piirretyn kuvan, vastaava näppäimen painallus
välitty Listeneristä FraktaalinPiirtoalustalle, joka luo Kuvantallentajan ja siirtää vastuun kuvan tallentamisesta
sille. Kuvantallentaja pyytää tallennettavan kuvan Fraktaalinpiirturilta.	