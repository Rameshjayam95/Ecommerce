package com.bazzar.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest 

{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.bazzar");
		context.refresh();
}
}