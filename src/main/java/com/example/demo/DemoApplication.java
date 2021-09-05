package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.interfaces.*;
import java.util.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner,TestUiInterface // implement the functional interface COMMANDLINERUNNER
{

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		// test creation section
		List<TodoItem> l = new ArrayList<TodoItem>();
		l.add(new TodoItem());
		l.add(new TodoItem());
		l.add(new TodoItem());
		l.add(new TodoItem());
		boolean btest1=ListIsEmpty(l);
		System.out.println("Ergebnis "+btest1);
	}

	@Override
	public boolean ListIsEmpty(List<TodoItem> l) 
	{
		if(l.size()==0)
		return true;
		else return false;
	}
	

}
