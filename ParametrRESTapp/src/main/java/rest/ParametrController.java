package atmoterm.zadanie.rekrutacyjne.rest;


import atmoterm.zadanie.rekrutacyjne.entity.Parametr;
import atmoterm.zadanie.rekrutacyjne.repository.ParametrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Mateusz Rodak
 */

@RestController
public class ParametrController {

    @Autowired
    private ParametrRepository parametrRepository;

    @GetMapping("/getParameters")
    public List<Parametr> getParameters(){

        return parametrRepository.findAll();
    }

    @GetMapping("addParameters/{name}/{description}")
    public String addParameters(@PathVariable String name,@PathVariable String description){

        Parametr parametr = new Parametr();
        parametr.setName(name);
        parametr.setDescription(description);
        Parametr wynik = parametrRepository.save(parametr);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "dodano rekord ID= " + wynik.getId();
        }

    }

    @GetMapping("editParameters/{id}/{name}/{description}")
    public String editParameters(@PathVariable Long id, @PathVariable String name,@PathVariable String description){

        Parametr parametr =  parametrRepository.getById(id);
        parametr.setName(name);
        parametr.setDescription(description);
        Parametr wynik = parametrRepository.save(parametr);

        if(wynik == null) {
            return "wystąpił błąd zapisu";
        } else {
            return "edytowano rekord ID= " + wynik.getId();
        }

    }

    @GetMapping("deleteParameters/{id}")
    public String deleteParameters(@PathVariable Long id){

        Parametr parametr =  parametrRepository.getById(id);
        try {
            parametrRepository.delete(parametr);
        } catch (Exception e) {
            return "nie mozna usunac tego rekordu!";
        }

        return "usunieto rekord ID= " + id;

    }

}
