package co.simplon.burger.persistance.repository.ad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.User;

/**
 * Interface for {@link Ad} repository.
 */
@Repository
public interface IAdRepository extends JpaRepository<Ad, Integer> {
    /**
     * @param vendor the vendor to search for
     * @return a list of ads with the given vendor
     */
    @Query(AdQueries.FIND_BY_VENDOR)
    List<Ad> findByVendor(final User vendor);
}
