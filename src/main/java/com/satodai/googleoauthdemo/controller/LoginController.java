package com.satodai.googleoauthdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

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
     * なんかうまくいかないのでコメントアウト（多分自分の理解が足りない）
     *
     * @return ホーム画面へリダイレクト
     */
/*

    @PostMapping("")
    public String postLogin() {

        OAuth2AuthenticationToken auth = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthorizedClient client = oAuth2AuthorizedClientService.loadAuthorizedClient(
                auth.getAuthorizedClientRegistrationId(),
                auth.getName()
        );

        // トークンの取得
        String token = client.getAccessToken().getTokenValue();

        System.out.println("token: " + token);

        // return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "home";
        return "login";
    }
*/

}
