package com.example.demo.interfaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp; // Using the Hibernate timestamps
import org.hibernate.annotations.UpdateTimestamp;   // Using the Hibernate Update timestamps

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoItem 
{
	  // automatic index 
	     @Id
	    @GeneratedValue
	    @Column(updatable = false, nullable = false)
	    Long id;
	    @Column
	    String title;
	    @Column
	    String description;
	    
	    // see: enumeration TODOSTATUS below
	    @Column
	    TodoStatus todoStatus;

	    @CreationTimestamp
	    @Column(updatable = false) // column dateCreated is not changeable from runtime
	    Timestamp dateCreated;
	    
	    @UpdateTimestamp // lastModified date can be updated
	    Timestamp lastModified;

		public TodoItem()
		{}

		public TodoItem(String title, String description, TodoStatus todoStatus) 
		{
			super();
			this.title = title;
			this.description = description;
			this.todoStatus = todoStatus;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public TodoStatus getTodoStatus() {
			return todoStatus;
		}

		public void setTodoStatus(TodoStatus todoStatus) {
			this.todoStatus = todoStatus;
		}

		public Timestamp getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Timestamp dateCreated) {
			this.dateCreated = dateCreated;
		}

		public Timestamp getLastModified() {
			return lastModified;
		}

		public void setLastModified(Timestamp lastModified) {
			this.lastModified = lastModified;
		}
}


