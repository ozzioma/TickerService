package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement(name = "prices")
@XmlAccessorType(XmlAccessType.FIELD)
public class TickerPrices
{
    @XmlElement(name="quote")
    private List<TickerPrice> prices = new ArrayList<>();
    public List<TickerPrice> getPrices() {
        return prices;
    }
    public void setPrices(List<TickerPrice> prices) {
        this.prices = prices;
    }
    public void addPrices(Collection<TickerPrice> prices) {
        this.prices.addAll(prices);
    }
}


