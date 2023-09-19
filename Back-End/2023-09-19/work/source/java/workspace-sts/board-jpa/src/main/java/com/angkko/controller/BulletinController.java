package com.angkko.controller;

import com.angkko.model.entity.Bulletin;
import com.angkko.service.BulletinService;
import com.angkko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sku")
public class BulletinController {
    private final BulletinService bulletinService;
    private final UserService userService;

    @RequestMapping({"/list", "/"})
    public String getArticleList(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("dataList", bulletinService.listArticle(pageable));
        return "list";
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public String writeArticle() {
        return "write";
    }

    @PostMapping("/add-article")
    @PreAuthorize("isAuthenticated()")
    public String addArticle(@RequestParam(value = "i_title") String title,
                             @RequestParam(value = "i_content") String content,
                             Principal principal) {
        Bulletin bulletin = new Bulletin();
        bulletin.setTitle(title);
        bulletin.setContent(content);
        bulletin.setWriter(userService.getUser(principal.getName()));
        // DB에 저장하는 서비스 호출
        bulletinService.addArticle(bulletin);
        return "redirect:list";
    }

    @GetMapping("/view")
    public ModelAndView viewArticle(@RequestParam(value = "no") String articleNo) {
        Bulletin bulletin = bulletinService.viewArticle(Integer.parseInt(articleNo));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view");
        mv.addObject("article", bulletin);
        return mv;
    }

    @PostMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public String editArticle(@RequestParam(value = "articleNo") String articleNo,
                              @RequestParam(value = "title") String title, @RequestParam(value = "content") String content,
                              RedirectAttributes attr) {
        Bulletin bulletin = new Bulletin();
        bulletin.setId(Integer.parseInt(articleNo));
        bulletin.setTitle(title);
        bulletin.setContent(content);
        bulletinService.editArticle(bulletin);
        attr.addAttribute("no", articleNo); // parameter 추가
        return "redirect:view";
    }

    @PostMapping("/remove")
    @PreAuthorize("isAuthenticated()")
    public String removeArticle(@RequestParam(value = "articleNo") String articleNo) {
        bulletinService.removeArticle(Integer.parseInt(articleNo));
        return "redirect:list";
    }

    @GetMapping("/info")
    @ResponseBody
    public Map<String, String> getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "sku project");
        map.put("version", "1.0");
        map.put("author", "soyeon");
        return map;
    }

    @GetMapping("/dogandcat")
    public String upload() throws Exception {
        return "classifier";
    }
}
