# ParametrRESTapp

### Mateusz Rodak, 04.12.2021
* [github -> MateuszRodak](https://github.com/MateuszRodak)
* [linkedIN -> MateuszRodak](https://www.linkedin.com/in/mateusz-rodak-912a55112/)

\
<> Zastosowany format daty w projekcie: "yyyy-MM-ddTHH:mm:ss"

<> Zastosowana baza danych: H2
* http://localhost:8080/h2-console/

<> W pliku skrypty.sql znajdują się kwerendy  zastosowane przy tworzeniu tabel w bazie danych.


### Mappingi wraz z przykładami zastosowania:


		/////PARAMETR

@GetMapping("/getParameters")
* http://localhost:8080/getParameters

@GetMapping("addParameters/{name}/{description}")
* http://localhost:8080/addParameters/name1/description1

@GetMapping("editParameters/{id}/{name}/{description}")
* http://localhost:8080/editParameters/2/newName/newDescription

@GetMapping("deleteParameters/{id}")
* http://localhost:8080/deleteParameters/2


		/////WARTOSC PARAMETRU OGOLNA

@GetMapping("/getWartosciParametru/{parametrID}")
* http://localhost:8080/getWartosciParametru/3

@GetMapping("/getWartosciParametru/{parametrID}/{dataOd}/{dataDo}")
* http://localhost:8080/getWartosciParametru/1/2020-09-06T07:12:52/2021-12-06T07:12:52
 
@GetMapping("/deleteWartoscParametru/{id}")
* http://localhost:8080/deleteWartoscParametru/1


		/////WARTOSC PARAMETRU LICZBOWA

@GetMapping("/addLiczbowaWartoscParametru/{parametrID}/{dataOd}/{dataDo}/{wartoscLiczbowa}/{jednostka}")
* http://localhost:8080/addLiczbowaWartoscParametru/2/2020-09-06T07:12:52/2021-10-07T05:11:51/45/kg

@GetMapping("/editLiczbowaWartoscParametru/{id}/{wartoscLiczbowa}/{jednostka}")
* http://localhost:8080/editLiczbowaWartoscParametru/1/34/m3

@GetMapping("/editLiczbowaWartoscParametru/{id}/{parametrId}/{dataOd}/{dataDo}/{wartoscLiczbowa}/{jednostka}")
* http://localhost:8080/editLiczbowaWartoscParametru/1/3/2012-09-06T07:12:52/2013-09-06T07:12:52/52/kg



		/////WARTOSC PARAMETRU OPISOWA

@GetMapping("/addOpisowaWartoscParametru/{parametrID}/{dataOd}/{dataDo}/{wartoscOpisowa}")
* http://localhost:8080/addOpisowaWartoscParametru/3/2020-09-06T07:12:52/2021-10-07T05:11:51/Stabilnie

@GetMapping("/editOpisowaWartoscParametru/{id}/{wartoscOpisowa}")
* http://localhost:8080/editOpisowaWartoscParametru/3/siedemnascie

@GetMapping("/editOpisowaWartoscParametru/{id}/{parametrID}/{dataOd}/{dataDo}/{wartoscOpisowa}")
* http://localhost:8080/editOpisowaWartoscParametru/1/3/2012-09-06T07:12:52/2013-09-06T07:12:52/DataZmieniona
