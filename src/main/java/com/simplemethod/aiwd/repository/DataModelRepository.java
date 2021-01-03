package com.simplemethod.aiwd.repository;

import com.simplemethod.aiwd.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DataModelRepository  extends JpaRepository<DataModel, Long> {

    DataModel findById(long ID);

    @Query(value = "SELECT max(ct_score) FROM DataModel")
    public BigDecimal max_Ct_score();

    @Query(value = "SELECT min(ct_score) FROM DataModel")
    public BigDecimal min_Ct_score();

    @Query(value = "SELECT * FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY :args) temp WHERE temp.row_num=ROUND (:percentile* @row_num)", nativeQuery = true)
    DataModel getPercentile(@Param("percentile") double percentile,@Param("args") String args);

    @Query(value = "SELECT :args FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY :args) temp WHERE temp.row_num=ROUND (:percentile* @row_num)", nativeQuery = true)
    Optional<String> getPercentileValue(@Param("percentile") double percentile, @Param("args") String args );

    @Query(value = "SELECT ct_armor FROM DataModel")
    public List<BigDecimal> getAllByct_armor();

    @Query(value = "SELECT ct_players_alive FROM DataModel")
    public List<BigDecimal> getAllByct_players_alive();

    @Query(value = "SELECT min(:args) FROM DataModel", nativeQuery = true)
    public BigDecimal getMinValue(@Param("args") String args);

    @Query(value = "SELECT max(:args) FROM DataModel", nativeQuery = true)
    public DataModel getMaxValue(@Param("args") String args);

    @Query(value = "SELECT avg(:args) FROM DataModel", nativeQuery = true)
    public DataModel getAvgValue(@Param("args") String args);



}
