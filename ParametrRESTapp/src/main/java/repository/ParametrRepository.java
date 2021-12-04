package atmoterm.zadanie.rekrutacyjne.repository;

import atmoterm.zadanie.rekrutacyjne.entity.Parametr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Mateusz Rodak
 */

@Repository
public interface ParametrRepository extends JpaRepository <Parametr, Long> {



}
