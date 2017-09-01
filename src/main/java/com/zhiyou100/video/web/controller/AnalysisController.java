package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.AnalysisService;
import com.zhiyou100.video.service.VideoService;

@Controller
@RequestMapping("/admin/analysis")
public class AnalysisController {

	@Autowired
	VideoService vs;
	@RequestMapping("analysisList.action")
	public ModelAndView analysis(){
		ModelAndView mv = new ModelAndView();
		List<VideoVO> list = vs.analysis();
		StringBuffer dataBuffer = new StringBuffer();
		StringBuffer timeBuffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++){
			VideoVO vo = list.get(i);
			dataBuffer.append(vo.getCourseName());
			timeBuffer.append(vo.getAvgTimes());
			if(i != list.size() -1 ){
				dataBuffer.append(",");
				timeBuffer.append(",");
			}
		}
		mv.addObject("data", dataBuffer.toString());
		mv.addObject("times", timeBuffer.toString());
		mv.setViewName("/admin/analysis/analysis");
		return mv;
	}
}
