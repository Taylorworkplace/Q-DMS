package com.gzgs.service;

import com.gzgs.bean.Log;
import com.gzgs.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LogService {
    public Log getLog();
    public void check();
}
