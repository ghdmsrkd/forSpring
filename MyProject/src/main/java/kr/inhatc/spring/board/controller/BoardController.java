package kr.inhatc.spring.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BoardController {

   
   @RequestMapping()
   public String hello() {
      return "index";
   }
}