package org.iassociation.service.impl;

import org.iassociation.dto.MemberDTO;
import org.iassociation.model.AuthorizationRequest;
import org.iassociation.model.Member;
import org.iassociation.repository.MemberRepository;
import org.iassociation.service.itf.MemberService;
import org.iassociation.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private ModelMapper modelMapper;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @Transactional
    @Override
    public MemberDTO addMember(MemberDTO memberDTO) {
        Member member = modelMapperUtil.mapToEntity(memberDTO);
        return modelMapperUtil.mapToDto(memberRepository.save(member));
    }

    @Transactional
    @Override
    public List<MemberDTO> getMembers() {
        return modelMapperUtil.mapMembersToList(memberRepository.findAll());
    }

    @Transactional
    @Override
    public Page<MemberDTO> getAllMembersByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
        return null;
    }

    @Transactional
    @Override
    public MemberDTO retrieveMember(Long id) {
        if (memberRepository.findById(id).isPresent()) {
            return modelMapperUtil.mapToDto(memberRepository.findById(id).get());
        }
        return null;
    }

    @Transactional
    @Override
    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        if (memberRepository.findById(id).isPresent()) {
            memberDTO.setId(id);
            Member member = memberRepository.findById(id).get();
            modelMapper.map(memberDTO, member);
            return modelMapperUtil.mapToDto(memberRepository.save(member));
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteMember(Long id) {
        if (memberRepository.findById(id).isPresent()) {
            memberRepository.deleteById(id);
        }
    }
}
