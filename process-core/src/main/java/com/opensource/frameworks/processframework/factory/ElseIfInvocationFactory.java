package com.opensource.frameworks.processframework.factory;

import java.util.LinkedList;
import java.util.List;

import com.opensource.frameworks.processframework.config.ElementConfig;
import com.opensource.frameworks.processframework.config.ElseIfTagConfig;
import com.opensource.frameworks.processframework.invocation.IfInvocation;
import com.opensource.frameworks.processframework.invocation.Invocation;
import com.opensource.frameworks.processframework.utils.CollectionUtils;

public class ElseIfInvocationFactory implements
		InvocationFactory<ElseIfTagConfig> {

	@Override
	public Invocation create(ElseIfTagConfig config) {
		List<Invocation> invocations = new LinkedList<Invocation>(); 
		List<ElementConfig> childs = config.getChilds(); 
		if (!CollectionUtils.isEmpty(childs)) {
			for (ElementConfig item : childs) {
				Invocation invocation=InvocationBuilder.build(item);
				if(invocation!=null){
					invocations.add(invocation);
				}
			}
		}  
		return new IfInvocation(config.getTest(),invocations);
	}

}
