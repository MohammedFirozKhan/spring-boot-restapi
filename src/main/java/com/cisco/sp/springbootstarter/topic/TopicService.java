package com.cisco.sp.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = getAllTopics();
	
	
public List<Topic> getTopics(){
		
		return topics;
		
	}
	

	private List<Topic> getAllTopics(){
		
		List<Topic>  topics = new ArrayList<>();
		Topic topic = new Topic();
		topic.setId(1);
		topic.setName("Spring Boot");
		topic.setDescription("spring desc");
		
		Topic topic2 = new Topic();
		topic2.setId(2);
		topic2.setName("Spring Boot2");
		topic2.setDescription("spring desc2");
		
		topics.add(topic);
		topics.add(topic2);
		
		return topics;
		
	}
	
	public Topic getTopic(Integer id) {
		return topics.stream().filter(t -> t.getId() == id).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		
		topics.add(topic);
		
	}


	public void updateTopic(Topic updatedTopic, Integer id) {
		for (Topic topic : topics) {
			
		if (topic.getId() == id) {
			topics.remove(topic);
			topics.add(updatedTopic);
		}
			
		}
		
	}


	public void deleteTopic(Topic topic, Integer id) {
		topics.removeIf(t -> t.getId() == id);
		
	}
	
	


}
