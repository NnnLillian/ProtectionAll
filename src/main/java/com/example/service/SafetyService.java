package com.example.service;

import com.example.entity.Safety;
import com.example.exception.BhException;

public interface SafetyService {
    Safety saveSafety(Safety safety) throws BhException;

    void deleteSafety(Long id, Long uid);

    Safety loadSafety(Long uid, String username, String mobile);
}
