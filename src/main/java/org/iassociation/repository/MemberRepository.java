package org.iassociation.repository;

import org.iassociation.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
