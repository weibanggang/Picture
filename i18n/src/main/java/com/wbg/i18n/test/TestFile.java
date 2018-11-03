package com.wbg.i18n.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class TestFile {



    @GetMapping("/book")
    public String index() {
        return "inputfile";
    }

    @RequestMapping(value = "/bbbbb", method = RequestMethod.POST)
    public String imageshangchuan(@RequestPart("xxx") MultipartFile multipartFile, Model model, HttpServletRequest request) {
        if (!multipartFile.getContentType().contains("image/")) {
            model.addAttribute("err", "只能是图片文件！");
            return "/inputfile";
        }
        if (multipartFile.getSize() > 1024 * 1024 * 5) {
            model.addAttribute("err", "只能是5M以下！");
            return "/inputfile";
        }
        //取得相对路径
        String basePath = request.getServletContext().getRealPath("/img");
        String rekativePath;
        try {
            rekativePath = makeImagePath(basePath, multipartFile.getOriginalFilename());
            File file = new File(rekativePath);
            file.getParentFile().mkdir();
            multipartFile.transferTo(file);
        } catch (IOException e) {
            model.addAttribute("err", "上传失败，请重试");
            return "/inputfile";
        }
        return "/index";
        }
        public String makeImagePath (String basePath, String fileName){
            Date date = new Date();
            String[] filename = simpleFile(fileName);
            return String.format("%s%s%s%supload_%s_%s.%s",
                    basePath,
                    File.separator,
                    new SimpleDateFormat("yyyyMMdd").format(date),
                    File.separator,
                    filename[0],
                    new SimpleDateFormat("hhmmss").format(date),
                    filename[1]
            );
        }
        public String[] simpleFile (String file){
            int sum = file.lastIndexOf(".");
            return new String[]{
                    file.substring(0, sum),
                    file.substring(sum + 1)
            };
        }
    }
