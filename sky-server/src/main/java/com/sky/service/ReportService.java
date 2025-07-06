package com.sky.service;

import com.sky.vo.SalesTop10ReportVO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * ClassName: ReportService
 * Package: com.sky.service
 * Description:
 * @Author: chake
 * @Create 2025/7/2 16:49
 * @Version 1.0
 */
public interface ReportService {
    /**
     * 获取销售Top10
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO getTop10(LocalDate begin, LocalDate end);
}
