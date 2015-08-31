package com.ozzy.bcsproject.tickerservice;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import javax.inject.Named;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozzy on 007, Jul 07, 2015.
 */

//@Repository
public class TickerRepository
{

//    private static DataSource getHiveDataSource(String dbName)
//    {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
//        dataSource.setUrl("jdbc:hive2://169.254.160.200:10000/" + dbName);
//        dataSource.setUsername("hadoop");
//        dataSource.setPassword("hadoop");
//        return dataSource;
//    }

    DriverManagerDataSource dataSource;

    public DriverManagerDataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(DriverManagerDataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<TickerPrice> getAllPrices(String symbol) throws SQLException
    {
        List<TickerPrice> buffer = new ArrayList<>();

        //DataSource ds = getHiveDataSource("finanalytics");
        String query1 = "select * from prices where symbol = ?";

        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            TickerPrice ticker = new TickerPrice(rows);
            buffer.add(ticker);
        }

        return buffer;
    }

    public List<TickerPrice> getPricesByYear(String symbol, int year) throws SQLException
    {
        List<TickerPrice> buffer = new ArrayList<>();

        //DataSource ds = getHiveDataSource("finanalytics");
        String query1 = "select * from prices where symbol = ? and year(tradedate)=?";

        Connection conn = dataSource.getConnection();//ds.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);
        ps.setInt(2, year);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            TickerPrice ticker = new TickerPrice(rows);
            buffer.add(ticker);
        }

        return buffer;
    }

    public List<TickerPrice> getPricesByMonth(String symbol, int year, int month) throws SQLException
    {
        List<TickerPrice> buffer = new ArrayList<>();

        //DataSource ds = getHiveDataSource("finanalytics");
        String query1 = "select * from prices where symbol = ? and year(tradedate)=? and month(tradedate)=?";

        Connection conn = dataSource.getConnection();//ds.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);
        ps.setInt(2, year);
        ps.setInt(3, month);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            TickerPrice ticker = new TickerPrice(rows);
            buffer.add(ticker);
        }

        return buffer;
    }


    public List<TickerDividend> getAllDividends(String symbol) throws SQLException
    {
        List<TickerDividend> buffer = new ArrayList<>();

        //DataSource ds = getHiveDataSource("finanalytics");
        String query1 = "select * from dividends where symbol = ?";

        Connection conn = dataSource.getConnection();//ds.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            TickerDividend ticker = new TickerDividend(rows);
            buffer.add(ticker);
        }

        return buffer;
    }

    public List<TickerDividend> getDividendsByYear(String symbol, int year) throws SQLException
    {
        List<TickerDividend> buffer = new ArrayList<>();

        //DataSource ds = getHiveDataSource("finanalytics");
        String query1 = "select * from dividends where symbol = ? and year(paydate)=?";

        Connection conn = dataSource.getConnection();//ds.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);
        ps.setInt(2, year);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            TickerDividend ticker = new TickerDividend(rows);
            buffer.add(ticker);
        }

        return buffer;
    }



    public List<YearlyPrice> getYearlyPrices(String symbol) throws SQLException
    {
        List<YearlyPrice> buffer = new ArrayList<>();

        String query1 = "select * from yearlyreturns where symbol = ? ";

        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query1);
        ps.setString(1, symbol);

        ResultSet rows = ps.executeQuery();

        while (rows.next())
        {
            YearlyPrice price = new YearlyPrice(rows);
            buffer.add(price);
        }

        return buffer;
    }


}


