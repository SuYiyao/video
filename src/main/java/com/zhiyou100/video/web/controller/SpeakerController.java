package com.zhiyou100.video.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	@RequestMapping(value="/speakerList.action")
	public ModelAndView speakerList(SpeakerVO sv,@RequestParam(value="page",required=true,defaultValue="1") Integer currentPage){
		
		ModelAndView mv = new ModelAndView();
		String nameKey = sv.getNameKey();
		String positionKey = sv.getPositionKey();
		if(nameKey == null || positionKey == null){
			nameKey = "";
			positionKey = "";
		}
		mv.addObject("nameKey", nameKey);
		mv.addObject("positionKey", positionKey);
		
		
		sv.setCurrentPage(currentPage);
		sv.setNameKey(nameKey);
		sv.setPositionKey(positionKey);
		Page page= ss.loadPage(sv);
		
		mv.addObject("page", page);
		mv.setViewName("/admin/speaker/speakerList");
		return mv;
	}
	@RequestMapping(value="/addSpeaker.action")
	public ModelAndView addSpeaker(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/speaker/addSpeaker");
		return mv;
	}
	@RequestMapping(value="/addSpeaker.action",method = RequestMethod.POST)
	public String addSpeaker(Speaker speaker){
		
		ss.addSpeaker(speaker);
		
		return "redirect:/speaker/speakerList.action";
	}
	@RequestMapping(value="/editSpeaker.action",method = RequestMethod.GET)
	public ModelAndView editSpeaker(int id){
		ModelAndView mv = new ModelAndView();
		Speaker speaker = ss.findSpeakerById(id);
		mv.addObject("speaker", speaker);
		mv.setViewName("/admin/speaker/updateSpeaker");
		return mv;
	}
	@RequestMapping(value="/editSpeaker.action",method = RequestMethod.POST)
	public String editSpeaker(Speaker sp){
		ss.editSpeaker(sp);
		return "redirect:/speaker/speakerList.action";
	}
	@RequestMapping("/deleteSpeaker.action")
	public String deleteSpeaker(int id){
		ss.deleteSpeaker(id);
		return "redirect:/speaker/speakerList.action";
	}
	
	
	
}
