package com.satodai.googleoauthdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 静的リソースをセキュリティから除外
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静的リソースへのアクセスにはセキュリティを適用しない
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    /**
     * 直リンクの禁止
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ログイン不要ページとそれ以外の直リンクを禁止に
        http
                .authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated();

        // OAuth2を使用したログイン処理
        http
                .oauth2Login()
                // .loginProcessingUrl("/login") // ログイン処理のパス
                .loginPage("/login") // ログインページの指定
                // .failureUrl("/login") // ログイン失敗時の遷移先
                // .usernameParameter("userId") // ログインページのユーザーID
                // .passwordParameter("password") // ログインページのパスワード
                .defaultSuccessUrl("/home",true); // ログイン成功時の遷移先
        ;

        // CSRF対策を一時的に無効
        http.csrf().disable();
    }
}
