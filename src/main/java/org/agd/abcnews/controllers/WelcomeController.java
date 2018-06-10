package org.agd.abcnews.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.agd.abcnews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @Autowired
	private ArticleService articleService;

	@Value("${welcome.message:test}")
	private String message;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {

		model.put("title", this.message);
		boolean viewAllArticles = hasRole("ROLE_EDITOR");
		model.put("articleList", articleService.listArticles(viewAllArticles));
		return "welcome";
	}

    private boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }

}