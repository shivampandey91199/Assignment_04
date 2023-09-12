package com;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subscription {
    @Id
	int subscriptionId;
	String subscriptionName;
	
	@ManyToMany
	Set<Reader> readers;
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	public Set<Reader> getReaders() {
		return readers;
	}
	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", subscriptionName=" + subscriptionName
				+ ", readers=" + readers + "]";
	}
	
	
}
