package com.linjie.lostfound.system.controller;

import com.linjie.lostfound.framework.entity.Response;
import com.linjie.lostfound.framework.util.CommUtil;
import com.linjie.lostfound.system.model.Found;
import com.linjie.lostfound.system.model.Lost;
import com.linjie.lostfound.system.model.Notice;
import com.linjie.lostfound.system.model.Thank;
import com.linjie.lostfound.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.linjie.lostfound.framework.entity.StatusEnum;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @GetMapping("/notice/{id}")
    public Response findById(@PathVariable("id") Long id){
        Notice notice = noticeService.findById(id);
        if(notice == null){
            return Response.factoryResponse(StatusEnum.NOTICE_ERROR_5002.getCode(),StatusEnum.NOTICE_ERROR_5002.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),notice);
    }
    @GetMapping("/notice")
    public Response findAll(){
        List<Notice>noticeList =noticeService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),noticeList);
    }
    @DeleteMapping("/notice/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Notice notice = noticeService.findById(id);
        if (notice == null) {
            return Response.factoryResponse(StatusEnum.NOTICE_ERROR_5002.getCode(),StatusEnum.NOTICE_ERROR_5002.getData());
        }
        try {
            noticeService.delete(notice);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_DELETE_FAIL.getCode(),StatusEnum.RET_DELETE_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }
    @PostMapping("/notice")
    public Response add(@RequestParam("title") String title, @RequestParam("content") String content) {
        //1.数据校验
        if (CommUtil.isNullString(title,content)) {
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //2.数据封装
        Notice notice = new Notice();

        notice.setTitle(title);
        notice.setContent(content);

        //3.数据操作
        try {
            noticeService.save(notice);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_INSERT_FAIL.getCode(),StatusEnum.RET_INSERT_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

}
