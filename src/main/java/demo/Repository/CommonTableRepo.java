package demo.Repository;

import demo.Entity.CommonTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonTableRepo extends JpaRepository<CommonTable,Long> {
    List<CommonTable> findAllByTablename(String tablekey);
    CommonTable findByTablename(String tablename);
}
