package atmoterm.zadanie.rekrutacyjne.rest;

import atmoterm.zadanie.rekrutacyjne.entity.WartoscParametru;
import atmoterm.zadanie.rekrutacyjne.repository.WartoscParametruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * Author: Mateusz Rodak
 */

public class WartoscParametruController {

    @Autowired
    private WartoscParametruRepository wartoscParametruRepository;


    @GetMapping("/getWartosciParametru/{parametrID}")
    public List<WartoscParametru> getWartosciParametru(@PathVariable Long parametrID){


        return wartoscParametruRepository.findByParametrId(parametrID);

    }


    @GetMapping("/getWartosciParametru/{parametrID}/{dataOd}/{dataDo}")
    public List<WartoscParametru> getWartosciParametru(@PathVariable Long parametrID, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataOd, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dataDo){

    //NATIVE QUERY
        //return wartoscParametruRepository.znajdzPoParametrzeIDatach(parametrID,dataOd,dataDo);
    //JPA QUERY
        return wartoscParametruRepository.findByParametrIdAndDataOdAfterAndDataDoBefore(parametrID,dataOd,dataDo);

    }


@GetMapping("/deleteWartoscParametru/{id}")
    public String deleteWartoscParametru(@PathVariable Long id){

        try {
            wartoscParametruRepository.deleteById(id);
        }catch(Exception e){
            return "nie mozna usunac tego rekordu!";
        }

            return "usunięto rekord ID= " + id;

    }

}
