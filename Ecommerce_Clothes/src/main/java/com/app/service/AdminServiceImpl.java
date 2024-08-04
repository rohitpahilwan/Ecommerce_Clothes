package com.app.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AdminDTO;
import com.app.entities.Admin;
import com.app.repositories.AdminRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        Admin savedAdmin = adminRepository.save(admin);
        return modelMapper.map(savedAdmin, AdminDTO.class);
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return modelMapper.map(admin, AdminDTO.class);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(admin -> modelMapper.map(admin, AdminDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        admin.setId(id);
        Admin updatedAdmin = adminRepository.save(admin);
        return modelMapper.map(updatedAdmin, AdminDTO.class);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
