package com.example.staffpoc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.staffpoc.model.StaffDetails;
import com.example.staffpoc.repository.StaffRepository;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<StaffDetails> findStaffByCriteria(int year, double salary) {
    	List<StaffDetails> staffList = staffRepository.findByJoinDateYearAndSalaryGreaterThan(year, salary);
        return staffList.stream()
                .filter(staff -> staff.getProjects().size() > 1)
                .collect(Collectors.toList());
    
    }
    
    public List<StaffDetails> getAllStaffMembers() {
        return staffRepository.findAll();
    }
}
