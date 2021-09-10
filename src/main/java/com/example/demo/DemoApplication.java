package com.example.demo;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.interfaces.*;
import com.example.demo.repositories.TodoItemRepository;
import org.hibernate.annotations.CreationTimestamp; // Using the Hibernate timestamps
import org.hibernate.annotations.UpdateTimestamp; 
import java.util.*;

@SpringBootApplication // Not "a Component"
public class DemoApplication implements CommandLineRunner,TestUiInterface // implement the functional interface COMMANDLINERUNNER
{

	public final TodoItemRepository todoRepository;

    public DemoApplication(TodoItemRepository todoRepository) 
    {
        this.todoRepository = todoRepository;
    }
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
		//htis like constructor?
	}

	@Override
	public void run(String... args) throws Exception
	{
		// test creation section
		List<TodoItem> l = new ArrayList<TodoItem>();
		 
		boolean btest1=ListIsEmpty(l);
		System.out.println("Ergebnis "+btest1);
		loadTodos();
	}

	@Override
	public boolean ListIsEmpty(List<TodoItem> l) 
	{
		if(l.size()==0)
		return true;
		else return false;
	}
	
	private void loadTodos() 
	{
        if (todoRepository.count() == 0) 
        {
        	TodoItem new_A , new_B;
        	 
        	//<>
        	new_A = new TodoItem("Gehe zum Markt","Kaufe Eier vom Markt",TodoStatus.RUNNING);
            todoRepository.save(new_A);
        	new_B = new TodoItem("Gehe zur Schule","Zertifikate und Prüfungen ablegen",TodoStatus.COMPLETED);
        	todoRepository.save(new_B);
                       
           
            System.out.println("exemplarisch Todo Items geladen");
        }
    }

}
