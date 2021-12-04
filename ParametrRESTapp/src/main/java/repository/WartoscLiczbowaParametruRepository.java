package atmoterm.zadanie.rekrutacyjne.repository;

import atmoterm.zadanie.rekrutacyjne.entity.WartoscLiczbowaParametru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Author: Mateusz Rodak
 */

@Repository
public interface WartoscLiczbowaParametruRepository extends JpaRepository <WartoscLiczbowaParametru, Long> {

    @Query( value = "SELECT * FROM WARTOSC_PARAMETRU wp WHERE wp.PARAMETR_ID = :parametrId AND wp.WARTOSC_LICZBOWA IS NOT NULL AND wp.DATA_OD >= :dataOd AND wp.DATA_OD <= :dataDo OR wp.DATA_DO >= :dataDo AND wp.DATA_DO <= :dataOd", nativeQuery = true)
    List<WartoscLiczbowaParametru> czyJestJuzWpis(@Param("parametrId") Long parametrId, @Param("dataOd") Date dataOd, @Param("dataDo") Date dataDo);

}
