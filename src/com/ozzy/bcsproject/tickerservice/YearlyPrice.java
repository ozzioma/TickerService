package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@XmlRootElement
public class YearlyPrice
{
    String symbol;
    Date tradeDate;
    Double adjClose;
    Double returnpct;
    Double prevadjClose;

    public  YearlyPrice()
    {

    }

    public  YearlyPrice(ResultSet row)
    {
        this.fill(row);
    }

    public void fill(ResultSet row)
    {
        try
        {
            adjClose = row.getDouble("adjclose");
            returnpct = row.getDouble("returnpct");
            prevadjClose = row.getDouble("prevadjclose");
            tradeDate = row.getDate("tradedate");
            symbol = row.getString("symbol");
            //stockExchange=row.getString("stock_exchange");


        } catch (SQLException e)
        {
            e.printStackTrace();
        }

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

    public Double getAdjClose()
    {
        return adjClose;
    }

    public void setAdjClose(Double adjClose)
    {
        this.adjClose = adjClose;
    }

    public Double getReturnpct()
    {
        return returnpct;
    }

    public void setReturnpct(Double returnpct)
    {
        this.returnpct = returnpct;
    }

    public Double getPrevadjClose()
    {
        return prevadjClose;
    }

    public void setPrevadjClose(Double prevadjClose)
    {
        this.prevadjClose = prevadjClose;
    }
}
