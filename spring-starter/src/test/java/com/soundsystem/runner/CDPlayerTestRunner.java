package com.soundsystem.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.soundsystem.test.CDPlayerTest;

public class CDPlayerTestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CDPlayerTest.class);
		for (Failure f : result.getFailures()) {
			System.out.println(f.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
