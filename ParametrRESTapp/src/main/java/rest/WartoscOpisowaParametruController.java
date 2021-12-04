package atmoterm.zadanie.rekrutacyjne.rest;


import atmoterm.zadanie.rekrutacyjne.entity.WartoscOpisowaParametru;
import atmoterm.zadanie.rekrutacyjne.entity.WartoscParametru;
import atmoterm.zadanie.rekrutacyjne.repository.WartoscOpisowaParametruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Author: Mateusz Rodak
 */

@RestController
public class WartoscOpisowaParametruController extends WartoscParametru {



    @Autowired
    private WartoscOpisowaParametruRepository wartoscOpisowaParametruRepository;


    @GetMapping("/addOpisowaWartoscParametru/{parametrId}/{dataOd}/{dataDo}/{wartoscOpisowa}")
    public String addOpisowaWartoscParametru(@PathVariable Long parametrId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataOd, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataDo, @PathVariable String wartoscOpisowa){

        List<WartoscOpisowaParametru> czyJestJuzWpis = wartoscOpisowaParametruRepository.czyJestJuzWpis(parametrId, dataOd , dataDo);

        if (czyJestJuzWpis.size() > 0) {

            return "Wartość opisowa w tym przedziale czasowym już istnieje!";
        }

        WartoscOpisowaParametru wartoscOpisowaParametru = new WartoscOpisowaParametru();
        wartoscOpisowaParametru.setParametrId(parametrId);
        wartoscOpisowaParametru.setDataOd(dataOd);
        wartoscOpisowaParametru.setDataDo(dataDo);
        wartoscOpisowaParametru.setWartosc(wartoscOpisowa);


        WartoscOpisowaParametru wynik = wartoscOpisowaParametruRepository.save(wartoscOpisowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "dodano rekord ID= " + wynik.getId();
        }

    }

    @GetMapping("/editOpisowaWartoscParametru/{id}/{wartoscOpisowa}")
    public String editOpisowaWartoscParametru(@PathVariable Long id, @PathVariable String wartoscOpisowa){

        WartoscOpisowaParametru wartoscOpisowaParametru = wartoscOpisowaParametruRepository.getById(id);
        wartoscOpisowaParametru.setWartosc(wartoscOpisowa);

        wartoscOpisowaParametruRepository.save(wartoscOpisowaParametru);


        WartoscOpisowaParametru wynik = wartoscOpisowaParametruRepository.save(wartoscOpisowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "edytowano rekord ID= " + wynik.getId();
        }

    }


    @GetMapping("/editOpisowaWartoscParametru/{id}/{parametrId}/{dataOd}/{dataDo}/{wartoscOpisowa}")
    public String editOpisowaWartoscParametru(@PathVariable Long id, @PathVariable Long parametrId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataOd, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataDo, @PathVariable String wartoscOpisowa){

        List<WartoscOpisowaParametru> czyJestJuzWpis = wartoscOpisowaParametruRepository.czyJestJuzWpis(parametrId, dataOd , dataDo);

        if (czyJestJuzWpis.size() > 0) {

            return "Wartość opisowa w tym przedziale czasowym już istnieje!";

        }

        WartoscOpisowaParametru wartoscOpisowaParametru = wartoscOpisowaParametruRepository.getById(id);
        wartoscOpisowaParametru.setDataOd(dataOd);
        wartoscOpisowaParametru.setDataDo(dataDo);
        wartoscOpisowaParametru.setWartosc(wartoscOpisowa);

        WartoscOpisowaParametru wynik = wartoscOpisowaParametruRepository.save(wartoscOpisowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "edytowano rekord ID= " + wynik.getId();
        }



    }


}
