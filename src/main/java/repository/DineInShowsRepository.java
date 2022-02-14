package repository;

import com.project.RestaurantManagementSystem.entity.DineInShows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DineInShowsRepository extends JpaRepository<DineInShows,Long> {
    public List<DineInShows> findByDineInId(Long id);
}
