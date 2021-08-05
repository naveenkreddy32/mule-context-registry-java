package com.example.api;

import org.mule.api.MuleContext;
import org.mule.config.spring.MuleArtifactContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MuleContextExample implements ApplicationListener<ContextRefreshedEvent>{

	/*@Lookup
	private MuleContext muleContext;*/

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Object source = event.getSource();
		
		if (!(source instanceof MuleArtifactContext))
			return;

		MuleContext muleContext = ((MuleArtifactContext) source).getMuleContext();
		
		String value = muleContext.getRegistry().get("app.name");
		
		System.out.println("Name is " + value);
		
	}
}
