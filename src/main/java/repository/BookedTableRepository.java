package repository;

import com.project.RestaurantManagementSystem.entity.BookedTables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedTableRepository extends JpaRepository<BookedTables,Long> {

    public BookedTables getByTablesAndDineInShowsId(String tables,Long id);
    public List<BookedTables> findByCustomerUserName(String userName);
}
