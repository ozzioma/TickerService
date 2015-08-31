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
public class YearlyPrices
{
    @XmlElement(name="yearlyprice")
    private List<YearlyPrice> prices = new ArrayList<>();
    public List<YearlyPrice> getPrices() {
        return prices;
    }
    public void setPrices(List<YearlyPrice> prices) {
        this.prices = prices;
    }
    public void addPrices(Collection<YearlyPrice> prices) {
        this.prices.addAll(prices);
    }
}
