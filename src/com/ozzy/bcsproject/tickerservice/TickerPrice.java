package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


@XmlRootElement
public class TickerPrice
{
    String stockExchange;
    String symbol;
    Date tradeDate;
    Double open;
    Double high;
    Double low;
    Double close;
    Double adjClose;
    int volume;

    public TickerPrice()
    {

    }

    public TickerPrice(ResultSet row)
    {
        this.fill(row);
    }

    public void fill(ResultSet row)
    {
        try
        {
            volume=row.getInt("volume");
            close=row.getDouble("close");
            adjClose=row.getDouble("adjclose");
            low=row.getDouble("low");
            high=row.getDouble("high");
            open=row.getDouble("open");
            tradeDate=row.getDate("tradedate");
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

    public Double getOpen()
    {
        return open;
    }

    public void setOpen(Double open)
    {
        this.open = open;
    }

    public Double getHigh()
    {
        return high;
    }

    public void setHigh(Double high)
    {
        this.high = high;
    }

    public Double getLow()
    {
        return low;
    }

    public void setLow(Double low)
    {
        this.low = low;
    }

    public Double getClose()
    {
        return close;
    }

    public void setClose(Double close)
    {
        this.close = close;
    }

    public Double getAdjClose()
    {
        return adjClose;
    }

    public void setAdjClose(Double adjclose)
    {
        this.adjClose = adjclose;
    }

    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int volume)
    {
        this.volume = volume;
    }

}

