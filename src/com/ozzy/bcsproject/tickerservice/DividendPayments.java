package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement(name = "payments")
@XmlAccessorType(XmlAccessType.FIELD)
public class DividendPayments
{
    @XmlElement(name="dividend")
    private List<TickerDividend> payments = new ArrayList<>();
    public List<TickerDividend> getPayments() {
        return payments;
    }
    public void setPayments(List<TickerDividend> payments) {
        this.payments = payments;
    }
    public void addPrices(Collection<TickerDividend> payments) {
        this.payments.addAll(payments);
    }
}
