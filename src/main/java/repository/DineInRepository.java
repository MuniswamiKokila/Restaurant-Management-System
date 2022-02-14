package repository;

import com.project.RestaurantManagementSystem.entity.DineIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DineInRepository extends JpaRepository<DineIn,Long> {
}
