package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.SalesTop10ReportVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author chake
 */ /*
 * ClassName: ReportController
 * Package: com.sky.controller.admin
 * Description:
 * @Author: chake
 * @Create 2025/7/2 16:43
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 查询销量前10的商品
     *
     * @param begin
     * @param end
     * @return
     */
    @GetMapping("/top10")
    public Result<SalesTop10ReportVO> getTop10(@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
                                               @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end) {
        log.info("查询销量前10的商品, begin:{}, end:{}", begin, end);
        SalesTop10ReportVO salesTop10ReportVO = reportService.getTop10(begin, end);
        return Result.success(salesTop10ReportVO);
    }
}
