package com.martinso.votingapp.admin.service;

import com.martinso.votingapp.admin.data.model.Admin;
import com.martinso.votingapp.admin.data.repository.AdminRepository;
import com.martinso.votingapp.admin.dto.request.InviteRequest;
import com.martinso.votingapp.admin.dto.response.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository repository;

    @Autowired
    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public AdminDto inviteAdmin(InviteRequest request) {
        Admin invite = Admin.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .middleName(request.getMiddle())
                .email(request.getEmail())
                .username(request.getUsername())
                .gender(request.getGender())
                .address(request.getAddress())
                .password(request.getPassword())
                .matchpassword(request.getMatchPassword()).build();
        Admin saved = repository.save(invite);
        return getResponse(saved);
    }

    private AdminDto getResponse(Admin saved) {
        return AdminDto.builder()
                .id(saved.getId())
                .message("Invite successful")
                .code(HttpStatus.OK.value())
                .isSuccess(true)
                .build();
    }
}
