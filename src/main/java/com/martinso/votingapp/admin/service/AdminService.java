package com.martinso.votingapp.admin.service;

import com.martinso.votingapp.admin.dto.request.InviteRequest;
import com.martinso.votingapp.admin.dto.response.AdminDto;

public interface AdminService {

    AdminDto inviteAdmin(InviteRequest request);
}
