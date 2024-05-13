package com.Se2.MusicPlatform.controller;
import com.Se2.MusicPlatform.model.*;
import com.Se2.MusicPlatform.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class MusicController {

    @Autowired
    SongRepository songRepository;

    @RequestMapping(value = "/")
    public String homePage(){
        return "redirect:/home";
    }
    @RequestMapping(value = "/home")
    public String getNavigationBar(Model model) {
        List<Song> songs = songRepository.findAll();
        Collections.shuffle(songs);
        List<Song> randomSongs = songs.subList(0, Math.min(songs.size(), 5));

        model.addAttribute("songs", randomSongs);
        return "screens/HomePage";
    }
    @RequestMapping(value = "/signup")
    public String getSignUpPage() {
        return "screens/SignUp";
    }
    @RequestMapping(value = "/signin")
    public String getSignInPage() {
        return "screens/SignIn";
    }
    @RequestMapping(value = "/lyrics")
    public String getSongDetailPage() {
        return "screens/SongDetailPage";
    }

    @RequestMapping(value = "/playlist")
    public String getPlaylistPage() {
        return "screens/PlaylistPage";
    }

    @RequestMapping(value = "/search")
    public String getSearchPage() {
        return "screens/SearchPage";
    }


}
