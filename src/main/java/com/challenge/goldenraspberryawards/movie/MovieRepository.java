package com.challenge.goldenraspberryawards.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = " select * from movie m where m.winner='yes' order by year_award ", nativeQuery = true)
    List<Movie> findAwardWinners();

}
