package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.Article;
import com.example.demo.common.CommonResult;
import com.example.demo.common.Validator;

@Controller
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getArticle(@PathVariable int id) {
        Article article = this.articleService.getArticle(id);
        if (null == article) {
            return CommonResult.fail(null, "Fail to query article with id[" + id + "].");
        }
        return CommonResult.success(article, "");
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getArticle() {
        return CommonResult.success(this.articleService.getArticles(), "");
    }

    @RequestMapping(value = "article/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteArticle(@PathVariable int id) {
        if (null == this.articleService.getArticle(id)) {
            return CommonResult.fail(null, "Ariticle with id [" + id + "} does not exist.");
        }
        this.articleService.deleteArticle(id);
        return CommonResult.success(null, "");
    }

    @RequestMapping(value = "article/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article article, BindingResult result) {
        String error = Validator.validateField(result);
        if (error.length() != 0){
            return CommonResult.fail(null, error);
        }
        this.articleService.createArticle(article);
        return CommonResult.success(null, "");
    }

    @RequestMapping(value = "article/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> updateArticle(@Valid @RequestBody Article article, BindingResult result) {
        String error = Validator.validateField(result);
        if (error.length() != 0){
            return CommonResult.fail(null, error);
        }
        this.articleService.updateArticle(article);
        return CommonResult.success(null, "");
    }
}
