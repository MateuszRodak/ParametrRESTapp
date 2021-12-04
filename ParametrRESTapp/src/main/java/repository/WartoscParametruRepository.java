package atmoterm.zadanie.rekrutacyjne.repository;

import atmoterm.zadanie.rekrutacyjne.entity.WartoscParametru;
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
public interface WartoscParametruRepository extends JpaRepository <WartoscParametru, Long> {

    List<WartoscParametru> findByParametrId(Long parametrId);

//JPA QUERY
    List<WartoscParametru> findByParametrIdAndDataOdAfterAndDataDoBefore(Long parametrId, Date dataOd, Date dataDo);

//NATIVE QUERY USE
@Query( value = "SELECT * FROM WARTOSC_PARAMETRU wp WHERE wp.PARAMETR_ID = :parametrId AND wp.DATA_OD > :dataOd AND wp.DATA_DO < :dataDo", nativeQuery = true)
    List<WartoscParametru> znajdzPoParametrzeIDatach(@Param("parametrId") Long parametrId,@Param("dataOd") Date dataOd,@Param("dataDo") Date dataDo);


}
