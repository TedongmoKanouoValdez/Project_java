package ma.enset.jpaap.repositories;

import lombok.Data;
import ma.enset.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    Page<Patient> findByMalade(boolean malade, Pageable pageable);
    /*List<Patient> findByMaladeAndScoreLessThan(boolean malade, int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List<Patient> findByDatenaissanceBetweenAndMaladeIsTrueOrNomLike(Data d1, Data d2, boolean malade, String nom);

    @Query("select p from Patient p where p.datenaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatients(@Param("x")Date d1, @Param("y") Date d2, @Param("z") String nom);*/

    @Query("select p from Patient p where p.nom like :x and p.score<:y")
    List<Patient> chercherNomPatients(@Param("x")String nom, @Param("y") int scoreMin);
}
