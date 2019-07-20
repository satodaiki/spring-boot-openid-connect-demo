package com.satodai.googleoauthdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Controller
public class LoginController {

    /**
     * ログインページ表示
     *
     * @return ログイン画面
     */
    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    /**
     * OpenID Connectを使用したログイン処理
     *
     * @return ホーム画面へリダイレクト
     */
    @PostMapping("oauth2/login")
    public String postLogin() {


        // return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "home";
        return "login";
    }
}
