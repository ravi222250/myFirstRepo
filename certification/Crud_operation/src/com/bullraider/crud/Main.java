package com.bullraider.crud;
import java.util.Iterator;
import java.util.List;

import com.bullraider.crud.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		m.saveEmployee("Rex", "MGR", 30000, 10);
		m.saveEmployee("Raj", "CLERK", 10000, 30);
		m.saveEmployee("Mike", "SALESMAN", 8000, 10);
		m.retriveEmployee();
		m.deleteEmployee();
		m.updateEmployee();
	}
	public void saveEmployee(String ename,String job,int sal,int deptno)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Employee emp=new Employee();
			emp.setEname(ename);
			emp.setJob(job);
			emp.setSal(sal);
			emp.setDeptno(deptno);
			session.save(emp);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	public void retriveEmployee() 

	{ 

		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 
						List employee = session.createQuery("from Employee").list(); 
			
			for (Iterator iterator = employee.iterator(); iterator.hasNext();) 
			{ 
				Employee employee1 = (Employee) iterator.next(); 
				System.out.println(employee1.getEmpno()+"  "+employee1.getEname()+"  "+ employee1.getJob()+"   "+employee1.getSal()+"   "+employee1.getDeptno()); 
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
			String queryString = "from Employee where deptno = :deptno";
			Query query = session.createQuery(queryString);
			query.setInteger("deptno", 30);
			Employee employee=(Employee) query.uniqueResult();
			session.delete(employee);
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
			String queryString = "from Employee where sal = :sal";
			Query query = session.createQuery(queryString);
			query.setInteger("sal", 8000);
			Employee employee=(Employee) query.uniqueResult();
			employee.setSal(11000);
			session.update(employee);
			System.out.println("One employee is updated!");
		} catch (HibernateException e) { 

			transaction .rollback(); 

			e.printStackTrace(); 

		} finally { 

			session.close(); 

		} 
	}
} 

