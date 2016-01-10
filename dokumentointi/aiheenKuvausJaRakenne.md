####Lukulistan kuvaus ja rakenne
#####Lyhyt aihemäärittely

**Aihe:** Lukulistaan voi lisätä jo luettuja, kesken olevia tai backlogiin kirjoja/sarjakuvia yms. jos lukeminen on suunnitteilla. Lisättyjä teoksia voi muokata, arvostella ja muuttaa niiden kategoriaa. Listalta voi etsiä, sitä voi järjestää ja filtteröidä eri perustein. Ohjelma osaa tallentaa lisätyn sisällön ja ladata sen myöhemmin. Myöhemmin voi laajentaa ohjelmaa peleihin, elokuviin tai muuhun. Olisi kiva jos ohjelma osaisi etsiä ja näyttää kansikuvan ja muita tietoja nimen perusteella jonkin sivun APIn kautta.

**Käyttäjät:** Peruskäyttäjä

**Toiminnot:** 
* Uuden teoksen lisäys
* Teoksen tietojen päivitys/poisto
* Kategorian vaihto
* Teoksen arvostelu
* Teosten listaus
* Listan järjestäminen eri kriteerien mukaan
* Listan filtteröinti eri kriteerien mukaan
* Haku listasta
* Listan tallennus tietokoneelle
* Listan lataus tietokoneelta

#####Rakennekuvaus

Ohjelma rakentuu kolmesta eri osasta: käyttöliittymästä, logiikasta ja määrittelyalueen käsitteistä. Ylimpänä on käyttäjälle näkyvä käyttöliittymä. Käyttöliittymää hallinnoi Graafinenkayttoliittyma-luokka, joka luo ja järjestää tarvittavat komponentit. Se tietää myös ohjainolion, jonka kautta se vie eteenpäin käyttäjän käskyt toteutettavaksi. Komponentteja ovat erilaiset Swing-komponentit  (tai niitä laajentavat omat luokat) jotka muodostavat ulkoisen näkymän sekä erilaiset kuuntelija-luokat jotka käsittelevät käyttöliittymän tapahtumia.

Logiikkaa hallinnoi Ohjain-rajapinnan toteuttava DefaultOhjain. Ohjain tarjoaa käyttöliittymälle metodit, joita se tarvitsee. Ohjain luo ja hallinnoi käsitteitä kuvaavia luokkia kuten Teos, Tekija jne. Ohjaimella on käytössään myös Hakukone- ja Muistio-luokat, jotka hoitavat listalta hakemisen ja sen tallentamisen ja lataamisen. Sillä on myös erilaisia Comparator-rajapinnan toteuttavia luokkia, joiden avulla se voi järjestää listan halutuilla tavoilla.

Määrittelyalueen käsite-luokat kuvaavat teoksia ja niiden attribuutteja. Ne eivät itsessään sisällä equals-metodia ihmeellisempää toimintaa, vaan niiden päätarkoitus on säilyttää niihin liittyvää dataa ja tarjota näitä tietoja ylempien kerrosten niitä tarvittaessa.