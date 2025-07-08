package com.sky.service;

import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;

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
     * 获取营业额统计
     *
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
