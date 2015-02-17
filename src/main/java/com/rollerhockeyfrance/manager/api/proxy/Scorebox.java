package com.rollerhockeyfrance.manager.api.proxy;

import java.util.ArrayList;
import java.util.List;

public class Scorebox {
	
	private List<Match> last = new ArrayList<Match>();
	private List<Match> next = new ArrayList<Match>();
	
	public List<Match> getLast() {
		return last;
	}
	
	public void setLast(List<Match> last) {
		this.last = last;
	}
	
	public List<Match> getNext() {
		return next;
	}
	
	public void setNext(List<Match> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Scorebox [last=" + last + ", next=" + next + "]";
	}

}
