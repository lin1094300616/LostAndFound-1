package com.linjie.lostfound.system.controller;

import com.linjie.lostfound.framework.entity.Response;
import com.linjie.lostfound.framework.util.CommUtil;
import com.linjie.lostfound.system.model.Journalism;
import com.linjie.lostfound.system.model.Notice;
import com.linjie.lostfound.system.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.linjie.lostfound.framework.entity.StatusEnum;

import java.util.Date;
import java.util.List;

@RestController
public class JournalismController {
    @Autowired
    JournalismService journalismService;
    @GetMapping("/journalism/{id}")
    public Response findById(@PathVariable("id") Long id){
        Journalism journalism = journalismService.findById(id);
        if(journalism == null){
            return Response.factoryResponse(StatusEnum.JOURNALISM_ERROR_4002.getCode(),StatusEnum.JOURNALISM_ERROR_4002.getData());
        }

        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),journalism);
    }
    @GetMapping("/journalism")
    public Response findAll(){
        List<Journalism> journalismList = journalismService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),journalismList);
    }
    @DeleteMapping("/journalism/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Journalism journalism = journalismService.findById(id);
        if (journalism == null) {
            return Response.factoryResponse(StatusEnum.JOURNALISM_ERROR_4002.getCode(),StatusEnum.JOURNALISM_ERROR_4002.getData());
        }
        try {
            journalismService.delete(journalism);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_DELETE_FAIL.getCode(),StatusEnum.RET_DELETE_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }
    @PostMapping("/journalism")
    public Response add(@RequestParam("type") String type,
                        @RequestParam("content") String content,
                        @RequestParam("initiator") String initiator
                        ) {
        //1.数据校验
        if (CommUtil.isNullString(type,content)) {
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //2.数据封装
        Journalism journalism = new Journalism();
        journalism.setType(type);
        journalism.setContent(content);
        journalism.setInitiator(initiator);
        journalism.setCreateTime(new Date());

        //3.数据操作
        try {
            journalismService.save(journalism);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_INSERT_FAIL.getCode(),StatusEnum.RET_INSERT_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

}
