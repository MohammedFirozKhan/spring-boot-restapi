package com.cisco.sp.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{foo}")
	public Topic getAllTopic(@PathVariable("foo") Integer id){
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/topics")
	public void addTopics(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic( @RequestBody Topic topic, @PathVariable Integer id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic( @RequestBody Topic topic, @PathVariable Integer id) {
		topicService.deleteTopic(topic, id);
	}

}
