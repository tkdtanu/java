package com.tkd.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.tkd.hibernate.model.Stock;
import com.tkd.hibernate.model.StockDailyRecord;
import com.tkd.hibernate.model.StockDetail;
import com.tkd.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		loadData(session);
		
		System.out.println("Transaction Done");
	}
	
	private static void loadData(Session session) {
		Stock stock = new Stock();

		stock.setStockCode("7058");
		stock.setStockName("INFOSYS");

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.7"));
		stockDailyRecords.setPriceClose(new Float("1.9"));
		stockDailyRecords.setPriceChange(new Float("11.0"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());
		stockDailyRecords.setStock(stock);
		
		stock.getStockDailyRecords().add(stockDailyRecords);

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Infosys IT Firm");
		stockDetail.setCompDesc("IT");
		stockDetail.setRemark("abcd");
		stockDetail.setListedDate(new Date());
		

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		
		Stock stock1 = new Stock();

		stock1.setStockCode("7059");
		stock1.setStockName("TAVANT");

		StockDailyRecord stockDailyRecords1 = new StockDailyRecord();
		stockDailyRecords1.setPriceOpen(new Float("1.2"));
		stockDailyRecords1.setPriceClose(new Float("1.1"));
		stockDailyRecords1.setPriceChange(new Float("10.0"));
		stockDailyRecords1.setVolume(3000000L);
		stockDailyRecords1.setDate(new Date());
		stockDailyRecords1.setStock(stock1);
		
		stock1.getStockDailyRecords().add(stockDailyRecords1);

		StockDetail stockDetail1 = new StockDetail();
		stockDetail1.setCompName("TAVANT Technology");
		stockDetail1.setCompDesc("IT Firm");
		stockDetail1.setRemark("Sarvesh");
		stockDetail1.setListedDate(new Date());
		

		stock.setStockDetail(stockDetail1);
		stockDetail1.setStock(stock1);

		session.save(stock1);
		session.getTransaction().commit();
	}

}
