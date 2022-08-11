package org.iassociation.controller;

import org.iassociation.dto.MemberDTO;
import org.iassociation.exception.ApiRequestException;
import org.iassociation.service.itf.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
@RestController
@RequestMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberDTO> addAssociation(@RequestBody MemberDTO memberDTO) {
        try {
            return new ResponseEntity<>(memberService.addMember(memberDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping
    public List<MemberDTO> getAllAssociations() {
        try {
            return memberService.getMembers();
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable Long id) {
        try {
            memberService.retrieveMember(id);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateAssociation(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        try {
            return new ResponseEntity<>(memberService.updateMember(id, memberDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getAssociation(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(memberService.retrieveMember(id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }
}
