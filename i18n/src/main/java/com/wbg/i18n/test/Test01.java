package com.wbg.i18n.test;

import com.sun.corba.se.spi.resolver.LocalResolver;
import com.wbg.i18n.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import sun.util.locale.provider.LocaleResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping("/test01")
public class Test01 {

    @PostMapping("/upload")
    public String upload(MultipartFile multipartFile) throws Exception{
        String savePath="xxx";
        if(!multipartFile.isEmpty()){
            multipartFile.transferTo(new File((savePath+multipartFile.getOriginalFilename())));
        }
        return "test01/index33";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String index(){

        return "index";
    }
    @RequestMapping(value = "/index3",method = RequestMethod.GET)
    public String index3(){

        return "index33";
    }
    @Autowired
    private LocaleResolver localeResolver;
    @RequestMapping("/{loc}")
    public String cheagr(@PathVariable("loc") String loc, HttpServletResponse response, HttpServletRequest request){
        Locale locale=new Locale(loc);

        localeResolver.setLocale(request,response,locale);
        return "redirect:/test01";
    }
    @Autowired
    private ThemeResolver themeResolver;

    @RequestMapping("/theme/{loc}")
    public String Therme(@PathVariable("loc") String loc, HttpServletResponse response, HttpServletRequest request){
        themeResolver.setThemeName(request,response,loc);
        return "index33";
    }
    @ResponseBody
    @RequestMapping("/session/{key}/{value}")
    public HashMap<String,String> cheagrs(@PathVariable("key") String key, @PathVariable("value") String value, HttpSession session){
        session.setAttribute(key,value);

        return new HashMap<String,String>(){{
            put(key,value);
        }
        };
    }
    @RequestMapping("/books")
    public String se(@Valid Book book , BindingResult result){
        if(result.hasErrors())
            return "index";
        return "/inputfile";
    }

}
