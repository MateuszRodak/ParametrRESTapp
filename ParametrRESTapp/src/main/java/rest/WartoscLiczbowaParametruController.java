package atmoterm.zadanie.rekrutacyjne.rest;


import atmoterm.zadanie.rekrutacyjne.entity.WartoscLiczbowaParametru;
import atmoterm.zadanie.rekrutacyjne.enums.Jednostka;
import atmoterm.zadanie.rekrutacyjne.repository.WartoscLiczbowaParametruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Author: Mateusz Rodak
 */

@RestController
public class WartoscLiczbowaParametruController extends  WartoscParametruController{


    @Autowired
    private WartoscLiczbowaParametruRepository wartoscLiczbowaParametruRepository;

    @GetMapping("/addLiczbowaWartoscParametru/{parametrId}/{dataOd}/{dataDo}/{wartoscLiczbowa}/{jednostka}")
    public String addLiczbowaWartoscParametru(@PathVariable Long parametrId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataOd, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataDo, @PathVariable BigDecimal wartoscLiczbowa, @PathVariable String jednostka){

        List<WartoscLiczbowaParametru> czyJestJuzWpis = wartoscLiczbowaParametruRepository.czyJestJuzWpis(parametrId, dataOd , dataDo);

        if (czyJestJuzWpis.size() > 0) {

            return "Wartość Liczbowa w tym przedziale czasowym już istnieje!";
        }

        WartoscLiczbowaParametru wartoscLiczbowaParametru = new WartoscLiczbowaParametru();
        wartoscLiczbowaParametru.setParametrId(parametrId);
        wartoscLiczbowaParametru.setDataOd(dataOd);
        wartoscLiczbowaParametru.setDataDo(dataDo);
        wartoscLiczbowaParametru.setWartosc(wartoscLiczbowa);
        wartoscLiczbowaParametru.setJednostka(Jednostka.valueOf(jednostka));

        WartoscLiczbowaParametru wynik = wartoscLiczbowaParametruRepository.save(wartoscLiczbowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "dodano rekord ID= " + wynik.getId();
        }

    }

    @GetMapping("/editLiczbowaWartoscParametru/{id}/{wartoscLiczbowa}/{jednostka}")
    public String editLiczbowaWartoscParametru(@PathVariable Long id, @PathVariable BigDecimal wartoscLiczbowa, @PathVariable String jednostka){

        WartoscLiczbowaParametru wartoscLiczbowaParametru = wartoscLiczbowaParametruRepository.getById(id);
        wartoscLiczbowaParametru.setWartosc(wartoscLiczbowa);
        wartoscLiczbowaParametru.setJednostka(Jednostka.valueOf(jednostka));

        WartoscLiczbowaParametru wynik = wartoscLiczbowaParametruRepository.save(wartoscLiczbowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "edytowano rekord ID= " + wynik.getId();
        }
    }

    @GetMapping("/editLiczbowaWartoscParametru/{id}/{parametrId}/{dataOd}/{dataDo}/{wartoscLiczbowa}/{jednostka}")
    public String editLiczbowaWartoscParametru(@PathVariable Long id, @PathVariable Long parametrId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataOd, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataDo, @PathVariable BigDecimal wartoscLiczbowa, @PathVariable String jednostka){

        List<WartoscLiczbowaParametru> czyJestJuzWpis = wartoscLiczbowaParametruRepository.czyJestJuzWpis(parametrId, dataOd , dataDo);

        if (czyJestJuzWpis.size() > 0) {
            return "Wartość Liczbowa w tym przedziale czasowym już istnieje!";
        }

        WartoscLiczbowaParametru wartoscLiczbowaParametru = wartoscLiczbowaParametruRepository.getById(id);
        wartoscLiczbowaParametru.setWartosc(wartoscLiczbowa);
        wartoscLiczbowaParametru.setJednostka(Jednostka.valueOf(jednostka));

        WartoscLiczbowaParametru wynik = wartoscLiczbowaParametruRepository.save(wartoscLiczbowaParametru);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "edytowano rekord ID= " + wynik.getId();
        }
    }

}
