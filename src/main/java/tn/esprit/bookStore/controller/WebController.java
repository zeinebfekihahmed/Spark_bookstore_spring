package tn.esprit.bookStore.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.bookStore.entities.Audio;

@Controller
public class WebController {

	@RequestMapping(value = "/audio", method = RequestMethod.GET)
	
	public void printURL(HttpServletResponse response,
			@RequestParam(value="text",required=true)String text) throws Exception
	{
		response.setHeader("Content-Disposition","attachment;filename=TextToSpeeach.wav");
		response.setContentType("audio/wave");
		
		Audio.getStream(response.getOutputStream(),text);

		
	}
}
