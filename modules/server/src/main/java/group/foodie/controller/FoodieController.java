package group.foodie.controller;

import group.foodie.dao.entity.Foodie;
import group.foodie.entity.request.FoodTruck;
import group.foodie.entity.response.ResultVO;
import group.foodie.entity.response.UploadFileResult;
import group.foodie.interceptor.BusinessProcess;
import group.foodie.service.FoodieBizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * controller
 *
 * @author renmingyuan
 * @date 2022/11/25
 */
@Slf4j
@RestController
@RequestMapping("/foodie")
public class FoodieController {

    @Resource
    private FoodieBizService foodieBizService;

    @BusinessProcess
    @PostMapping("upload/csv")
    public ResultVO<UploadFileResult> uploadFile(MultipartHttpServletRequest httpServletRequest) throws Exception {
        MultipartFile multipartFile = httpServletRequest.getFile("file");
        if (multipartFile == null || multipartFile.isEmpty()) {
            return ResultVO.FAIL();
        }
        InputStream csv = multipartFile.getInputStream();
        InputStreamReader isr;
        BufferedReader br;
        try {
            isr = new InputStreamReader(csv, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultVO.FAIL();
        }
        String line;
        int count = 0;
        List<String> records = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                log.info("csv line {} : {}", count, line);
                count++;
                records.add(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultVO.FAIL();
        }
        foodieBizService.saveFoodieData(records);
        UploadFileResult result = new UploadFileResult();
        result.setCount(count - 1);
        return ResultVO.SUCCESS(result);
    }

    @BusinessProcess
    @PostMapping("trucks/find")
    public ResultVO<List<Foodie>> uploadFile(@RequestBody FoodTruck foodTruck) {
        List<Foodie> truckList = foodieBizService.getSpecifiedApprovedFoodTrucks(foodTruck);
        return ResultVO.SUCCESS(truckList);
    }
}
