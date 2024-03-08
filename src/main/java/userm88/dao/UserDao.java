package userm88.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import userm88.dto.User;

public class UserDao {
public void saveUser(User user) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
}

public void UpdateUser(int id,User user) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User dbUser=entityManager.find(User.class, id);
	
	if(dbUser!=null) {
//		id is present 
//		if im going to call merge method then it will update the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		user.setId(id);
//		user=id,name,address
		entityManager.merge(user);
		entityTransaction.commit();
	}else {
//		id is not present
//		if im going to call merge method then it will insert the data
//		so im not going to call merge method only
		System.out.println("Sorry Id is not present to update the data");
	}
}


public void findUser(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User dbUser=entityManager.find(User.class, id);
	if(dbUser!=null) {
		System.out.println(dbUser);
	}else {
		System.out.println("Sorry Id is not present");
	}
}


public void deleteUser(int id) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User dbUser=entityManager.find(User.class, id);
	
	
	if(dbUser!=null) {
//		id is present so i can delete the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbUser);
		entityTransaction.commit();
	}else {
		
		System.out.println("Sorry Id is not present");
	}

}













}
