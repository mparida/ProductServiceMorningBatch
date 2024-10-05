package com.scaler.productservicemorningbatch;

import org.springframework.web.bind.annotation.*;

//This controller supports http requests (HTTP Requests)
//Req coming to end point /hello
@RestController
@RequestMapping("/say")
public class SampleController {
    @GetMapping("/{name}/{number}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("number") int num) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < num ; i++){
            sb.append("Hello "+name).append("\n\n");
        }
        return sb.toString();
    }
    @PostMapping()
    public void postMethod(){

    }
}
