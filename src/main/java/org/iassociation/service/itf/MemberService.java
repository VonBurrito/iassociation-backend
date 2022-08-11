package org.iassociation.service.itf;

import org.iassociation.dto.MemberDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public MemberDTO addMember(MemberDTO member);

    public List<MemberDTO> getMembers();

    public Page<MemberDTO> getAllMembersByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);

    public MemberDTO retrieveMember(Long id);

    public MemberDTO updateMember(Long id, MemberDTO memberDTO);

    public void deleteMember(Long id);
}
