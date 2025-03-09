package com.refactoring.ch11.class13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ResourcePool {
	private Deque<Resource> available;
	private List<Resource> allocated;

	public ResourcePool() {
		available = new ArrayDeque<>();
		allocated = new ArrayList<>();
	}

	public Resource get() {
		Resource result = available.isEmpty() ? Resource.create() : available.pop();
		allocated.add(result);
		return result;
	}
}
