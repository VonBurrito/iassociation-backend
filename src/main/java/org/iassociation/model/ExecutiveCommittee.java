package org.iassociation.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
@Entity
@Table(name = "EXECUTIVE_COMMITTEE")
public class ExecutiveCommittee extends BaseEntity {

    @OneToMany(mappedBy = "executiveCommittee")
    private Set<Member> members;

}
