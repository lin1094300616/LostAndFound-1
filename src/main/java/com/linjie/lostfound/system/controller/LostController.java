package com.linjie.lostfound.system.controller;

import com.linjie.lostfound.framework.entity.Response;
import com.linjie.lostfound.framework.util.CommUtil;
import com.linjie.lostfound.framework.util.FileUtil;
import com.linjie.lostfound.system.model.Lost;
import com.linjie.lostfound.system.service.LostService;
import com.linjie.lostfound.framework.entity.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
public class LostController {
    @Autowired
    LostService lostService;

    @GetMapping("/lost")
    public Response findAll() {
        List<Lost> lostList = lostService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),lostList);
    }

    @GetMapping("/lost/{id}")
    public Response findById(@PathVariable("id") Long id){
        Lost lost = lostService.findById(id);
        if(lost == null){
            return Response.factoryResponse(StatusEnum.LOST_ERROR_2002.getCode(),StatusEnum.LOST_ERROR_2002.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),lost);
    }

    @DeleteMapping("/lost/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Lost lost = lostService.findById(id);
        if (lost == null) {
            return Response.factoryResponse(StatusEnum.LOST_ERROR_2002.getCode(),StatusEnum.LOST_ERROR_2002.getData());
        }
        try {
            lostService.delete(lost);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_DELETE_FAIL.getCode(),StatusEnum.RET_DELETE_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

    /**
     * @Author LINJIE
     * @Description 失物添加
     * @Content: 步骤：1、数据接收
     *                  2、数据校验
     *                  3、数据封装
     *                  4、数据操作
     * @Date 2019/3/12 21:12
     * @Param [title, lostTime, location, information, contacts, phone, multipartFile]
     * @return com.linjie.lostfound.framework.entity.Response
     **/
    @PostMapping("/lost")
    public Response add(@RequestParam("title") String title,
                        @RequestParam("lostTime") String lostTime,
                        @RequestParam("location") String location,
                        @RequestParam(value = "information",defaultValue = "--") String information,
                        @RequestParam("contacts") String contacts,
                        @RequestParam("phone") String phone,
                        @RequestParam("image") MultipartFile multipartFile) {
        //2.数据校验
        if (CommUtil.isNullString(title,lostTime,location,phone,contacts)) {
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //3.数据封装
        Lost lost = new Lost(); //实例化
        //定义
        //类型 变量名  是什么
        //Lost lost1 = new Lost();
        lost.setTitle(title);
        lost.setLostTime(CommUtil.stringToDate(lostTime,"yyyy-MM-dd"));
        lost.setLocation(location);
        lost.setInformation(information);
        lost.setContacts(contacts);
        lost.setPhone(phone);
        //3.1保存图片，如果失败就返回文件保存失败
        String fileName = FileUtil.fileUpload("lost",multipartFile);
        if (CommUtil.isNullString(fileName)) {
            return Response.factoryResponse(StatusEnum.LOST_ERROR_2003.getCode(),StatusEnum.LOST_ERROR_2003.getData());
        }
        lost.setImage(fileName);
        //4.数据操作
        try {
            lostService.save(lost);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_INSERT_FAIL.getCode(),StatusEnum.RET_INSERT_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }
}
