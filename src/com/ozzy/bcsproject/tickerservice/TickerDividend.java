package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@XmlRootElement()
public class TickerDividend
{
    String stockExchange;
    String symbol;
    Date tradeDate;
    Double dividend;


    public TickerDividend()
    {

    }

    public TickerDividend(ResultSet row)
    {
        this.fill(row);
    }

    public void fill(ResultSet row)
    {
        try
        {
            dividend=row.getDouble("dividends");
            tradeDate=row.getDate("paydate");
            symbol=row.getString("symbol");
            //stockExchange=row.getString("stock_exchange");

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public String getStockExchange()
    {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange)
    {
        this.stockExchange = stockExchange;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public Date getTradeDate()
    {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate)
    {
        this.tradeDate = tradeDate;
    }

    public Double getDividend()
    {
        return dividend;
    }

    public void setDividend(Double dividend)
    {
        this.dividend = dividend;
    }




}
