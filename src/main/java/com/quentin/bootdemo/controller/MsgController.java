package com.quentin.bootdemo.controller;

import com.quentin.bootdemo.dto.MyMessage;
import com.quentin.bootdemo.pojo.RetMessage;
import com.quentin.bootdemo.repo.MyMsgRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:quentin
 * @create: 2022-10-18 09:01
 * @Description:
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    private static final int PAGE_SIZE = 10;

    public static final Logger LOG = LoggerFactory.getLogger(MsgController.class);

    private final RetMessage<String> retMessage;

    private final MyMsgRepository msgRepository;

    public MsgController(
            RetMessage<String> retMessage, MyMsgRepository msgRepository) {
        this.msgRepository = msgRepository;
        this.retMessage = retMessage;
    }

    // 如果返回的对象没有实现get/set 返回会报错 具体原因要看jackson的实现
    // 使用jackson 必须写对应的get/set
    @GetMapping("")
    public RetMessage<String> msg() {
        return new RetMessage<String>()
                .msg("massage from server")
                .status("ok")
                .data("data");
    }

    @GetMapping("/get/{id}")
    public RetMessage<MyMessage> retMsg(
            @PathVariable String id, @ModelAttribute("currentHost") RetMessage<String> host) {
        MyMessage byId = new MyMessage();
        boolean isExist = msgRepository.existsById(Long.parseLong(id));
        if (isExist) {
            byId = msgRepository.findById(Long.parseLong(id));
        }
        return new RetMessage<MyMessage>()
                .msg("your message id is [ " + id + " ] from " + host.getData())
                .data(byId)
                .defaultBuild();
    }

    @ModelAttribute("currentHost")
    public RetMessage<String> curMes(@RequestHeader("Host") String host) {
        LOG.info("current host method has run");
        return new RetMessage<String>().data(host).defaultBuild();
    }

    @GetMapping("/bean")
    public String msgBean() {
        LOG.info("msg1 bean = " + retMessage.defaultBuild());
        return "ok";
    }

    @GetMapping("/count")
    public RetMessage<String> countMsg() {
        long count = msgRepository.count();
        return new RetMessage<String>()
                .msg("message count")
                .data(String.valueOf(count))
                .defaultBuild();
    }

    // 不建议获取所有 因为数据量太庞大
    @GetMapping("/all")
    public RetMessage<List<MyMessage>> allMes() {
        Page<MyMessage> all = msgRepository.findAll(PageRequest.of(1, PAGE_SIZE));
//        Stream<MyMessage> msgStream = all.get();
//        msgStream.close();
        return new RetMessage<List<MyMessage>>()
                .data(all.toList())
                .defaultBuild();
    }

    @GetMapping({"/page", "/page/{page}"})
    public RetMessage<List<MyMessage>> mesByPage(
            @PathVariable(required = false) Integer page) {

        page = page == null ? 0 : page;

        Page<MyMessage> byPage = msgRepository.findAll(PageRequest.of(page, PAGE_SIZE));
        return new RetMessage<List<MyMessage>>()
                .data(byPage.toList())
                .defaultBuild();
    }

    @GetMapping("/delete/{id}")
    public RetMessage<String> deleteMsg(@PathVariable Long id) {
        String status;
        if (msgRepository.existsById(id)) {
            msgRepository.deleteById(id);
            status = "ok";
        } else {
            status = "not found";
        }
        return new RetMessage<String>()
                .status(status)
                .defaultBuild();
    }

    @GetMapping("/end/{subMsg}")
    public RetMessage<List<MyMessage>> msgEndWithSubMsg(@PathVariable String subMsg) {
        List<MyMessage> endWithSubMsg = msgRepository.findByMsgEndsWith(subMsg);

        return new RetMessage<List<MyMessage>>()
                .msg("size of msg is: " + endWithSubMsg.size())
                .data(endWithSubMsg)
                .defaultBuild();
    }

//    @InitBinder
//    public void initMsg(WebDataBinder binder) {
//    }

}
