package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    Notification findByIdProduct (Long idProduct);
}
