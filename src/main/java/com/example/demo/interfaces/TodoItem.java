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
@Getter
@Setter
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
}

enum TodoStatus
{	
	OPENED,RUNNING,COMPLETED
}
