package com.app.service;


import java.util.List;

import com.app.dto.AdminDTO;

public interface AdminService {

    AdminDTO createAdmin(AdminDTO adminDTO);

    AdminDTO getAdminById(Long id);

    List<AdminDTO> getAllAdmins();

    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);

    void deleteAdmin(Long id);
}
