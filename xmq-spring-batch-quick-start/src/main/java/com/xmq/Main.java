package com.xmq;

import org.springframework.boot.SpringApplication;

import com.xmq.configure.BatchConfiguration;

public class Main {
	  public static void main(String [] args) {
	    System.exit(SpringApplication.exit(SpringApplication.run(
	        BatchConfiguration.class, args)));
	  }
	}