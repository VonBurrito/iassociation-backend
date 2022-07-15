package org.iassociation.repository;

import org.iassociation.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hamza Amentag
 * @since 7/11/2022
 */
@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
