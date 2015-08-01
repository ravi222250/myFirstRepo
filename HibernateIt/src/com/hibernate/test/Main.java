package com.hibernate.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.test.util.HibernateUtil;


public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		//m.saveEmployee("24-05-2015", "21-00", 10, 11, 12, 13);
//		m.saveEmployee("25-05-2015", "22-00", 10, 11, 12, 13);
		//m.saveEmployee("26-05-2015", "23-00", 10, 11, 12, 13);
//		m.saveEmployee("27-05-2015", "24-00", 10, 11, 12, 13);
		m.retriveEmployee();
		//m.deleteEmployee();
		//m.updateEmployee();
	}
	public void saveEmployee(String date_of_data, String time_of_data, int install_time, 
			int first_load_time, int registration_time, int login_time)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			ApplicationMatrix applicationMatrix=new ApplicationMatrix();
			applicationMatrix.setDate_of_data(date_of_data);
			applicationMatrix.setTime_of_data(time_of_data);
			applicationMatrix.setInstall_time(install_time);
			applicationMatrix.setFirst_load_time(first_load_time);
			applicationMatrix.setLogin_time(login_time);
			applicationMatrix.setRegistration_time(registration_time);
			
			session.save(applicationMatrix);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			System.out.println("Rolling back");
			transaction.rollback();
			e.printStackTrace();
		} finally {
			System.out.println("closing session");
			session.close();
		}
		

	
	}

	public void retriveEmployee() 

	{ 

		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 
			 Query query = session.createQuery("from ApplicationMatrix"); 
			List<ApplicationMatrix> applicationMatrix = query.list(); 
			System.out.println("before generating the list");
			for (ApplicationMatrix am : applicationMatrix) 
			{ 
				System.out.println("printing the rows:\n");
				System.out.println("\n"
						+ am.getDate_of_data() 
						+ am.getTime_of_data()
						+ am.getFirst_load_time()
						+ am.getInstall_time()
						+ am.getLogin_time()
						+ am.getRegistration_time()); 
			}           
			transaction.commit(); 

		} catch (HibernateException e) { 

			transaction.rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
	
	public  void  deleteEmployee() 
	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try { 
			transaction = session.beginTransaction();
			String queryString = "from mytechub_matrix where serial_number = :serial_number";
			Query query = session.createQuery(queryString);
			query.setInteger("serial_number", 1);
			ApplicationMatrix applicationMatrix=(ApplicationMatrix) query.uniqueResult();
			session.delete(applicationMatrix);
			System.out.println("One employee is deleted!");
		
			  //Another way to write it
			/*
			 * String hql = "delete from Employee insurance where deptno = 30";
			  Query query1 = session.createQuery(hql);
			  int row = query1.executeUpdate();
			  if (row == 0){
			  System.out.println("Doesn't deleted any row!");
			  }
			  else{
			  System.out.println("Deleted Row: " + row);
			  }*/
		
		System.out.println("One employee is deleted!");
			
		} catch (HibernateException e) { 

			transaction .rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
	public  void  updateEmployee() 
	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try { 
			transaction = session.beginTransaction();
			String queryString = "from mytechub_matrix where serial_number = :serial_number";
			Query query = session.createQuery(queryString);
			query.setInteger("serial_number", 2);
			ApplicationMatrix applicationMatrix=(ApplicationMatrix) query.uniqueResult();
			applicationMatrix.setSerial_number(2);
			session.update(applicationMatrix);
			System.out.println("One employee is updated!");
		} catch (HibernateException e) { 

			transaction .rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
} 

